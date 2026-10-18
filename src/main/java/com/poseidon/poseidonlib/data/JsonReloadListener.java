package com.poseidon.poseidonlib.data;

import com.google.gson.Gson;                                                // shared gson instance
import com.google.gson.JsonElement;                                         // parsed json root
import com.google.gson.JsonParseException;                                  // malformed json
import com.poseidon.poseidonlib.PoseidonLib;                                // LOGGER
import net.minecraft.resources.ResourceLocation;                            // datapack file id
import net.minecraft.server.packs.resources.ResourceManager;                // pack resources
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener; // vanilla json loader base
import net.minecraft.util.profiling.ProfilerFiller;                         // reload profiler

import java.util.Map;                                                       // file map

/**
 * Base class for datapack JSON loaders shared by Poseidon mods.
 * <p>
 * Extend it, pass the datapack directory (e.g. {@code "class_loadouts"})
 * to the super constructor, implement {@link #applyOne} for a single file,
 * then wire it through {@link com.poseidon.poseidonlib.event.PoseidonReloadListeners#register}.
 * <p>
 * A malformed file is logged and skipped instead of failing the whole
 * datapack reload.
 */
public abstract class JsonReloadListener extends SimpleJsonResourceReloadListener {

    private static final Gson GSON = new Gson();

    protected JsonReloadListener(String directory) {
        super(GSON, directory);
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> files,
                         ResourceManager manager, ProfilerFiller profiler) {
        beginReload();
        int loaded = 0;
        int failed = 0;
        for (Map.Entry<ResourceLocation, JsonElement> entry : files.entrySet()) {
            try {
                applyOne(entry.getKey(), entry.getValue());
                loaded++;
            } catch (JsonParseException | IllegalArgumentException e) {
                failed++;
                PoseidonLib.LOGGER.warn("failed to load {}: {}", entry.getKey(), e.getMessage());
            }
        }
        PoseidonLib.LOGGER.info("[{}] loaded {} file(s), {} failed", getName(), loaded, failed);
        endReload();
    }

    /** Called before any file is applied - clear cached state here. */
    protected void beginReload() {
    }

    /** Apply a single parsed datapack file. Throw to mark it as failed. */
    protected abstract void applyOne(ResourceLocation id, JsonElement json);

    /** Called after every file was applied - bake indices/snapshots here. */
    protected void endReload() {
    }
}
