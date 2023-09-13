package dungeon.cases.ennemies.dragons;

/**
 * Class children legacy of Dragon class
 */
public class ThunderDragon extends Dragon{
    /**
     * Constructor of this object used constructor parent
     */
    public ThunderDragon() {
        super("Thunder");
    }

    /**
     * Method toString for return string passed in the constructor + string Dragon
     * For this object -> return -> ThunderDragon.
     * @return String
     */
    @Override
    public String toString() {
        return element + "Dragon";
    }
}
