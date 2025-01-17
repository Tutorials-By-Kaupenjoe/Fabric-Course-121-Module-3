package net.kaupenjoe.mccourse.event;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.kaupenjoe.mccourse.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AttackEntityHandler implements AttackEntityCallback {
    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand,
                                 Entity entity, @Nullable EntityHitResult hitResult) {
        if(entity instanceof SheepEntity && !world.isClient()) {
            if(player.getMainHandStack().getItem() == ModItems.METAL_DETECTOR) {
                player.sendMessage(Text.literal(player.getName().getString() + " tried metal detecting a Sheep!"));
            }

            if(player.getMainHandStack().getItem() == ModItems.STRAWBERRY) {
                player.sendMessage(Text.literal(player.getName().getString() + " attack Sheep with a strawberry?"));
                ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 400));
                player.getMainHandStack().decrement(1);
            }

            if(player.getMainHandStack().getItem() == Items.END_ROD) {
                player.sendMessage(Text.literal(player.getName().getString() + " attack Sheep with an End Rod?"));
                ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 400));
                player.getMainHandStack().decrement(1);
            }
        }

        return ActionResult.PASS;
    }
}
