package dungeon.cases.ennemies.dragons;

/**
 * Class children legacy of Dragon class
 */
public class IceDragon extends Dragon{
    /**
     * Constructor of this object used constructor parent
     */
    public IceDragon() {
        super("Ice");
    }

    /**
     * Method toString for return string passed in the constructor + string Dragon
     * For this object -> return -> IceDragon.
     * @return String
     */
    @Override
    public String toString() {
        return element + "Dragon";
    }
}
