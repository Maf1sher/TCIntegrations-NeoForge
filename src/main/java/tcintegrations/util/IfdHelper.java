package tcintegrations.util;

import com.iafenvoy.iceandfire.entity.GhostSwordEntity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class IfdHelper {

    private static final ResourceLocation GHOST_SWORD_ID = ResourceLocation.parse("iceandfire:ghost_sword");

    public static void shootGhostSword(Player player, float damage) {
        EntityType<?> type = BuiltInRegistries.ENTITY_TYPE.get(GHOST_SWORD_ID);

        if (type == null) return;

        GhostSwordEntity ghostSword = new GhostSwordEntity((EntityType<? extends GhostSwordEntity>) type, player.level(), player, damage * 0.5F, ItemStack.EMPTY);

        ghostSword.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.0F, 0.5F);
        player.level().addFreshEntity(ghostSword);
    }

}
