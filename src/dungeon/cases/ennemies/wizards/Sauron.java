package dungeon.cases.ennemies.wizards;

/**
 * Class children legacy of Wizard class
 */
public class Sauron extends Wizard{
    /**
     * Constructor of this object used constructor parent
     */
    public Sauron() {
        super("Sauron");
    }

    /**
     * Method toString for return the string The sorcerer + string passed in the constructor
     * For this object -> return -> The sorcerer Sauron.
     * @return String
     */
    @Override
    public String toString() {
        return "The Sorcerer " + name;
    }
}
