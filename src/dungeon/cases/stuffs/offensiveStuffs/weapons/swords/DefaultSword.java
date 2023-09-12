package dungeon.cases.stuffs.offensiveStuffs.weapons.swords;

/**
 * Class legacy of Sword
 */
public class DefaultSword extends Sword{
    /**
     * Constructor when object ShortSword is invoke with his attribute value
     */
    public DefaultSword() {
        super("LittleSword",5,"Sword");
    }

    /**
     * Method toString return String value with attribute nameOfWeapon and type of class parent
     * @return String
     */
    public String toString(){ return this.nameOfWeapon + this.type ;}

}
