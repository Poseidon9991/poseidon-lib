# Contributing to Poseidon Lib

## Layout

- `src/main/` — shared sources; `//?` comments gate loader/version differences
- `versions/1.20.1` — Forge node | `versions/1.21.1` — NeoForge node
- Version-specific values live in each node's `gradle.properties`

## Rules

- Keep shared code free of loader-specific imports unless wrapped in `//?` guards
- Conventional commits (`feat:`/`fix:`/`docs:`/`chore:`)
- Compile both nodes before merging: `./gradlew :1.20.1:build :1.21.1:build`
