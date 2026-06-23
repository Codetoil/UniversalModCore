package cam72cam.mod;

public abstract class UMCLogger {
    public abstract void debug(String msg, Object... params);

    public abstract void info(String msg, Object... params);

    public abstract void warn(String msg, Object... params);

    public abstract void error(String msg, Object... params);

    public void catching(Throwable ex, String msg, Object... params) {
        error(msg, params);
        catching(ex);
    }

    public abstract void catching(Throwable ex);
}
