package dungeon.characters.warrior;

import dungeon.characters.Characters;

public class Warrior extends Characters {
    public Warrior(){
        super("BobWarior",5,5);
    };
    public Warrior(String name){
        super(name,5,5);

    }
    public Warrior(String name, int pointLife, int pointAttack) {
        super(name, pointLife, pointAttack);
    }

    @Override
    public String toString() {
        return "Name : "+this.getName() + " , "+"Life : " + this.getPointLife()+" , "+"Strength : "+ this.getPointAttack()+".";
    }

}
