package dungeon.cases.stuffs.defensiveStuffs.shields;

import dungeon.cases.cases.Case;
import dungeon.characters.Characters;
import dungeon.characters.warrior.Warrior;
import dungeon.menus.Menu;

/**
 * Class parent of many children
 */
public abstract class Shield implements Case {
    /**
     * Attribute defense type of Integer
     * Protected attribute for may to use it by child
     */
    protected int defense;
    /**
     * Attribute shield type of String
     * Protected attribute for may to use it by child
     */
    protected String shield;

    /**
     * Attribute defPoints type of Integer
     * Protected attribute for may to use it by child
     */
    protected int defPoints;

    /**
     * Constructor may to use it of each children class of Shield
     * Constructor with 3 parameters : shield -> String / defense -> Integer / defPoints -> Integer
     * @param shield String
     * @param defense Integer
     * @param defPoints Integer
     */
    protected Shield(String shield,int defense,int defPoints) {
        this.shield = shield;
        this.defense = defense;
        this.defPoints = defPoints;
    }

    /**
     * Get value of defense attribute / type -> Integer
     * @return Integer
     */
    public int getDefense() {
        return this.defense;
    }

    /**
     * Get value of shield attribute / type -> String
     * @return String
     */
    public String getShield() {
        return this.shield;
    }

    /**
     * Get value of defPoint attribute / type -> Integer
     * @return Integer
     */
    public int getDefPoints() {
        return this.defPoints;
    }

    /**
     * Method for set a value of attribute defense / type -> Integer
     * @param defense Integer
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * Method for set a value of attribute shield / type -> String
     * @param shield String
     */
    public void setShield(String shield) {
        this.shield = shield;
    }

    /**
     * Method for set a value of attribute defPoints / type -> Integer
     * @param defPoints Integer
     */
    public void setDefPoints(int defPoints) {
        this.defPoints = defPoints;
    }

    /**
     * Method toString return string value
     * Use abstract for may child class to use it
     * @return String
     */
    public abstract String toString();

    /**
     * Method interaction of interface Case implements in parent Class and use in children class
     * @param currentCharacter Characters
     */
    @Override
    public void interaction(Characters currentCharacter) {
        if (currentCharacter instanceof Warrior warrior) {
            System.out.println("You find " + ((this instanceof IronShield)?"a iron shield!\n":"a wood shield!"));
            int getShield = new Menu().getIntResult("Get shield ?\n" + " 1-Yes\n" + " 2-No");
            switch (getShield) {
                case 1 -> {
                    warrior.useShield(this);
                    System.out.println("Your points of defense is now at : " + this.getDefense());
                }
                case 2 -> {
                }
            }
        } else {
            System.out.println("You need to be a warrior for use this shield.");
        }
    }
}
