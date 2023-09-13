package dungeon.cases.stuffs.defensiveStuffs.shields;

import dungeon.characters.Characters;
import dungeon.characters.warrior.Warrior;
import dungeon.menus.Menu;

/**
 * Class legacy of Shield class
 */
public class IronShield extends Shield{
    /**
     * Constructor without parameter, call the constructor parent and passed the parameters in this.
     * A name -> type String for shield attribute value
     * A defense -> type Integer for defense attribute value
     * A defPoints -> type Integer for defPoints attribute value
     */
    public IronShield() {
        super("IronShield",4,4);
    }

    /**
     * Method toString return string value
     * This method return the value of shield attribute.
     * @return String
     */
    public String toString(){ return this.shield; }


}
