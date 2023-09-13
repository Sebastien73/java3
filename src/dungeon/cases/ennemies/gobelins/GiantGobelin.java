package dungeon.cases.ennemies.gobelins;

/**
 * Class children legacy of Gobelin class
 */
public class GiantGobelin extends Gobelin{
    /**
     * Constructor of this object used constructor parent with one parameter / type -> String
     */
    public GiantGobelin() {
        super("Giant");
    }

    /**
     * Method toString for return string passed in the constructor + string Gobelin
     * For this object -> return -> GiantGobelin.
     * @return String
     */
    @Override
    public String toString() {
        return type + "Goblin";
    }
}
