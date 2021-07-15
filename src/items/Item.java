package items;

import equimpent.SlotType;

public abstract class Item {
    private String name;
    private int requiredLevel;
    private SlotType slotType;

    public Item(String name, int requiredLevel, SlotType slotType) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slotType = slotType;
    }

    public String getName() {
        return name;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public SlotType getSlotType() {
        return slotType;
    }


}
