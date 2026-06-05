package tcintegrations.data.tcon;

import org.jetbrains.annotations.NotNull;

import net.minecraft.data.PackOutput;

import slimeknights.tconstruct.library.data.tinkering.AbstractEnchantmentToModifierProvider;

public class EnchantmentToModifierProvider extends AbstractEnchantmentToModifierProvider {

    public EnchantmentToModifierProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addEnchantmentMappings() {
        // TODO: port Apotheosis enchantment mapping
    }

    @Override
    public @NotNull String getName() {
        return "TCIntegrations - TCon Enchantment to Modifier Mapping";
    }

}
