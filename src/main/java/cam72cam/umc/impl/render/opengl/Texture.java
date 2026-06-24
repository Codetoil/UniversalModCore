package cam72cam.umc.impl.render.opengl;

import cam72cam.umc.impl.resource.Identifier;

public interface Texture {
    Texture NO_TEXTURE = Texture.wrap(-1);

    int getId();

    static Texture wrap(int id) {
        return () -> id;
    }

    static Texture wrap(Identifier id) {
        return new MinecraftTexture(id);
    }
}
