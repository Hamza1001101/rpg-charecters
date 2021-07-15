package charecters;

import attributes.PrimaryAttributes;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import items.Armor;
import items.ArmorType;
import items.Weapon;
import items.WeaponType;

public class Ranger  extends CharacterBase{

    public Ranger(String name) {
        super(name, new PrimaryAttributes(8,1,7,1));
    }

    @Override
    public void levelUp(int level) {
        increaseCharecterLevel(level);
        updateCharecter(level, 2,1,5,1);
    }

    @Override
    public void equip(Weapon weapon) throws InvalidWeaponException {
        if (weapon.getWeaponType() == WeaponType.BOWS) {
            equipWeapon(weapon);
        }
        throw new InvalidWeaponException("Invalid weapon choice!");
    }

    @Override
    public void equip(Armor armor) throws InvalidArmorException {
        switch (armor.getArmorType()) {
            case LEATHER, MAIL -> equipArmor(armor);
            default -> throw new InvalidArmorException("Invalid armor choice!");
        }
    }

    @Override
    public double calculateDamage() {
        return calculateDPS(getTotalAttributes().getDexterity());
    }
}
