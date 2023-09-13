package dungeon.cases.ennemies.wizards;

/**
 * Class children legacy of Wizard class
 */
public class Gandalf extends Wizard{
    /**
     * Constructor of this object used constructor parent
     */
    public Gandalf() {
        super("Gandalf");
    }

    /**
     * Method toString for return the string The sorcerer + string passed in the constructor
     * For this object -> return -> The sorcerer Gandalf.
     * @return String
     */
    @Override
    public String toString() {
        return "The Sorcerer " + name;
    }
}
