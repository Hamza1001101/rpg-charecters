package charecters;

import attributes.PrimaryAttributes;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import items.Armor;
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
    public boolean equip(Weapon weapon) throws InvalidWeaponException {
        if (weapon.getWeaponType() == WeaponType.BOW) {
            equipWeapon(weapon);
            return true;
        }
        throw new InvalidWeaponException("Ranger cannot equip anything other than BOW");
    }

    @Override
    public boolean equip(Armor armor) throws InvalidArmorException {
        switch (armor.getArmorType()) {
            case LEATHER, MAIL -> {
                equipArmor(armor);
                return true;
            }
            default -> throw new InvalidArmorException("Ranger cannot equip anything other than LEATHER or MAIL armor");
        }
    }

    @Override
    public double calculateDamage() {
        return calculateDPS(getTotalAttributes().getDexterity());
    }
}
