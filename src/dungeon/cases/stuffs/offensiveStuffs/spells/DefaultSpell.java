package dungeon.cases.stuffs.offensiveStuffs.spells;

/**
 * Class legacy of Spell
 */
public class DefaultSpell extends Spell{
    /**
     * Constructor when object DefaultSpell is invoke with his attribute value
     */
    public DefaultSpell() {
        super("BasicSpell",10,"Spell");
    }

    /**
     * Method toString return String value with attribute nameOfWeapon and type of class parent
     * @return String
     */
    public String toString(){ return this.nameOfSpell + this.type ;}
}
