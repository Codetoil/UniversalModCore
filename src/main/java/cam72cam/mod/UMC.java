package cam72cam.mod;

import cam72cam.mod.registry.Registries;
import cam72cam.mod.resource.Identifier;
import cam72cam.mod.text.IPlayerMessageFactory;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

/** UMC Mod, do not touch... */
public abstract class UMC {
    public static final String MODID = "universalmodcore";
    public static final String NAME = "UniversalModCore";
    public static final String VERSION = "1.4.0";
    protected static UMC instance;

    public static UMC getInstance()
    {
        return instance;
    }

    public abstract Registries getRegistries();

    public abstract IPlayerMessageFactory getPlayerMessageFactory();

    public abstract UMCLogger getLogger();

    public abstract UMCPhase getPhase();

    /** Implement this to create a UMC mod */
    public static abstract class Mod {
        public abstract String modID();

        /** Called both server and client side with a given event */
        public abstract void commonEvent(UMCPhase event);
        /** Called client side with a given event */
        public abstract void clientEvent(UMCPhase event);
        /** Called server side with a given event */
        public abstract void serverEvent(UMCPhase event);

        /** Get config file for filename */
        public abstract Path getConfig(String fname);

        /* Standard logging functions */

        public static void debug(String msg, Object...params) {
            getInstance().getLogger().debug(msg, params);
        }
        public static void info(String msg, Object...params) {
            getInstance().getLogger().info(msg, params);
        }
        public static void warn(String msg, Object...params) {
            getInstance().getLogger().warn(msg, params);
        }
        public static void error(String msg, Object...params) {
            getInstance().getLogger().error(msg, params);
        }
        public static void catching(Throwable ex) {
            getInstance().getLogger().catching(ex);
        }
    }

    /** Returns -1 if server side */
    public abstract int getGPUTextureSize();

    public abstract List<Mod> getLoadedMods();

    /** Get a file for name in the UMC cache dir. */
    public abstract File cacheFile(Identifier id);

    /* Loader Utils */
    public abstract String loaderBrand();

    public abstract int mcVersion();

    public abstract String semanticVersion();

    public abstract boolean isDevelopmentEnvironment();
}
