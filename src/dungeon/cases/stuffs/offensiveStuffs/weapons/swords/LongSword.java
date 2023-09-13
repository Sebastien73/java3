package dungeon.cases.stuffs.offensiveStuffs.weapons.swords;
/**
 * Class legacy of Sword
 */
public class LongSword extends Sword{
    /**
     * Constructor when object LongSword is invoke with his attribute value
     */
    public LongSword() {
        super("Long",7,"Sword");
    }

    /**
     * Method toString return String value with attribute nameOfWeapon and type of class parent
     * @return String
     */
    public String toString(){ return this.nameOfWeapon + this.type ;}
}
