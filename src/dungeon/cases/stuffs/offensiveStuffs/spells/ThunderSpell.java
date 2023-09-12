package dungeon.cases.stuffs.offensiveStuffs.spells;

/**
 * Class legacy of Spell
 */
public class ThunderSpell extends Spell{
    /**
     * Constructor when object ThunderSpell is invoke with attribute of parent Class
     */
    protected ThunderSpell() {
        super("ThunderSpell",12,"Spell");
    }

    /**
     * Method toString return String value with attribute nameOfSpell and type of class parent
     * @return String
     */
    public String toString(){ return this.nameOfSpell + this.type ;}
}
