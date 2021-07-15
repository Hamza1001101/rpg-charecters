package items;

import attributes.PrimaryAttributes;
import equimpent.SlotType;

public class Weapon extends Item {
    private int damage;
    private double attackSpeed;
    private WeaponType weaponType;
    private PrimaryAttributes primaryAttributes;

    public Weapon(String name, int requiredLevel,  int damage, double attackSpeed, WeaponType weaponType, PrimaryAttributes primaryAttributes) {
        super(name, requiredLevel, SlotType.WEAPON);
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        this.weaponType = weaponType;
        this.primaryAttributes = primaryAttributes;
    }

    public int getDamage() {
        return damage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public double getDPSValue(){
        return this.attackSpeed * this.damage;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public PrimaryAttributes getPrimaryAttributes() {
        return primaryAttributes;
    }
}
