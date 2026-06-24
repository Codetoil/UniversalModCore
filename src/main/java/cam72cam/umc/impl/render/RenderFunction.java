package cam72cam.umc.impl.render;

import cam72cam.umc.impl.render.opengl.RenderState;

@FunctionalInterface
public interface RenderFunction {
    void render(RenderState state, float partialTicks);
}
