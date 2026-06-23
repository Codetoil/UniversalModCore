package cam72cam.mod.text;

import java.util.Optional;
import java.util.function.Consumer;

import cam72cam.mod.entity.Player;

import javax.annotation.Nullable;

/** API not finalized use at your own risk */
public abstract class Command {

    protected Command() {

    }

    public abstract String getPrefix();

    public abstract String getUsage();


	/**
	 * <pre>
	 * Returns <code>PermissionLevel.LEVEL4</code> by default.
	 * opRequired() returned 4 when true 2 when false.
	 * See {@link Command.PermissionLevel PermissionLevel} for possible return values.
	 * </pre>
	 */
	public int getRequiredPermissionLevel() {
		return PermissionLevel.LEVEL4;
	}

	/** Executed only on server-side */
	public abstract boolean execute(Consumer<IPlayerMessage> sender, @Nullable Player player, String[] args);

	public static class PermissionLevel {
		/** Everyone has this level */
		public static final int NONE = 0;
		/** OP-Level 1 */
		public static final int LEVEL1 = 1;
		/** OP-Level 2 */
		public static final int LEVEL2 = 2;
		/** OP-Level 3 */
		public static final int LEVEL3 = 3;
		/** OP-Level 4 */
		public static final int LEVEL4 = 4;
	}

}
