package cam72cam.mod.entity;

import cam72cam.mod.resource.Identifier;

/**
 * Damage type wrapper
 * <p>
 * Note that in order to make this work on 1.21.1 and later, <code>DamageType</code>s should be created, at the latest, at the RELOAD phase
 */
public final class DamageType {
    public static final DamageType FIRE = getOrCreate("in_fire");
    public static final DamageType PROJECTILE = getOrCreate("arrow");
    public static final DamageType EXPLOSION = getOrCreate("explosion");
    public static final DamageType MAGIC = getOrCreate("magic");
    public static final DamageType OTHER = getOrCreate("other");

    public static DamageType getOrCreate(String cause) {
        return getOrCreate(new Identifier(cause));
    }

    public static DamageType getOrCreate(Identifier cause) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    private DamageType(String cause) {
        this(new Identifier(cause));
    }

    private DamageType(Identifier cause) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }
}
