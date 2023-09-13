package dungeon.characters.warrior;

import dungeon.cases.stuffs.defensiveStuffs.shields.Shield;
import dungeon.cases.stuffs.offensiveStuffs.weapons.Weapon;
import dungeon.characters.Characters;

/**
 * Class Warrior legacy of Characters class
 */
public class Warrior extends Characters {

    /**
     * Constructor without parameters
     */
    public Warrior(){
        super("BobWarior",5,5);
    };

    /**
     * Constructor with a parameter name
     * @param name string
     */
    public Warrior(String name){
        super(name,5,5);
    }

    /**
     * Constructor with three parameters
     * @param name string
     * @param pointLife int
     * @param pointAttack int
     */
    public Warrior(String name, int pointLife, int pointAttack) {
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

    public void useShield(Shield shield){
        shield.setDefense(shield.getDefPoints());
    }

}
