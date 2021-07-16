
import charecterPrinter.CharecterPrinter;
import charecters.Mage;


public class Program {
    public static void main(String[] args) {

        Mage mage = new Mage("Goblin");
        new CharecterPrinter().displayStats(mage);

    }
}
