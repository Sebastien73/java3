package dungeon.cases.stuffs.offensiveStuffs.weapons.maces;
/**
 * Class legacy of Mace
 */
public class MagicMace extends Mace{
    /**
     * Constructor when object MagicMace is invoke with his attribute value
     */
    public MagicMace() {
        super("Magic",7,"Mace");
    }

    /**
     * Method toString return String value with attribute nameOfWeapon and type of class parent
     * @return String
     */
    public String toString(){ return this.nameOfWeapon + this.type ;}
}
