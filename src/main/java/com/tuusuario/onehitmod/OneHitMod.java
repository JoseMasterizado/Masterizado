package com.tuusuario.onehitmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

public class OneHitMod implements ModInitializer {

    @Override
    public void onInitialize() {
        System.out.println("OneHitMod cargado!");

        // Evento que se llama cuando un jugador ataca una entidad
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (!world.isClient && entity instanceof LivingEntity livingEntity) {
                // Infligir daño letal de 1000 puntos para matar de un golpe
                livingEntity.damage(livingEntity.getDamageSources().playerAttack(player), 1000f);
                return ActionResult.SUCCESS;
            }
            return ActionResult.PASS;
        });
    }
}
