package dungeon.cases.ennemies.dragons;

import dungeon.cases.ennemies.Ennemy;

/**
 * Class legacy of Ennemy
 */
abstract public class Dragon extends Ennemy {
    /**
     * Attribute for each type of dragons.
     */
    protected String element;

    /**
     * Constructor used bu children class of Dragon with one parameter type of String
     * @param element String
     */
    protected Dragon(String element){
        this("Dragon",15,4);
        this.element = element;
    }

    /**
     * Constructor used constructor parent / class -> Ennemy
     * Constructor with 3 parameters / race -> String / pointOfLife -> Integer / pointOfAttack -> Integer
     * @param race          String
     * @param pointOfLife   Integer
     * @param pointOfAttack Integer
     */
    protected Dragon(String race, int pointOfLife, int pointOfAttack) {
        super(race, pointOfLife, pointOfAttack);
    }

    /**
     * Method toString used here with abstract for may use it in children class
     * @return String
     */
    @Override
    public abstract String toString();
}
