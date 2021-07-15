package attributes;

public class PrimaryAttributes {
    private int strength;
    private int dexterity;
    private int intelligence;
    private int vitality;

    public PrimaryAttributes(int vitality, int strength, int dexterity, int intelligence ) {
        this.vitality = vitality;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;

    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getVitality() {
        return vitality;
    }

    public void increaseVitality(int vitality) {
        this.vitality += vitality;
    }

    public void increaseStrength(int strength) {
        this.strength+=strength;
    }
    public void increaseDexterity(int dexterity) {
        this.dexterity+=dexterity;
    }
    public void increaseIntelligence(int intelligence) {
        this.intelligence+=intelligence;
    }
}
