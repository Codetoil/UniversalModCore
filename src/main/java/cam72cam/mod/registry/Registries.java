package cam72cam.mod.registry;

import cam72cam.mod.UMC;
import cam72cam.mod.UMCPhase;
import cam72cam.mod.block.BlockEntity;
import cam72cam.mod.block.tile.TileEntity;
import cam72cam.mod.net.Packet;
import cam72cam.mod.net.PacketDirection;
import cam72cam.mod.net.PacketProtocol;
import cam72cam.mod.resource.Identifier;
import cam72cam.mod.text.Command;
import org.jspecify.annotations.NonNull;
import util.Triple;

import java.util.*;
import java.util.function.Supplier;

public class Registries {
    private final IdentifierRegistry<Supplier<BlockEntity>> blockEntitySupplierRegistry =
            new IdentifierRegistry<>(UMCPhase.CONSTRUCT, new Identifier(UMC.MODID, "block_entitiy_suppliers"));

    private final IdentifierRegistry<Class<TileEntity>> tileEntityTypeRegistry =
            new IdentifierRegistry<>(UMCPhase.CONSTRUCT, new Identifier(UMC.MODID, "tile_entity_types"));

    private final PacketRegistry packetRegistry = new PacketRegistry();

    private final IdentifierRegistry<Command> commandRegistry =
            new IdentifierRegistry<>(UMCPhase.CONSTRUCT, new Identifier(UMC.MODID, "commands"));

    public IdentifierRegistry<Supplier<BlockEntity>> getBlockEntitySupplierRegistry() {
        return blockEntitySupplierRegistry;
    }

    public IdentifierRegistry<Class<TileEntity>> getTileEntityTypeRegistry() {
        return tileEntityTypeRegistry;
    }

    public PacketRegistry getPacketRegistry() {
        return packetRegistry;
    }

    public IdentifierRegistry<Command> getCommandRegistry() {
        return commandRegistry;
    }

    public static class IdentifierRegistry<V> implements Map<Identifier, V> {
        private final UMCPhase phaseForRegistration;
        private final Identifier identifier;
        private Map<Identifier, V> internal = new HashMap<>();

        public IdentifierRegistry(UMCPhase phaseForRegistration, Identifier identifier) {
            this.phaseForRegistration = phaseForRegistration;
            this.identifier = identifier;
        }

        @Override
        public int size() {
            return this.internal.size();
        }

        @Override
        public boolean isEmpty() {
            return this.internal.isEmpty();
        }

        @Override
        public boolean containsKey(Object key) {
            return this.internal.containsKey(key);
        }

        @Override
        public boolean containsValue(Object value) {
            return this.internal.containsValue(value);
        }

        @Override
        public V get(Object key) {
            return this.internal.get(key);
        }

        @Override
        public V put(Identifier key, V value) {
            if (UMC.getInstance().getPhase() != this.phaseForRegistration)
            {
                throw new IllegalStateException("Invalid phase for registration for Registry " + identifier + "! Is " +
                        UMC.getInstance().getPhase() + ", should be registered at " + this.phaseForRegistration + "!");
            }
            return this.internal.put(key, value);
        }

        public V register(V value, Identifier key) {
            return this.put(key, value);
        }

        @Override
        public V remove(Object key) {
            throw new UnsupportedOperationException("Cannot remove elements from Registry " + identifier + ".");
        }

        @Override
        public void putAll(Map<? extends Identifier, ? extends V> m) {
            m.forEach(this::put);
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException("Cannot remove elements from Registry " + identifier + ".");
        }

        @Override
        @NonNull
        public Set<Identifier> keySet() {
            return this.internal.keySet();
        }

        @Override
        @NonNull
        public Collection<V> values() {
            return this.internal.values();
        }

        @Override
        @NonNull
        public Set<Entry<Identifier, V>> entrySet() {
            return Collections.unmodifiableSet(this.internal.entrySet());
        }

        public void freeze() {
            this.internal = Collections.unmodifiableMap(this.internal);
        }
    }

    public static class PacketRegistry extends
            IdentifierRegistry<Triple<Supplier<Packet>, PacketDirection, PacketProtocol>> {
        public PacketRegistry() {
            super(UMCPhase.CONSTRUCT, new Identifier(UMC.MODID, "packets"));
        }

        /**
         * Assume the user wants to register the packet for the PLAY protocol.
         */
        public void register(Supplier<Packet> supplier, PacketDirection direction, Identifier identifier) {
            register(supplier, direction, PacketProtocol.PLAY, identifier);
        }

        public void register(Supplier<Packet> supplier, PacketDirection direction, PacketProtocol protocol,
                             Identifier identifier) {
            register(Triple.of(supplier, direction, protocol), identifier);
        }
    }
}
