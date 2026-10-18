# Development flow

1. Feature or fix lands on a branch, opened as a PR against `main`
2. Both maintainers can review; PRs merge once both nodes compile
3. Shared `src/` is the single source of truth — never edit
   `versions/<node>/` sources directly, only its `gradle.properties`
4. Bump `mod_version` in the node's `gradle.properties` on release
