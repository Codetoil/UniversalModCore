package cam72cam.mod.entity.sync;

import cam72cam.mod.UMC;
import cam72cam.mod.entity.CustomEntity;
import cam72cam.mod.net.Packet;
import cam72cam.mod.serialization.SerializationException;
import cam72cam.mod.serialization.TagCompound;
import cam72cam.mod.serialization.TagField;

/** TagCompound that auto-serializes an entity's @TagSync fields from server to client */
public class EntitySync extends TagCompound {
    /** Track properties on entity */
    public EntitySync(CustomEntity entity) {
        super();
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public void setInterval(int interval) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /** Perform synchronization */
    public void send() throws SerializationException {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /** Receive update (should only be called from packets) */
    public void receive(TagCompound sync) throws SerializationException {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public static class EntitySyncPacket extends Packet {
        @TagField
        CustomEntity target;
        @TagField
        private TagCompound info;

        public EntitySyncPacket() {}

        public EntitySyncPacket(CustomEntity entity, TagCompound sync) {
            this.target = entity;
            this.info = sync;
        }

        @Override
        public void handle() {
            if (target != null) {
                try {
                    target.sync.receive(info);
                } catch (SerializationException e) {
                    UMC.catching(e, "Invalid sync payload for %s: %s", target, info);
                }
            }
        }
    }
}
