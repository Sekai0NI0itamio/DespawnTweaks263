package itamio.despawntweaks.mixin;

import itamio.despawntweaks.DespawnTweaksMod;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Simplified port of txnimc's MobMixin: mobs that picked up an item
 * (tagged despawntweaks.pickedItems) or are marked shouldNotDespawn
 * do not despawn — their no-action timer is reset instead.
 */
@Mixin(Mob.class)
public abstract class MobMixin extends LivingEntity {
    @Shadow
    private boolean persistenceRequired;

    protected MobMixin(EntityType<? extends LivingEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "setItemSlotAndDropWhenKilled", at = @At("TAIL"))
    private void despawntweaks263$onSetItemSlotAndDropWhenKilled(EquipmentSlot slot, ItemStack stack, CallbackInfo ci) {
        this.addTag("despawntweaks.pickedItems");
        this.persistenceRequired = this.hasCustomName();
    }

    @Inject(method = "checkDespawn", at = @At("HEAD"), cancellable = true)
    private void despawntweaks263$onCheckDespawn(CallbackInfo ci) {
        if (this.level().isClientSide()) {
            return;
        }
        if (this.getTags().contains(DespawnTweaksMod.ID + ".shouldNotDespawn")
                || this.getTags().contains("despawntweaks.pickedItems")) {
            this.setNoActionTime(0);
            ci.cancel();
        }
    }
}
