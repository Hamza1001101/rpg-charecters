package charecters;

import attributes.PrimaryAttributes;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import items.Armor;
import items.Weapon;
import items.WeaponType;

public class Warrior extends CharacterBase {


    public Warrior(String name) {
        super(name, new PrimaryAttributes(10, 5, 2, 1));
    }

    @Override
    public void levelUp(int level) {
        increaseCharecterLevel(level);
        updateCharecter(level, 5, 3, 2, 1);
    }

    /*switch (weapon.getWeaponType()) {
                case AXES, HAMMERS, SWORDS -> {

                }
                default -> throw new InvalidWeaponException("Invalid weapon choice!");
            }*/

    @Override
    public boolean equip(Weapon weapon) throws InvalidWeaponException {
        switch (weapon.getWeaponType()) {
            case AXES, HAMMERS, SWORDS -> {
                equipWeapon(weapon);
                return true;
            }
            default -> throw new InvalidWeaponException("Invalid Weapon choice!");
        }
    }

    @Override
    public boolean equip(Armor armor) throws InvalidArmorException {
        switch (armor.getArmorType()) {
            case MAIL, PLATE ->  {
                equipArmor(armor);
                return true;
            }
            default -> throw new InvalidArmorException("Invalid Armor choice!");
        }
    }

    @Override
    public double calculateDamage() {
        return calculateDPS(getTotalAttributes().getStrength());
    }
}
