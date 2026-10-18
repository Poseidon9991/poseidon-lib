# Usage

## Datapack loader

```java
public class MyTables extends JsonReloadListener {
    public MyTables() { super("my_tables"); }

    @Override
    protected void applyOne(ResourceLocation id, JsonElement json) {
        // one data/<modid>/my_tables/<name>.json file
    }
}
```

Register during mod construction:

```java
PoseidonReloadListeners.register(new MyTables());
```

## Entity predicates

```java
if (EntityPredicates.isHostile(entity)) { /* engage */ }
if (EntityPredicates.isVillager(entity)) { /* protect */ }
```
