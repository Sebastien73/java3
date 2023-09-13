package dungeon.cases.stuffs.offensiveStuffs.weapons.swords;
/**
 * Class legacy of Sword
 */
public class MagicSword extends Sword{
    /**
     * Constructor when object MagicSword is invoke with his attribute value
     */
    public MagicSword() {
        super("Magic",8,"Sword");
    }

    /**
     * Method toString return String value with attribute nameOfWeapon and type of class parent
     * @return String
     */
    public String toString(){ return this.nameOfWeapon + this.type ;}
}
