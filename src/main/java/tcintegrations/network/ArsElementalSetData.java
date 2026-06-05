package tcintegrations.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

import tcintegrations.TCIntegrations;

public record ArsElementalSetData(boolean hasAir, boolean hasAqua, boolean hasEarth, boolean hasFire) implements CustomPacketPayload {

    public static final Type<ArsElementalSetData> TYPE = new Type<>(
        ResourceLocation.fromNamespaceAndPath(TCIntegrations.MODID, "ars_elemental_set")
    );

    public static final StreamCodec<FriendlyByteBuf, ArsElementalSetData> STREAM_CODEC = StreamCodec.of(
        (buf, data) -> {
            buf.writeBoolean(data.hasAir);
            buf.writeBoolean(data.hasAqua);
            buf.writeBoolean(data.hasEarth);
            buf.writeBoolean(data.hasFire);
        },
        buf -> new ArsElementalSetData(
            buf.readBoolean(),
            buf.readBoolean(),
            buf.readBoolean(),
            buf.readBoolean()
        )
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
