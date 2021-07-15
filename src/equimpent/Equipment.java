package equimpent;

import items.Armor;
import items.Item;
import items.Weapon;

import java.util.HashMap;

public class Equipment {


    private final HashMap<SlotType, Item> slotTypeItems;


    public Equipment() {
        this.slotTypeItems = new HashMap<>();
    }

    public HashMap<SlotType, Item> getSlotTypeItem() {
        return slotTypeItems;
    }

    public Weapon getWeaponItem() {
        return (Weapon) slotTypeItems.getOrDefault(SlotType.WEAPON, null);
    }

    public Armor getArmorItem(SlotType slotType) {
        return (Armor) slotTypeItems.getOrDefault(slotType, null);
    }
}
