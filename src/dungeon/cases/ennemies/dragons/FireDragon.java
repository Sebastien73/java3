package dungeon.cases.ennemies.dragons;

/**
 * Class children legacy of Dragon class
 */
public class FireDragon extends Dragon{

    /**
     * Constructor of this object used constructor parent
     */
    public FireDragon() {
        super("Fire");
    }

    /**
     * Method toString for return string passed in the constructor + string Dragon
     * For this object -> return -> FireDragon.
     * @return String
     */
    @Override
    public String toString() {
        return element + "Dragon";
    }
}
