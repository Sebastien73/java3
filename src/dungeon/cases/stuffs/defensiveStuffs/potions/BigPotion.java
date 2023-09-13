package dungeon.cases.stuffs.defensiveStuffs.potions;
/**
 * Class legacy of Potion
 */
public class BigPotion extends Potion{
    /**
     * Constructor when object BigPotion is invoke with his attribute value
     */
    public BigPotion() {
        super("Big health potion",5);
    }

    /**
     * Method toString return String value with attribute name of potion and point of life of class parent
     * @return String
     */
    public String toString(){ return this.getName() + " (for add + "+ this.getPointOfLife() + "points of Life)";}
}
