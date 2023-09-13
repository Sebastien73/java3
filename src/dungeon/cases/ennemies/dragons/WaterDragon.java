package dungeon.cases.ennemies.dragons;
/**
 * Class children legacy of Dragon class
 */
public class WaterDragon extends Dragon{

    /**
     * Constructor of this object used constructor parent
     */
    public WaterDragon() {
        super("Water");
    }

    /**
     * Method toString for return string passed in the constructor + string Dragon
     * For this object -> return -> WaterDragon.
     * @return String
     */
    @Override
    public String toString() {
        return element + "Dragon";
    }
}
