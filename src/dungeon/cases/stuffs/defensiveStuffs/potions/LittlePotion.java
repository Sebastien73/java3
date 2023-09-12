package dungeon.cases.stuffs.defensiveStuffs.potions;

/**
 * Class legacy of Potion
 */
public class LittlePotion extends Potion{
    /**
     * Constructor when object LittlePotion is invoke with his attribute value
     */
    protected LittlePotion() {
        super("Little health potion",2);
    }

    /**
     * Method toString return String value with attribute name of potion and point of life of class parent
     * @return String
     */
    public String toString(){ return this.getName() + this.getPointOfLife() ;}
}
