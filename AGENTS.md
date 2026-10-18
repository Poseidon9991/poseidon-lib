# Poseidon Lib

Shared utility library for Poseidon's Minecraft mods.

## Build & verify

- Forge node: `gradlew :1.20.1:build`
- NeoForge node: `gradlew :1.21.1:build`
- No test sources — `check` is compile-only
- Gradle JVM args: `-Xmx3G`, daemon disabled

## Conventions

- Loader/version differences use Stonecutter `//?` comment conditions
- `ForgeRegistries.getKey` is `@Nullable` — null-guard before use
- Commits are authored by the repo maintainers
