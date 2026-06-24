package cam72cam.umc.impl.block;

import cam72cam.umc.impl.util.Facing;

public interface IRedstoneProvider {
    int getStrongPower(Facing from);

    int getWeakPower(Facing from);
}
