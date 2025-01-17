package com.dmcpacks.dirtmonds.item;

import java.util.EnumMap;
import java.util.function.Supplier;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;

public enum ModArmorMaterial implements ArmorMaterial {
//    DIRTMOND("dirtmond", 26, new int[]{2, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1F, 0F, () -> {
//        return Ingredient.ofItems(ModItems.DIRTMOND);
//    });
    DIRTMOND("dirtmond", 26, Util.make(new EnumMap<ArmorItem.Type, Integer>(ArmorItem.Type.class), (map) -> {
        map.put(ArmorItem.Type.BOOTS, 2);
        map.put(ArmorItem.Type.LEGGINGS, 4);
        map.put(ArmorItem.Type.CHESTPLATE, 5);
        map.put(ArmorItem.Type.HELMET, 2);
    }), 7, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0F, 0.0F, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{ModItems.DIRTMOND});
    });

    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredientSupplier;

    private ModArmorMaterial(String name, int durabilityMultiplier, EnumMap<ArmorItem.Type, Integer> protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = repairIngredientSupplier;
    }

//    public int getDurability(EquipmentSlot slot) {
//        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
//    }
//
//    public int getProtection(EquipmentSlot slot) {
//        return this.protectionAmounts[slot.getEntitySlotId()];
//    }
    private static final EnumMap<ArmorItem.Type, Integer> BASE_DURABILITY = Util.make(new EnumMap<ArmorItem.Type, Integer>(ArmorItem.Type.class), (map) -> {
        map.put(ArmorItem.Type.BOOTS, 11);
        map.put(ArmorItem.Type.LEGGINGS, 13);
        map.put(ArmorItem.Type.CHESTPLATE, 14);
        map.put(ArmorItem.Type.HELMET, 9);
    });

    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY.get(type) * this.durabilityMultiplier;
    }

    public int getProtection(ArmorItem.Type type) {
        return this.protectionAmounts.get(type);
    }
    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    public Ingredient getRepairIngredient() {
        assert(this.repairIngredientSupplier != null);
        return this.repairIngredientSupplier.get();
    }

    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

}
