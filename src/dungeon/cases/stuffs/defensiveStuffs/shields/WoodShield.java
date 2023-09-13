package dungeon.cases.stuffs.defensiveStuffs.shields;
/**
 * Class legacy of Shield class
 */
public class WoodShield extends Shield{
    /**
     * Constructor without parameter, call the constructor parent and passed the parameters in this.
     * A name -> type String for shield attribute value
     * A defense -> type Integer for defense attribute value
     * A defPoints -> type Integer for defPoints attribute value
     */
    public WoodShield() {
        super("WoodShield",2,2);
    }

    /**
     * Method toString return string value
     * This method return the value of shield attribute.
     * @return String
     */
    public String toString(){ return this.shield; }
}
