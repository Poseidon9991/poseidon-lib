# Poseidon Lib

Shared utilities for Poseidon's Minecraft mods — datapack JSON loader base,
reload-listener wiring, entity predicates and common building blocks.

Co-maintained by [Poseidon9991](https://github.com/Poseidon9991) and
[hayasanjo0-spec](https://github.com/hayasanjo0-spec).

## Loaders

| Minecraft | Loader | Node |
|---|---|---|
| 1.20.1 | Forge 47.4+ | `versions/1.20.1` |
| 1.21.1 | NeoForge 21.1+ | `versions/1.21.1` |

Built with [Stonecutter](https://stonecutter.kikugie.dev/) — one shared
`src/` with `//?` version comment conditions, one output jar per node.

## What's inside

- `data/JsonReloadListener` — abstract datapack JSON loader
  (`data/<modid>/<dir>/*.json`) with per-file error isolation and
  `beginReload`/`endReload` hooks.
- `event/PoseidonReloadListeners` — one call registers a reload listener
  on the right loader game bus (Forge/NeoForge).
- `util/EntityPredicates` — monster/raider/villager/golem/player/targetable
  checks for AI and targeting code.

## Build

```bash
./gradlew :1.20.1:build    # Forge jar
./gradlew :1.21.1:build    # NeoForge jar
```

Artifacts land in `versions/<node>/build/libs/`.

## Usage in a consuming mod

```java
public MyMod() {
    PoseidonReloadListeners.register(new MyLoadoutManager());
}
```

```java
public class MyLoadoutManager extends JsonReloadListener {
    public MyLoadoutManager() { super("class_loadouts"); }

    @Override
    protected void applyOne(ResourceLocation id, JsonElement json) {
        // parse a single data/<modid>/class_loadouts/<name>.json file
    }
}
```

## License

MIT — see [LICENSE](LICENSE).
