package charecters;

import attributes.PrimaryAttributes;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import items.Armor;
import items.Weapon;

public class Rogue extends CharacterBase {

    public Rogue(String name) {
        super(name, new PrimaryAttributes(8,2,6,1));
    }

    @Override
    public void levelUp(int level) {
        increaseCharecterLevel(level);
        updateCharecter(level, 3,1,4,1);
    }

    @Override
    public boolean equip(Weapon weapon) throws InvalidWeaponException {
        switch (weapon.getWeaponType()) {
            case DAGGERS, SWORDS -> {
                equipWeapon(weapon);
            }
            default -> throw new InvalidWeaponException("Mage can only equip STAFFS and WANDS");
        }
        return false;
    }

    @Override
    public boolean equip(Armor armor) throws InvalidArmorException {
        switch (armor.getArmorType()){
            case LEATHER, MAIL  -> {
                equipArmor(armor);
                return true;
            }
            default -> throw new InvalidArmorException("Invalid armor");
        }
    }

    @Override
    public double calculateDamage() {
        return calculateDPS(getTotalAttributes().getDexterity());
    }
}
