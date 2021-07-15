package charecters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharecterTests {

    private Mage mage;
    private Rogue rogue;
    private Warrior warrior;
    private Ranger ranger;

    @BeforeEach
    public void initializeCharacters(){
        mage = new Mage("Aegwynn");
    }

    @Test
    public void getLevel_InitializedCharecter_StartingLevelOne(){
        assertEquals(1, mage.getLevel());
    }

    @Test
    public void levelUp_IncreaseLevelByOne_ShouldIncrementByOne(){
        mage.levelUp(1);
        assertEquals(2, mage.getLevel());
    }
    @Test
    public void levelUp_ByZeroOrLess_ShouldYieldException(){
        assertThrows(IllegalArgumentException.class, () -> {
            mage.levelUp(0);
            mage.levelUp(-1);
        });
    }

    @Test
    public void primaryAttributes_CorrectDefaultValues_whenCharecterIsCreated(){
        double [] defaultValues = {mage.getBaseAttributes().getVitality(), mage.getBaseAttributes().getIntelligence(),
        mage.getBaseAttributes().getDexterity(), mage.getBaseAttributes().getStrength()};
        double [] expectedValues = {5,8,1,1};
        assertArrayEquals(expectedValues,defaultValues);
    }
}