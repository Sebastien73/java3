package dungeon.cases.ennemies.wizards;

import dungeon.cases.ennemies.Ennemy;
/**
 * Class legacy of Ennemy
 */
abstract public class Wizard extends Ennemy {
    /**
     * Attribute for each type of dragons.
     */
    protected String name;

    /**
     * Constructor used bu children class of Wizard with one parameter type of String
     * @param name String
     */
    protected Wizard(String name){
        this("Wizard",9,2);
        this.name = name;
    }

    /**
     * Constructor with 3 parameters / race -> String / pointOfLife -> Integer / pointOfAttack -> Integer
     * @param race          String
     * @param pointOfLife   Integer
     * @param pointOfAttack Integer
     */
    protected Wizard(String race, int pointOfLife, int pointOfAttack) {
        super(race, pointOfLife, pointOfAttack);
    }

    /**
     * Method toString used here with abstract for may use it in children class
     * @return String
     */
    @Override
    public abstract String toString();
}
