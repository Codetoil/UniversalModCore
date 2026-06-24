package cam72cam.umc.impl.serialization;

public class SerializationException extends Exception {
    public SerializationException(String msg, Throwable parent) {
        super(msg, parent);
    }

    public SerializationException(String msg) {
        super(msg);
    }
}
