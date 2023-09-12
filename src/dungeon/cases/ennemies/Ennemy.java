package dungeon.cases.ennemies;

import dungeon.cases.cases.Case;

/**
 * Class Ennemy implement Case interface
 */
public class Ennemy implements Case {
    /**
     * Attribute race / type -> String
     */
    private String race;
    /**
     * Attribute pointOfLife / type -> Integer
     */
    private int pointOfLife;
    /**
     * Attribute pointOfAttack / type -> Integer
     */
    private int pointOfAttack;

    /**
     * Constructor with 3 parameters / race -> String / pointOfLife -> Integer / pointOfAttack -> Integer
     * @param race String
     * @param pointOfLife Integer
     * @param pointOfAttack Integer
     */
    protected Ennemy(String race, int pointOfLife, int pointOfAttack) {
        this.race= race;
        this.pointOfLife = pointOfLife;
        this.pointOfAttack = pointOfAttack;
    }
    /**
     * Return value of attribute race / type -> String
     * @return String
     */
    public String getRace() {
        return this.race;
    }

    /**
     * Return value of attribute pointOfLife / type -> Integer
     * @return Integer
     */
    public int getPointOfLife() {
        return this.pointOfLife;
    }
    /**
     * Return value of attribute pointOfAttack / type -> Integer
     * @return Integer
     */
    public int getPointOfAttack() {
        return this.pointOfAttack;
    }

    /**
     * Method for set value of attribute race / type -> String
     * @param race String
     */
    public void setRace(String race) {
        this.race = race;
    }
    /**
     * Method for set value of attribute pointOfLife / type -> Integer
     * @param pointOfLife Integer
     */
    public void setPointOfLife(int pointOfLife) {
        this.pointOfLife = pointOfLife;
    }

    /**
     * Method for set value of attribute pointOfAttack / type -> Integer
     * @param pointOfAttack Integer
     */
    public void setPointOfAttack(int pointOfAttack) {
        this.pointOfAttack = pointOfAttack;
    }

    /**
     * Method toString return value of attribute race / type -> String
     * @return String
     */
    public String toString(){ return this.race; }
    private void wantToFight(){ System.out.println("This " + this + " want to fight \n1-Fight\n2-Flee"); }

    /**
     * Method ennemyIsAlive return boolean after compared with value of attribute pointOfLife.
     * @return boolean
     */
    public boolean ennemyIsAlive(){
        return this.getPointOfLife() > 0;
    }
}
