package cam72cam.mod;

import cam72cam.mod.resource.Identifier;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public interface UMC {
    /** Register a mod, must happen before UMC is loaded! */
    void register(Mod ctr);

    /** Returns -1 if server side */
    int getGPUTextureSize();

    List<Mod> getLoadedMods();

    Path getConfigDir();

    void debug(String msg, Object... params);
    void info(String msg, Object... params);
    void warn(String msg, Object... params) ;
    void error(String msg, Object... params);
    void catching(Throwable ex, String msg, Object... params);
    void catching(Throwable ex);

    File cacheFile(Identifier id);

    String loaderBrand();
    int mcVersion();
    String semanticVersion();
    boolean isDevelopmentEnvironment();

    /** Implement this to create a UMC mod */
    abstract class Mod {
        public abstract UMC umcInstance();
        public abstract String modID();

        /** Called both server and client side with a given event */
        public abstract void commonEvent(ModEvent event);
        /** Called client side with a given event */
        public abstract void clientEvent(ModEvent event);
        /** Called server side with a given event */
        public abstract void serverEvent(ModEvent event);

        /** Get config file for filename */
        public final Path getConfig(String fname) {
            return Paths.get(umcInstance().getConfigDir().toString(), fname);
        }

        /* Standard logging functions */

        public void debug(String msg, Object...params) {
            umcInstance().debug(msg, params);
        }
        public void info(String msg, Object...params) {
            umcInstance().info(msg, params);
        }
        public void warn(String msg, Object...params) {
            umcInstance().warn(msg, params);
        }
        public void error(String msg, Object...params) {
            umcInstance().error(msg, params);
        }
        public void catching(Throwable ex) {
            umcInstance().catching(ex);
        }
    }
}
