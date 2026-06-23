package cam72cam.mod.text;

public interface IPlayerMessageFactory {
    IPlayerMessage direct(String msg);
    IPlayerMessage translate(String msg, Object... objects);
    IPlayerMessage url(String url);
}
