package equimpent;

import attributes.PrimaryAttributes;
import charecters.Warrior;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import items.Armor;
import items.ArmorType;
import items.Weapon;
import items.WeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentTest {

    private Warrior warrior;
    private Weapon weaponLevel1, weaponLevel2;
    private Armor plateBody, clothHead;

    @BeforeEach
    public void initializeCharecter() {
        warrior = new Warrior("Thurman");
    }

    @BeforeEach
    public void initializeWeaponAndArmor() {
        weaponLevel1 = new Weapon("Common Axe", 1,2, 1.1, WeaponType.AXES,
                new PrimaryAttributes(2,1,0,0));
        weaponLevel2 = new Weapon("Axe", 2,2, 0.65, WeaponType.AXES,
                new PrimaryAttributes(2,1,0,0));
        clothHead = new Armor("Common Plate Head Armor ",1, SlotType.HEAD, ArmorType.PLATE,
                new PrimaryAttributes(1,0,0,5));
        plateBody= new Armor("Special Plate Body Armor",2, SlotType.BODY, ArmorType.PLATE,
                new PrimaryAttributes(1,0,0,5));
    }

    @Test
    public void equip_TooHighLevel_WeaponInvalidException() {
        assertThrows(InvalidWeaponException.class, () -> warrior.equip(weaponLevel2));
    }

    @Test
    public void equip_TooHighLevel_ArmorInvalidException() {
        assertThrows(InvalidArmorException.class, () -> warrior.equip(plateBody));
    }

    @Test
    public void equip_WrongWeaponType_InvalidWeaponException() {
        assertThrows(InvalidWeaponException.class, () -> warrior.equip(weaponLevel2));
    }

}