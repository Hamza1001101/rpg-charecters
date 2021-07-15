package charecters;

import attributes.PrimaryAttributes;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import items.Armor;
import items.Weapon;

public class Warrior extends CharacterBase {


    public Warrior(String name) {
        super(name, new PrimaryAttributes(10,5, 2,1));
    }

    @Override
    public void levelUp(int level) {
        increaseCharecterLevel(level);
        updateCharecter(level, 5, 3,2,1);
    }

    @Override
    public void equip(Weapon weapon) throws InvalidWeaponException {
        switch (weapon.getWeaponType()) {
            case AXES, HAMMERS, SWORDS -> {
                equipWeapon(weapon);
            }
            default -> throw new InvalidWeaponException("Invalid weapon choice!");
        }
    }

    @Override
    public void equip(Armor armor) throws InvalidArmorException {
        switch (armor.getArmorType()) {
            case MAIL, PLATE -> equipArmor(armor);
            default -> throw new InvalidArmorException("Invalid armor choice!");
        }
    }

    @Override
    public double calculateDamage() {
        return calculateDPS(getTotalAttributes().getStrength());
    }
}
