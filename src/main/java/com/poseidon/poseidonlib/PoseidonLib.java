package com.poseidon.poseidonlib;

import org.slf4j.Logger;                                                    // slf4j logger
import org.slf4j.LoggerFactory;                                             // logger factory

//? if >=1.21 {
/*import net.neoforged.bus.api.IEventBus;                                     // NeoForge: mod bus injected into the ctor
import net.neoforged.fml.ModContainer;                                      // NeoForge: container passed to the ctor
import net.neoforged.fml.common.Mod;                                        // @Mod annotation
*///?} else {
import net.minecraftforge.fml.common.Mod;                                   // @Mod annotation - marks this as the mod's main class
//?}

@Mod(PoseidonLib.MODID)                                                     // declares this class as the mod with id poseidonlib
public final class PoseidonLib {

    public static final String MODID = "poseidonlib";                       // mod id constant - mods.toml must match this
    public static final Logger LOGGER = LoggerFactory.getLogger("PoseidonLib");

    //? if >=1.21 {
    /*public PoseidonLib(ModContainer container, IEventBus modBus) {          // NeoForge ctor - container + mod bus are injected
        LOGGER.info("Poseidon Lib initialized");
    }
    *///?} else {
    public PoseidonLib() {                                                  // constructor - runs once during mod construction
        LOGGER.info("Poseidon Lib initialized");
    }
    //?}
}
