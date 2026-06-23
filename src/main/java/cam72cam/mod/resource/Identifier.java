package cam72cam.mod.resource;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/** Pair(domain, path).  Used to reference registry entries and resource pack contents alike */
public class Identifier {

    /** Parse identifier from string (domain:path) */
    public Identifier(String ident) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /** Standard constructor */
    public Identifier(String domain, String path) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public String getDomain() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public String getPath() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /**
     * Get another path within this identifier's directory
     *
     * Example:
     * this: domain:some/path/object.file
     * path: other.file
     * returns domain:some/path/other.file
     */
    public Identifier getRelative(String path) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    /**
     * @return This identifier if can load, fallback if it can't
     */
    public Identifier getOrDefault(Identifier fallback){
        return this.canLoad() ? this : fallback;
    }

    /** If the resource this identifier points to exists in any form */
    public boolean canLoad() {
        try (InputStream stream = this.getResourceStream()) {
            return stream != null;
        } catch (IOException e){
            return false;
        }
    }

    /** @return all resources this identifier points at (jar first) */
    public List<InputStream> getResourceStreamAll() throws IOException {
        return Data.proxy.getResourceStreamAll(this);
    }

    /**
     * @return the first resource this identifier points at (mod jar, mod config zip, resource pack)
     */
    public InputStream getResourceStream() throws IOException {
        return Data.proxy.getResourceStream(this);
    }
    /**
     * @return the last resource this identifier points at (mod jar, mod config zip, resource pack)
     */
    public InputStream getLastResourceStream() throws IOException {
        return Data.proxy.getLastResourceStream(this);
    }

    public static class InputStreamMod extends FilterInputStream {
        public final long time;

        public InputStreamMod(InputStream inputStream, long modTime) {
            super(inputStream);
            this.time = modTime;
        }
    }
}
