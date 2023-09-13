package dungeon.cases.stuffs.offensiveStuffs.spells;
/**
 * Class legacy of Spell
 */
public class FireballSpell extends Spell {
    /**
     * Constructor when object FireballSpell is invoke with attribute of parent Class
     */
    public FireballSpell() {
        super("Fireball",15,"Spell");
    }

    /**
     * Method toString return String value with attribute nameOfSpell and type of class parent
     * @return String
     */
    public String toString(){ return this.nameOfSpell + this.type ;}
}
