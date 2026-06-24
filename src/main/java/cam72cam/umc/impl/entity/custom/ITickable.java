package cam72cam.umc.impl.entity.custom;

public interface ITickable {
    ITickable NOP = () -> {

    };

    static ITickable get(Object o) {
        if (o instanceof ITickable) {
            return (ITickable) o;
        }
        return NOP;
    }

    /** onUpdate */
    void onTick();
}
