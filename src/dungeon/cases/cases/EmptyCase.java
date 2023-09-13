package dungeon.cases.cases;

import dungeon.characters.Characters;
import static dungeon.cases.CasesType.Empty;
/**
 * Class who implements Case interface
 */
public class EmptyCase implements Case {
    /**
     * Return a string value
     * @return string
     */
    @Override
    public String toString() {
        return Empty + " case";
    }

    /**
     * Return a string value for display a message for position of current character
     * @param character typeof Character
     */
    @Override
    public void interaction(Characters character) {
        System.out.println("You are on "+Empty+" case.");
    }
}
