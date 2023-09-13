package dungeon.cases.ennemies.wizards;
/**
 * Class children legacy of Wizard class
 */
public class Voldemort extends Wizard{
    /**
     * Constructor of this object used constructor parent
     */
    public Voldemort() {
        super("Voldemort");
    }

    /**
     * Method toString for return the string The sorcerer + string passed in the constructor
     * For this object -> return -> The sorcerer Voldemort.
     * @return String
     */
    @Override
    public String toString() {
        return name;
    }
}
