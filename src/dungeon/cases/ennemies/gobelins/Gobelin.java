package dungeon.cases.ennemies.gobelins;

import dungeon.cases.ennemies.Ennemy;

/**
 * Class legacy of Ennemy
 */
abstract public class Gobelin extends Ennemy {
    /**
     * Attribute for each type of gobelin.
     */
    protected String type;

    /**
     * Constructor used bu children class of Gobelin with one parameter type of String
     * @param type String
     */
    protected Gobelin(String type){
        this("Gobelin",6,1);
        this.type = type;
    }

    /**
     * Constructor used constructor parent / class -> Ennemy
     * Constructor with 3 parameters / race -> String / pointOfLife -> Integer / pointOfAttack -> Integer
     * @param race String
     * @param pointOfLife Integer
     * @param pointOfAttack Integer
     */
    protected Gobelin(String race, int pointOfLife, int pointOfAttack) {
        super(race,pointOfLife,pointOfAttack);
    }

    /**
     * Method toString used here with abstract for may use it in children class
     * @return String
     */
    @Override
    public abstract String toString();
}
