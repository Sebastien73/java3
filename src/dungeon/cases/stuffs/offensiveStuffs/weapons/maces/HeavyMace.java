package dungeon.cases.stuffs.offensiveStuffs.weapons.maces;
/**
 * Class legacy of Mace
 */
public class HeavyMace extends Mace{
    /**
     * Constructor when object HeavyMace is invoke with his attribute value
     */
    public HeavyMace() {
        super("HeavyMace",8,"Mace");
    }

    /**
     * Method toString return String value with attribute nameOfWeapon and type of class parent
     * @return String
     */
    public String toString(){ return this.nameOfWeapon + this.type ;}
}
