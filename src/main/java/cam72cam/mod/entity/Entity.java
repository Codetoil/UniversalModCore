package cam72cam.mod.entity;

import cam72cam.mod.entity.boundingbox.IBoundingBox;
import cam72cam.mod.math.Vec3d;
import cam72cam.mod.math.Vec3i;
import cam72cam.mod.world.World;

import java.util.List;
import java.util.UUID;

/**
 * The base entity abstraction that wraps MC entities.
 * <p>
 * TODO: Make sure we are setting prevRot/Loc stuff correctly.  Should it only be changed on a tick processing the movement?
 */
public class Entity {

    public World getWorld() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /** UUID that persists across loads */
    public UUID getUUID() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /* Position / Rotation */
    public Vec3i getBlockPosition() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public Vec3d getPosition() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public void setPosition(Vec3d pos) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public Vec3d getVelocity() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public void setVelocity(Vec3d motion) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public float getRotationYaw() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public float getRotationPitch() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /**
     * @see CustomEntity#getRotationRoll() 
     */
    public float getRotationRoll() {
        return 0f;
    }

    public float getRotationYaw(float partialTicks) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public float getRotationPitch(float partialTicks) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /**
     * @see CustomEntity#getRotationRoll(float) 
     */
    public float getRotationRoll(float partialTicks) {
        return 0;
    }

    public void setRotationYaw(float yaw) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public void setRotationPitch(float pitch) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /**
     * @see CustomEntity#setRotationRoll(float) 
     */
    public void setRotationRoll(float roll) {
    }

    public float getPrevRotationYaw() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public float getPrevRotationPitch() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /**
     * @see CustomEntity#getPrevRotationRoll()
     */
    public float getPrevRotationRoll() {
        return 0f;
    }

    Vec3d eyeCache;
    public Vec3d getPositionEyes() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }


    /* Casting */

    /** Wrapper around as(Player) */
    public Player asPlayer() {
        return as(Player.class);
    }

    /** Casting helper with instanceof check */
    public <T extends Entity> T as(Class<T> type) {
        if (type.isInstance(this)) {
            return (T) this;
        }
        return null;
    }

    public boolean isVillager() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public boolean isMob() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public boolean isPlayer() {
        return this instanceof Player;
    }

    public boolean isLiving() {
        return this instanceof Living;
    }


    public void kill() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public final boolean isDead() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public int getTickCount() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public int getPassengerCount() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public void addPassenger(Entity passenger) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public boolean isPassenger(Entity passenger) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public void removePassenger(Entity entity) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public List<Entity> getPassengers() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public Entity getRiding() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public IBoundingBox getBounds() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public float getRotationYawHead() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public Vec3d getLastTickPos() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public void startRiding(Entity entity) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /** If riding this entity, what modifier should be applied to the overall sound level */
    public float getRidingSoundModifier() {
        return 1;
    }

    /** Damage entity directly (bypassing armor) */
    public void directDamage(DamageType type, double damage) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    protected void createExplosion(Vec3d pos, float size, boolean damageTerrain) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /** Non persistent ID.  Should use UUID instead */
    public int getId() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }
}
