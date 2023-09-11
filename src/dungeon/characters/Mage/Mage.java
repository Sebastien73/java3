package dungeon.characters.Mage;

import dungeon.characters.Characters;

public class Mage extends Characters {

    public Mage(){
        super("BobMage",5,5);
    };
    public Mage(String name){
        super(name,5,5);
    }
    public Mage(String name, int pointLife, int pointAttack) {
        super(name, pointLife, pointAttack);
    }

    @Override
    public String toString() {
        return "Name : "+this.getName() + " , "+"Life : " + this.getPointLife()+" , "+"Strength : "+ this.getPointAttack()+".";
    }

}
