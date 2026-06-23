package cam72cam.mod;

public enum UMCPhase {
    CONSTRUCT, // Mod constructor is called, do your registration (Block, Item, etc...) here
    INITIALIZE, // First chance to interact with resource pack data
    IMC, // Say Hi to other mods here
    FINALIZE, // Any final stuff to fire after registrations and setup stuff
    START, // Server start
    RELOAD, // Resources reloaded
    PLAY // Called during play, when there is no other phase.
}
