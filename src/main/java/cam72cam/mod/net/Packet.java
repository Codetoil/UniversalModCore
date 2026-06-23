package cam72cam.mod.net;

import cam72cam.mod.entity.Entity;
import cam72cam.mod.entity.Player;
import cam72cam.mod.math.Vec3d;
import cam72cam.mod.serialization.TagSerializer;
import cam72cam.mod.world.World;

/**
 * Packet abstraction and registration
 * @see TagSerializer
 */
public abstract class Packet {

    /** Called after deserialization */
    protected abstract void handle();

    /** Only valid during handle */
    protected abstract World getWorld();

    /** Only valid during handle */
    protected abstract Player getPlayer();

    /** Send from server to all players around this pos */
    public abstract void sendToAllAround(World world, Vec3d pos, double distance);

    /** Send from server to any player who is within viewing (entity tracker update) distance of the entity */
    public abstract void sendToObserving(Entity entity);

    /** Send from client to server */
    public abstract void sendToServer();

    /** Broadcast to all players from server */
    public abstract void sendToAll();

	/** Send from server to player */
	public abstract void sendToPlayer(Player player);
}
