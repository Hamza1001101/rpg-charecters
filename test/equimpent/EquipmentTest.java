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
    private Weapon testWeaponLevel1, testWeaponAxeLevel2, testStaffLevel2;
    private Armor testPlateBody, testClothHead, testPlateArmor;

    @BeforeEach
    public void initializeCharecter() {
        warrior = new Warrior("Thurman");
    }

    @BeforeEach
    public void initializeWeaponAndArmor() {
        testWeaponLevel1 = new Weapon("Common Axe", 1, 2, 1.1, WeaponType.AXE,
                new PrimaryAttributes(2, 1, 0, 0));

        testWeaponAxeLevel2 = new Weapon("Common Axe", 2, 2, 0.65, WeaponType.AXE,
                new PrimaryAttributes(2, 1, 0, 0));

        testStaffLevel2 = new Weapon("Common Axe", 2, 2, 0.65, WeaponType.STAFF,
                new PrimaryAttributes(2, 1, 0, 0));


        testClothHead = new Armor("Common Plate Head Armor ", 1, SlotType.HEAD, ArmorType.CLOTH,
                new PrimaryAttributes(1, 0, 0, 5));

        testPlateBody = new Armor("Special Plate Body Armor", 2, SlotType.BODY, ArmorType.PLATE,
                new PrimaryAttributes(1, 0, 0, 5));

        testPlateArmor = new Armor("Special Plate Body Armor", 1, SlotType.BODY, ArmorType.PLATE,
                new PrimaryAttributes(1, 0, 0, 5));
    }


    @Test
    public void equip_TooHighLevel_WeaponInvalidException() {
        assertThrows(InvalidWeaponException.class, () -> warrior.equip(testWeaponAxeLevel2));
    }

    @Test
    public void equip_TooHighLevel_ArmorPieceInvalidException() {
        assertThrows(InvalidArmorException.class, () -> warrior.equip(testPlateBody));
    }

    @Test
    public void equip_WrongWeaponType_InvalidWeaponException() {
        assertThrows(InvalidWeaponException.class, () -> warrior.equip(testStaffLevel2));
    }

    @Test
    public void equip_WrongArmorType_InvalidArmorException() {
        assertThrows(InvalidArmorException.class, () -> warrior.equip(testClothHead));
    }

    @Test
    public void charecterEquip_ValidWeaponType_True() throws InvalidWeaponException {
        assertTrue(warrior.equip(testWeaponLevel1));
    }

    @Test
    public void charecterEquip_ValidArmorPiece_True() throws InvalidArmorException {
        assertTrue(warrior.equip(testPlateArmor));
    }

    @Test
    public void calculateDPS_NoWeaponEquipped() {
        double expectedDPSValue = 1;
        assertEquals(expectedDPSValue, warrior.calculateDamage());
    }

    @Test
    public void calculateDPS_WithValidWeaponEquipped() throws InvalidWeaponException {
        warrior.equip(testWeaponLevel1);
        assertEquals(2.33, warrior.calculateDamage());
    }

    @Test
    public void calculateDPS_WithValidArmorAndWeaponEquipped() throws InvalidWeaponException, InvalidArmorException {
        warrior.equip(testPlateArmor);
        warrior.equip(testWeaponLevel1);
        int [] currentWarriorValues = {warrior.getTotalAttributes().getVitality(), warrior.getTotalAttributes().getStrength(),
                warrior.getTotalAttributes().getDexterity(), warrior.getTotalAttributes().getIntelligence() };
        int [] expectedValues = {13, 6, 2, 6};
        assertArrayEquals(expectedValues, currentWarriorValues);
    }
}