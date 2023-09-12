package dungeon.characters.Mage;

import dungeon.cases.stuffs.defensiveStuffs.potions.Potion;
import dungeon.characters.Characters;

/**
 * Class Mage legacy of Characters class
 */
public class Mage extends Characters {

    /**
     * Constructor without parameters
     */
    public Mage(){
        super("BobMage",5,5);
    };

    /**
     * Constructor with a parameter name
     * @param name string
     */
    public Mage(String name){
        super(name,5,5);
    }

    /**
     * Constructor with three parameters
     * @param name string
     * @param pointLife int
     * @param pointAttack int
     */
    public Mage(String name, int pointLife, int pointAttack) {
        super(name, pointLife, pointAttack);
    }

    /**
     * Method toString for display object correctly
     * @return string
     */
    @Override
    public String toString() {
        return "Name : "+this.getName() + " , "+"Life : " + this.getPointLife()+" , "+"Strength : "+ this.getPointAttack()+".";
    }

    public void grabPotion(Potion potion){ this.setPointLife(this.getPointLife()+ potion.getPointOfLife()); }

}
