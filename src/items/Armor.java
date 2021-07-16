package items;

import attributes.PrimaryAttributes;
import equimpent.SlotType;

public class Armor extends Item {
    private ArmorType armorType;
    private PrimaryAttributes primaryAttributes;

    public Armor(String name, int requiredLevel, SlotType slotType, ArmorType armorType, PrimaryAttributes primaryAttributes) {
        super(name, requiredLevel, slotType);
        this.armorType = armorType;
        this.primaryAttributes = primaryAttributes;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public PrimaryAttributes getPrimaryAttributes() {
        return primaryAttributes;
    }


}
