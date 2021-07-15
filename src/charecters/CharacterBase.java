package charecters;


import attributes.PrimaryAttributes;
import attributes.SecondaryAttributes;
import equimpent.*;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import items.Armor;

import items.Item;
import items.Weapon;


import java.util.stream.IntStream;

public abstract class CharacterBase {
    private final String name;
    private int level;

    private final PrimaryAttributes baseAttributes;
    private PrimaryAttributes equipmentAttributes;
    private PrimaryAttributes totalAttributes;

    private SecondaryAttributes secondaryAttributes = new SecondaryAttributes();
    private final Equipment eItem = new Equipment();


    public CharacterBase(String name, PrimaryAttributes baseAttributes) {
        this.name = name;
        this.level = 1;
        this.baseAttributes = baseAttributes;
        this.equipmentAttributes = new PrimaryAttributes(0, 0, 0, 0);
        this.totalAttributes = new PrimaryAttributes(0, 0, 0, 0);


        updateTotalAttributes();
    }

    protected abstract void levelUp(int level);

    public abstract void equip(Weapon weapon) throws InvalidWeaponException;

    public abstract void equip(Armor armor) throws InvalidArmorException;

    public abstract double calculateDamage();


    protected void equipArmor(Armor armor) throws InvalidArmorException {

        if (armor.getRequiredLevel() > this.level) {
            throw new InvalidArmorException("Cannot equip a WEAPON that has a higher level requirement.");
        }

        switch (armor.getSlotType()) {
            case LEGS -> eItem.getSlotTypeItem().put(SlotType.LEGS, armor);
            case HEAD -> eItem.getSlotTypeItem().put(SlotType.HEAD, armor);
            case BODY -> eItem.getSlotTypeItem().put(SlotType.BODY, armor);
        }
        setEquipAttributes();
    }

    protected void equipWeapon(Weapon weapon) throws InvalidWeaponException {
        if (weapon.getRequiredLevel() > this.level) {
            throw new InvalidWeaponException("Cannot equip a WEAPON that has a higher level requirement.");
        }
        eItem.getSlotTypeItem().put(SlotType.WEAPON, weapon);
        setEquipAttributes();
    }

    protected double calculateDPS(double param) {
        return eItem.getWeaponItem() == null ? 1 : eItem.getWeaponItem().getDPSValue() * (1 + (param / 100));
    }


    protected void increaseCharecterLevel(int level) {
        if (level <= 0) {
            throw new IllegalArgumentException("Level gain has to be more than 0");
        }
        this.level += level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public PrimaryAttributes getTotalAttributes() {
        return totalAttributes;
    }

    public SecondaryAttributes getSecondaryAttributes() {
        return secondaryAttributes;
    }


    private void setEquipAttributes() {
        //before updating reset fields
        equipmentAttributes = new PrimaryAttributes(0, 0, 0, 0);

        eItem.getSlotTypeItem().forEach(this::updateEquipAttributes);
        updateTotalAttributes();
    }

    private void updateEquipAttributes(SlotType key, Item value) {
        if (key == SlotType.WEAPON) {
            Weapon weapon = eItem.getWeaponItem();
            if (weapon != null) {
                equipmentAttributes.increaseVitality(weapon.getPrimaryAttributes().getVitality());
                equipmentAttributes.increaseDexterity(weapon.getPrimaryAttributes().getDexterity());
                equipmentAttributes.increaseIntelligence(weapon.getPrimaryAttributes().getIntelligence());
                equipmentAttributes.increaseStrength(weapon.getPrimaryAttributes().getStrength());
            }
        } else {
            // If its not a Weapon then its an armor
            Armor armor = eItem.getArmorItem(key);
            if (armor != null) {
                equipmentAttributes.increaseVitality(armor.getPrimaryAttributes().getVitality());
                equipmentAttributes.increaseDexterity(armor.getPrimaryAttributes().getDexterity());
                equipmentAttributes.increaseIntelligence(armor.getPrimaryAttributes().getIntelligence());
                equipmentAttributes.increaseStrength(armor.getPrimaryAttributes().getStrength());
            }
        }
    }

    protected void updateCharecter(int level, int vitality, int strength, int dexterity,  int intelligence) {
        IntStream.range(0, level).forEach(i -> {
            baseAttributes.increaseDexterity(dexterity);
            baseAttributes.increaseIntelligence(intelligence);
            baseAttributes.increaseStrength(strength);
            baseAttributes.increaseVitality(vitality);
        });

        updateTotalAttributes();
    }

    private void updateTotalAttributes() {

        //clear out first!
        totalAttributes = new PrimaryAttributes(0, 0, 0, 0);

        totalAttributes.increaseStrength(baseAttributes.getStrength() + equipmentAttributes.getStrength());
        totalAttributes.increaseDexterity(baseAttributes.getDexterity() + equipmentAttributes.getDexterity());
        totalAttributes.increaseIntelligence(baseAttributes.getIntelligence() + equipmentAttributes.getIntelligence());
        totalAttributes.increaseVitality(baseAttributes.getVitality() + equipmentAttributes.getVitality());

        updateSecondaryAttributes();
    }

    private void updateSecondaryAttributes() {
        secondaryAttributes.setHealth(totalAttributes.getVitality());
        secondaryAttributes.setArmorRating(totalAttributes.getDexterity(), totalAttributes.getStrength());
        secondaryAttributes.setElementalResistance(totalAttributes.getIntelligence());
    }

    public void setSecondaryAttributes(SecondaryAttributes secondaryAttributes) {
        this.secondaryAttributes = secondaryAttributes;
    }

    public PrimaryAttributes getBaseAttributes() {
        return baseAttributes;
    }

    public PrimaryAttributes getEquipmentAttributes() {
        return equipmentAttributes;
    }


}


