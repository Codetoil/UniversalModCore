package cam72cam.umc.impl.entity.custom;

import cam72cam.umc.impl.entity.Player;
import cam72cam.umc.impl.item.ClickResult;

public interface IClickable {
    IClickable NOP = (player, hand) -> ClickResult.PASS;

    static IClickable get(Object o) {
        if (o instanceof IClickable) {
            return (IClickable) o;
        }
        return NOP;
    }

    /** Called when entity is interacted with */
    ClickResult onClick(Player player, Player.Hand hand);
}
