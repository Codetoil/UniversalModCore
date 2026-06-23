module cam72cam.umc.api {
    requires com.google.common;
    requires com.google.gson;
    requires java.desktop;
    requires jsr305;
    requires org.jspecify;
    requires vecmath;

    exports cam72cam.mod.block.tile;
    exports cam72cam.mod.block;
    exports cam72cam.mod.config;
    exports cam72cam.mod.entity.boundingbox;
    exports cam72cam.mod.entity.custom;
    exports cam72cam.mod.entity.sync;
    exports cam72cam.mod.entity;
    exports cam72cam.mod.event;
    exports cam72cam.mod.fluid;
    exports cam72cam.mod.gui.container;
    exports cam72cam.mod.gui.helpers;
    exports cam72cam.mod.gui.screen;
    exports cam72cam.mod.gui;
    exports cam72cam.mod.input;
    exports cam72cam.mod.item;
    exports cam72cam.mod.math;
    exports cam72cam.mod.model.obj;
    exports cam72cam.mod.net;
    exports cam72cam.mod.registry;
    exports cam72cam.mod.render.obj;
    exports cam72cam.mod.render.opengl;
    exports cam72cam.mod.render;
    exports cam72cam.mod.resource;
    exports cam72cam.mod.serialization;
    exports cam72cam.mod.sound;
    exports cam72cam.mod.text;
    exports cam72cam.mod.util;
    exports cam72cam.mod.world;
    exports cam72cam.mod;

    exports util;
}