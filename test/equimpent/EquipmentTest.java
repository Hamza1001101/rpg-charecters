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
    private Weapon testWeapon, testWeaponAxe, testStaff;
    private Armor testPlateBody, testClothHead, testPlateArmor;

    @BeforeEach
    public void initializeCharecter() {
        warrior = new Warrior("Thurman");
    }

    @BeforeEach
    public void initializeWeaponAndArmor() {
        testWeapon = new Weapon("Common Axe", 1,2, 1.1, WeaponType.AXES,
                new PrimaryAttributes(2,1,0,0));

        testWeaponAxe = new Weapon("Common Axe", 2,2, 0.65, WeaponType.AXES,
                new PrimaryAttributes(2,1,0,0));

        testStaff = new Weapon("Common Axe", 2,2, 0.65, WeaponType.STAFFS,
                new PrimaryAttributes(2,1,0,0));


        testClothHead = new Armor("Common Plate Head Armor ",1, SlotType.HEAD, ArmorType.CLOTH,
                new PrimaryAttributes(1,0,0,5));

        testPlateBody = new Armor("Special Plate Body Armor",2, SlotType.BODY, ArmorType.PLATE,
                new PrimaryAttributes(1,0,0,5));

        testPlateArmor = new Armor("Special Plate Body Armor",1, SlotType.BODY, ArmorType.PLATE,
                new PrimaryAttributes(1,0,0,5));
    }


    @Test
    public void equip_TooHighLevel_WeaponInvalidException() {
        assertThrows(InvalidWeaponException.class, () -> warrior.equip(testWeaponAxe));
    }

    @Test
    public void equip_TooHighLevel_ArmorPieceInvalidException() {
        assertThrows(InvalidArmorException.class, () -> warrior.equip(testPlateBody));
    }

    @Test
    public void equip_WrongWeaponType_InvalidWeaponException() {
        assertThrows(InvalidWeaponException.class, () -> warrior.equip(testStaff));
    }
    @Test
    public void equip_WrongArmorType_InvalidArmorException(){
        assertThrows(InvalidArmorException.class, () -> warrior.equip(testClothHead));
    }


    @Test
    public void charecterEquip_ValidWeaponType_True() throws InvalidWeaponException {
       assertTrue(warrior.equip(testWeapon));
    }

    @Test
    public void charecterEquip_ValidArmorPiece_True() throws InvalidArmorException {
        assertTrue(warrior.equip(testPlateArmor));
    }



}