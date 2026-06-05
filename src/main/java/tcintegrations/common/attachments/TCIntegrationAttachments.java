package tcintegrations.common.attachments;

import java.util.function.Supplier;

import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import tcintegrations.TCIntegrations;

public class TCIntegrationAttachments {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES =
        DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, TCIntegrations.MODID);

    public static final Supplier<AttachmentType<ArsElementalSet>> ARS_ELEMENTAL_SET = ATTACHMENT_TYPES.register(
        "ars_elemental_set", () -> AttachmentType.builder(ArsElementalSet::new).build()
    );
}
