package cam72cam.mod.entity;

import cam72cam.mod.entity.boundingbox.BoundingBox;
import cam72cam.mod.entity.boundingbox.IBoundingBox;
import cam72cam.mod.entity.custom.IRidable;
import cam72cam.mod.entity.custom.IWorldData;
import cam72cam.mod.serialization.TagCompound;
import cam72cam.mod.serialization.TagField;
import cam72cam.mod.serialization.TagMapper;
import cam72cam.mod.entity.custom.*;
import cam72cam.mod.math.Vec3d;
import cam72cam.mod.net.Packet;
import cam72cam.mod.serialization.*;
import cam72cam.mod.util.SingleCache;

import java.util.*;

/** Internal class which extends MC's Entity.  Do not use directly */
public class ModdedEntity {
    // Reference to the entity that this is representing
    private CustomEntity self;

    // Keeps track of where passengers are within this entity
    @TagField(value = "passengers", mapper = PassengerMapper.class)
    private Map<UUID, Vec3d> passengerPositions = new HashMap<>();

    //Data storage
    @TagField
    private float roll = 0;
    @TagField
    private float prevRoll = 0;

    // All of the known seats attached to this entity
    private final List<SeatEntity> seats = new ArrayList<>();

    // Registry name of self
    private String type;

    // Views of self that implement different interfaces
    private IWorldData iWorldData;
    private ITickable iTickable;
    private IClickable iClickable;
    private IKillable iKillable;
    private IRidable iRidable;
    private ICollision iCollision;

    private final SingleCache<IBoundingBox, BoundingBox> cachedCollisionBB = new SingleCache<>(BoundingBox::from);
    private final SingleCache<IBoundingBox, BoundingBox> cachedRenderBB = new SingleCache<>(internal -> {
        BoundingBox bb = BoundingBox.from(internal);
        /*
         So why do we wrap this with a new AABB here instead of passing the BB straight through?
         Good question
         Certain mods (like IR) use custom bounding boxes that do some really funky shit to break
         the axis constraint.  We don't care about that when rendering, just want a worst-case sized BB
        */
        return new BoundingBox(bb.minX, bb.minY, bb.minZ, bb.maxX, bb.maxY, bb.maxZ);
    });

    Pair<String, TagCompound> refusedToJoin = null;

    /** Setup self if we have not done so already.  This happens during entity data load. */
    protected final void initSelf(String type) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public CustomEntity getSelf() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /* IWorldData */

    /**
     * Deserializes data into this, self, and calls self.load.
     * @see IWorldData
     */
    private void load(TagCompound data) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /**
     * Inverse of load
     * @see IWorldData
     * @see #load
     */
    private void save(TagCompound data) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /** Passenger offset from entity center rotated by entity yaw */
    private Vec3d calculatePassengerOffset(Entity passenger) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /** Rotate offset around entity center by entity yaw and add entity center */
    private Vec3d calculatePassengerPosition(Vec3d offset) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /**
     * Returns passengers that are riding via seats
     * @see CustomEntity#getPassengers
     */
    List<Entity> getActualPassengers() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /**
     * Helper function that updates a seat's position, and it's rider's position
     * 
     * @see SeatEntity#updatePassenger 
     */
    void updateSeat(SeatEntity seat) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /** @see CustomEntity#isPassenger */
    boolean isPassenger(Entity passenger) {
        return getActualPassengers().stream().anyMatch(p -> p.getUUID().equals(passenger.getUUID()));
    }

    public void moveRiderTo(Entity entity, CustomEntity other) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /**
     * @see IRidable#onDismountPassenger
     * @see SeatEntity#removePassenger
     */
    void removeSeat(SeatEntity seat) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /** @see CustomEntity#removePassenger */
    void removePassenger(Entity passenger) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public int getPassengerCount() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /*
    Passenger helpers
     */

    private static class PassengerMapper implements TagMapper<Map<UUID, Vec3d>> {
        @Override
        public TagAccessor<Map<UUID, Vec3d>> apply(Class<Map<UUID, Vec3d>> type, String fieldName, TagField tag) {
            return new TagAccessor<>(
                (d, o) -> d.setMap(fieldName, o, UUID::toString, (Vec3d pos) -> new TagCompound().setVec3d("pos", pos)),
                d -> d.getMap(fieldName, UUID::fromString, t -> t.getVec3d("pos"))
            );
        }
    }

    public static class PassengerPositionsPacket extends Packet {
        @TagField
        private Entity target;

        @TagField(mapper = PassengerMapper.class)
        private Map<UUID, Vec3d> passengerPositions = new HashMap<>();

        public PassengerPositionsPacket() {}

        public PassengerPositionsPacket(ModdedEntity target) {
            throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
        }

        @Override
        public void handle() {
            throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
        }
    }

    public static class PassengerSeatPacket extends Packet {
        @TagField
        private CustomEntity target;
        @TagField
        private Entity rider;

        public PassengerSeatPacket() {}

        public PassengerSeatPacket(CustomEntity target, Entity rider) {
            this.target = target;
            this.rider = rider;
        }


        @Override
        protected void handle() {
            if (target != null && rider != null) {
                target.addPassenger(rider);
            }
        }
    }

    /*
     * TODO!!!
     */
    /*
    //@Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return true;
        }
        return false;//super.hasCapability(energyCapability, facing);
    }

    @SuppressWarnings("unchecked")
	//@Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return (T) cargoItems;
        }
        return null;//super.getCapability(energyCapability, facing);
    }

	@Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
            return true;
        }
        return super.hasCapability(capability, facing);
    }

    @SuppressWarnings("unchecked")
	@Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
            return (T) theTank;
        }
        return super.getCapability(capability, facing);
    }
     */
}
