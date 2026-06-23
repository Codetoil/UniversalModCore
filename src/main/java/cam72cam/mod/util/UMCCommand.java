package cam72cam.mod.util;

import java.util.*;
import java.util.function.Consumer;

import cam72cam.mod.UMC;
import cam72cam.mod.entity.Player;
import cam72cam.mod.text.Command;
import cam72cam.mod.text.IPlayerMessage;
import cam72cam.mod.world.World;

import javax.annotation.Nullable;

public abstract class UMCCommand extends Command {
    @Override
    public String getPrefix() {
        return UMC.MODID;
    }

    @Override
    public String getUsage() {
        return "Usage: " + UMC.MODID + " entity list [server dim] | chunk [[list|debug] [all|cx cz]] [server dim] | ticket [list|debug] [server dim]";
    }

    @Override
	public boolean execute(Consumer<IPlayerMessage> sender, @Nullable Player player, String[] rawArgs) {
		List<String> args = new ArrayList<>(Arrays.asList(rawArgs));

		World world;
		if (player != null) {
			world = player.getWorld();
		} else {
			try {
				int dimId = Integer.parseInt(args.removeLast());
				world = World.get(dimId, false);
				if (world == null) {
					sender.accept(UMC.getInstance().getPlayerMessageFactory().direct(String.format("Dimension '%d' is not loaded or does not exist.", dimId)));
					return false;
				}
			} catch (IndexOutOfBoundsException | NumberFormatException ex) {
				sender.accept(UMC.getInstance().getPlayerMessageFactory().direct("Dimension must be a number!"));
				return false;
			}
		}

		if (args.isEmpty()) {
			return false;
		}

		String cmd = args.removeFirst();
		switch (cmd) {
			case "entity":
				if (args.isEmpty()) {
					return false;
				}
				String list = args.removeFirst();
				if (list.equals("list")) {
					sendWorldEntities(world, sender);
					return true;
				}
				return false;
			case "chunk":
				return sendChunkInfo(world, sender, player, args);
			case "ticket":
				return sendTicketInfo(world, sender, player, args);
			default:
				return false;
		}
	}

	protected abstract boolean sendTicketInfo(World world, Consumer<IPlayerMessage> sender, @Nullable Player player, List<String> args);

	protected abstract boolean sendChunkInfo(World world, Consumer<IPlayerMessage> sender, @Nullable Player player, List<String> args);

	protected abstract void sendWorldEntities(World world, Consumer<IPlayerMessage> sender);
}
