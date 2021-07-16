import attributes.PrimaryAttributes;
import charecterPrinter.CharecterPrinter;
import charecters.Mage;
import charecters.Warrior;
import equimpent.SlotType;
import exceptions.InvalidArmorException;
import exceptions.InvalidWeaponException;
import items.Armor;
import items.ArmorType;
import items.Weapon;
import items.WeaponType;

import java.util.Arrays;


public class Program {
    public static void main(String[] args) throws InvalidWeaponException, InvalidArmorException {

        Mage mage = new Mage("Hamza");
        Warrior warrior = new Warrior("Hamza");

      /*  Weapon staff = new Weapon("Wooden stuff", 1, 3,
                0.5, WeaponType.STAFFS, new PrimaryAttributes(0, 0, 2, 1));
        Armor cloth = new Armor("Cloth robe", 1,
                SlotType.BODY, ArmorType.CLOTH, new PrimaryAttributes(0, 0, 0, 2));

        Weapon wand = new Weapon("wand", 1, 2, 0.75, WeaponType.WANDS, new PrimaryAttributes(0,2,1,0));




      //  Weapon staff = new Weapon("Wooden staff", 1, 3.0, 0.5, WeaponType.STAFF, new PrimaryAttributes(1,0,0,2));
        Weapon axe = new Weapon("axe", 1, 2, 0.75, WeaponType.AXES, new PrimaryAttributes(0,2,1,0));
        Weapon bow = new Weapon("bow", 1, 2, 0.75, WeaponType.BOWS, new PrimaryAttributes(0,2,1,0));
        Weapon dagger = new Weapon("dagger", 1, 2, 0.75, WeaponType.DAGGERS, new PrimaryAttributes(0,2,1,0));
        Weapon hammer = new Weapon("hammer", 1, 2, 0.75, WeaponType.HAMMERS, new PrimaryAttributes(0,2,1,0));
        Weapon sword = new Weapon("sword", 1, 2, 0.75, WeaponType.SWORDS, new PrimaryAttributes(0,2,1,0));
    //    Weapon wand = new Weapon("wand", 1, 2.0, 0.75, WeaponType.WAND, new PrimaryAttributes(0,2,1,0));


    //    Armor cloth = new Armor("Cloth robe", 1, SlotType.BODY, ArmorType.CLOTH ,
           //     new PrimaryAttributes(2,0,0,0));
        Armor leather = new Armor("Leather armor", 1, SlotType.BODY, ArmorType.LEATHER ,new PrimaryAttributes(2,0,0,0));


        Weapon mjolnir = new Weapon("Mjolnir ⚡", 99, 1500, 1.0, WeaponType.SWORDS, new PrimaryAttributes(0,50,32,10));
        Armor crownOfImmortality = new Armor("Crown of Immortality 👑", 99, SlotType.HEAD, ArmorType.MAIL, new PrimaryAttributes(45,10,5,5));
        Armor cloakOfLevitation = new Armor("The Cloak of Levitation 👗", 78, SlotType.BODY, ArmorType.MAIL ,new PrimaryAttributes(20,12,12,25));
        Armor soulForgedPantsOfHonor = new Armor("Soul-Forged Pants of Honor 👖", 85, SlotType.LEGS, ArmorType.PLATE ,new PrimaryAttributes(2,26,18,6));

        mage.equip(staff);
        mage.equip(cloth);
        mage.levelUp(4);
       // new CharecterPrinter().displayStats(mage);

        Warrior warrior = new Warrior("Thor");

        warrior.levelUp(98);
        warrior.equip(mjolnir);
        warrior.equip(crownOfImmortality);
        warrior.equip(cloakOfLevitation);
        warrior.equip(soulForgedPantsOfHonor);*/

   //  new CharecterPrinter().displayStats(mage);

       Weapon axeLevel1 = new Weapon("axe", 1, 2, 0.75,
               WeaponType.AXE, new PrimaryAttributes(0,2,1,0));
       Armor plateArmor = new Armor("Plate armor", 1, SlotType.BODY, ArmorType.PLATE ,new PrimaryAttributes(2,0,0,0));
        Armor plateHelmetLevel1 = new Armor("Plate helmet", 1, SlotType.HEAD,
                ArmorType.PLATE ,new PrimaryAttributes(2,0,0,0));
       Armor mailLegs = new Armor("Mail leggings", 1, SlotType.LEGS, ArmorType.MAIL
                ,new PrimaryAttributes(2,0,0,0));


       Weapon testWeaponLevel1 = new Weapon("Common Axe", 1, 2, 1.1, WeaponType.AXE,
                new PrimaryAttributes(2, 1, 0, 0));

       Armor testPlateArmor = new Armor("Special Plate Body Armor", 1, SlotType.BODY, ArmorType.PLATE,
                new PrimaryAttributes(1, 0, 0, 5));

       /* warrior.equip(axeLevel1);
        warrior.equip(plateHelmetLevel1);
       // warrior.equip(axeLevel2);
      warrior.equip(plateArmor);
        warrior.equip(mailLegs);*/




warrior.equip(testPlateArmor);
warrior.equip(testWeaponLevel1);
        int [] defaultValue = {warrior.getTotalAttributes().getVitality(), warrior.getTotalAttributes().getStrength(),
                warrior.getTotalAttributes().getDexterity(), warrior.getTotalAttributes().getIntelligence() };

        System.out.println(Arrays.toString(defaultValue));

    }
}
