package charecters;

import attributes.PrimaryAttributes;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import items.Armor;
import items.ArmorType;
import items.Weapon;


public class Mage extends CharacterBase {

    public Mage(String name) {
        super(name, new PrimaryAttributes(5, 1, 1, 8));
    }


    @Override
    public void levelUp(int level) {
        increaseCharecterLevel(level);
        updateCharecter(level, 3, 1, 1, 5);
    }

    @Override
    public boolean equip(Weapon weapon) throws InvalidWeaponException {
        switch (weapon.getWeaponType()) {
            case STAFF, WAND -> {
                equipWeapon(weapon);
                return true;
            }
            default -> throw new InvalidWeaponException("Mage cannot equip anything other than STAFF or WAND");
        }
    }

    @Override
    public boolean equip(Armor armor) throws InvalidArmorException {
        if (armor.getArmorType() == ArmorType.CLOTH) {
            equipArmor(armor);
            return true;
        }
        throw new InvalidArmorException("Mage can only wear CLOTH armor.");

    }

    @Override
    public double calculateDamage() {
        double roundDPS = calculateDPS(getTotalAttributes().getIntelligence());
        return Math.round(roundDPS*100.0)/100.0;
    }

}

