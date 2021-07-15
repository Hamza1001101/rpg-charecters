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
    public double calculateDamage() {
       return calculateDPS(this.getTotalAttributes().getIntelligence());
    }


    @Override
    public void equip(Weapon weapon) throws InvalidWeaponException {
        switch (weapon.getWeaponType()) {
            case STAFFS, WANDS -> {
                equipWeapon(weapon);
            }
            default -> throw new InvalidWeaponException("Mage can only equip STAFFS and WANDS");
        }

    }

    @Override
    public void equip(Armor armor) throws InvalidArmorException {
        if (armor.getArmorType() == ArmorType.CLOTH) {
            equipArmor(armor);
            return;
        }
        throw new InvalidArmorException("Mage can only equip CLOTH armor.");

    }

}

