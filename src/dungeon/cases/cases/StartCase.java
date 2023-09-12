package dungeon.cases.cases;

import dungeon.characters.Characters;

/**
 * Class who implements Case interface
 */
public class StartCase implements Case {
    /**
     * Return a string value
     * @return string
     */
    @Override
    public String toString() {
        return "Start Case";
    }

    /**
     * Return a string value for display a message for position of current character
     * @param character typeof Characters
     */
    @Override
    public void interaction(Characters character) {
        System.out.println("You are on start case.");
    }
}
