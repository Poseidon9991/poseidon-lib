package com.poseidon.poseidonlib.event;

import net.minecraft.server.packs.resources.PreparableReloadListener;      // reload listener interface

import java.util.List;                                                     // listener list
import java.util.concurrent.CopyOnWriteArrayList;                          // safe iteration during registration

/**
 * Wires datapack reload listeners onto the loader's game event bus.
 * <p>
 * Consuming mods call {@link #register(PreparableReloadListener)} once in
 * their mod constructor; the first call lazily subscribes the forwarding
 * handler to the game bus, so listeners added later still land in the same
 * server-resource reload cycle.
 */
public final class PoseidonReloadListeners {

    private static final List<PreparableReloadListener> LISTENERS = new CopyOnWriteArrayList<>();
    private static boolean hooked;

    private PoseidonReloadListeners() {
    }

    public static synchronized void register(PreparableReloadListener listener) {
        LISTENERS.add(listener);
        if (!hooked) {
            hooked = true;
            //? if >=1.21 {
            /*net.neoforged.neoforge.common.NeoForge.EVENT_BUS
                    .addListener(PoseidonReloadListeners::onAddReloadListeners);
            *///?} else {
            net.minecraftforge.common.MinecraftForge.EVENT_BUS
                    .addListener(PoseidonReloadListeners::onAddReloadListeners);
            //?}
        }
    }

    //? if >=1.21 {
    /*private static void onAddReloadListeners(net.neoforged.neoforge.event.AddReloadListenerEvent event) {
        LISTENERS.forEach(event::addListener);
    }
    *///?} else {
    private static void onAddReloadListeners(net.minecraftforge.event.AddReloadListenerEvent event) {
        LISTENERS.forEach(event::addListener);
    }
    //?}
}
