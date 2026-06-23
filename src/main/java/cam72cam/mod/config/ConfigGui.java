package cam72cam.mod.config;

import cam72cam.mod.gui.screen.IScreen;
import cam72cam.mod.gui.screen.IScreenBuilder;
import cam72cam.umc.gui.screen.*;

public class ConfigGui implements IScreen {

    public ConfigGui(Class<?> ...types) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    public ConfigGui(ConfigGui parent, ConfigFile.PropertyClass pc, ConfigFile.ConfigInstance ci) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public void init(IScreenBuilder screen) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public void onEnterKey(IScreenBuilder builder) {
        builder.close();
    }

    @Override
    public void onClose() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    private void show() {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }

    @Override
    public void draw(IScreenBuilder builder) {
        throw new UnsupportedOperationException("This is the API. Look at the per-version implementation for implementation details.");
    }
}
