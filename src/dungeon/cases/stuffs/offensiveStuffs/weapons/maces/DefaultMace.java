package dungeon.cases.stuffs.offensiveStuffs.weapons.maces;
/**
 * Class legacy of Mace
 */
public class DefaultMace extends Mace {

    /**
     * Constructor when object DefaultMace is invoke with his attribute value
     */
    public DefaultMace() {
        super("LittleMace",4,"Mace");
    }

    /**
     * Method toString return String value with attribute nameOfWeapon and type of class parent
     * @return String
     */
    public String toString(){ return this.nameOfWeapon + this.type ;}
}
