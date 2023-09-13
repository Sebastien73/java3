package dungeon.cases.ennemies.wizards;
/**
 * Class children legacy of Wizard class
 */
public class Saruman extends Wizard {
    /**
     * Constructor of this object used constructor parent
     */
    public Saruman() {
        super("Saruman");
    }

    /**
     * Method toString for return the string The sorcerer + string passed in the constructor
     * For this object -> return -> The sorcerer Saruman.
     * @return String
     */
    @Override
    public String toString() {
        return "The Sorcerer " + name;
    }
}
