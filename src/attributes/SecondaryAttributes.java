package attributes;

public class SecondaryAttributes {
    private int health;
    private int armorRating;
    private int elementalResistance;

    public SecondaryAttributes() {

    }
    public SecondaryAttributes(int health, int armorRating, int elementalResistance) {

        this.health = health;
        this.armorRating = armorRating;
        this.elementalResistance = elementalResistance;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int vitality) {
        this.health = vitality*10;
    }

    public int getArmorRating() {
        return armorRating;
    }

    public void setArmorRating(int dexterity, int strength) {
        this.armorRating = strength+dexterity;
    }

    public int getElementalResistance() {
        return elementalResistance;
    }

    public void setElementalResistance(int intelligence) {
        this.elementalResistance = intelligence;
    }
}



