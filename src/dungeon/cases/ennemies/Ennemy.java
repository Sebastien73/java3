package dungeon.cases.ennemies;

import dungeon.cases.CasesType;
import dungeon.cases.cases.Case;
import dungeon.characters.Characters;
import java.util.Scanner;

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

    private void wantToFight(){
        String nameClassParent = this.getClass().getSuperclass().getSimpleName();

        if (CasesType.enumContainsValue(nameClassParent)) {
            System.out.println("You are on " + CasesType.valueOf(nameClassParent) + " case.");
        }
        System.out.println("This " + this + " want to fight \n1-Fight\n2-Flee");
    }

    /**
     * Implements method interaction of interface case
     * @param current Characters
     */
    @Override
    public void interaction(Characters current) {
        if (current != null) {
            chooseUserWhileFight(current);
        }
    }

    public void chooseUserWhileFight(Characters current){
        wantToFight();
        Scanner scanner = new Scanner(System.in);
        int fightChoice = scanner.nextInt();
        switch (fightChoice) {
            case 1 -> current.setFight(true);
            case 2 -> current.setFleeAway(true);
        }
    }

    /**
     * Method ennemyIsAlive return boolean after compared with value of attribute pointOfLife.
     * @return boolean
     */
    public boolean ennemyIsAlive(){
        return this.getPointOfLife() > 0;
    }

    public void receiveAttack(Characters current) {
        this.setPointOfLife(this.getPointOfLife() - current.getPointLife());
    }
}
