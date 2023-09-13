package dungeon.cases.stuffs.offensiveStuffs.weapons.maces;
/**
 * Class legacy of Mace
 */
public class LightMace extends Mace{
    /**
     * Constructor when object LightMace is invoke with his attribute value
     */
    public LightMace() {
        super("Light",6,"Mace");
    }

    /**
     * Method toString return String value with attribute nameOfWeapon and type of class parent
     * @return String
     */
    public String toString(){ return this.nameOfWeapon + this.type ;}
}
