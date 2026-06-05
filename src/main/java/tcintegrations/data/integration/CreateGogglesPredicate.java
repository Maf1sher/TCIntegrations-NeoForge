package tcintegrations.data.integration;

import com.simibubi.create.content.equipment.goggles.GogglesItem;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

public class CreateGogglesPredicate {

    public static void init() {
        GogglesItem.addIsWearingPredicate(player -> {
            ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);

            return helmet.has(DataComponents.CUSTOM_DATA) && helmet.get(DataComponents.CUSTOM_DATA).contains("create_goggles");
        });
    }

}
