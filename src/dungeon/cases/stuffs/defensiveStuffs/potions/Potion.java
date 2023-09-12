package dungeon.cases.stuffs.defensiveStuffs.potions;

import dungeon.cases.cases.Case;
import dungeon.characters.Characters;
import dungeon.characters.Mage.Mage;
import dungeon.menus.Menu;

/**
 * Class parent of many children
 * Implement Case interface
 */
public abstract class Potion implements Case {
    /**
     * Attribute String name
     */
    private String name;

    /**
     * Atribute Integer pointOfLife
     */
    private int pointOfLife;

    /**
     * Constructor with 2 parameters / name type -> String / pointOfLife type -> Integer
     * @param name String
     * @param life Integer
     */
    protected Potion(String name,int life){
        this.name= name;
        this.pointOfLife= life;
    }

    /**
     * Return the value of attribute name / type -> String
     * @return String
     */
    public String getName() {
        return this.name;
    }
    /**
     * Return the value of attribute pointOfLife / type -> Integer
     * @return Integer
     */
    public int getPointOfLife() {
        return this.pointOfLife;
    }

    /**
     * Method for set a value of the attribute name / type -> String
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Method for set a value of the attribute pointOfLife / type -> Integer
     * @param pointOfLife Integer
     */
    public void setPointOfLife(int pointOfLife) {
        this.pointOfLife = pointOfLife;
    }

    @Override
    public void interaction(Characters currentCharacter) {

        if (currentCharacter instanceof Mage mage) {
            System.out.println("You find " + ((this instanceof BigPotion)?"a big health potion!\n":"a little health potion"));
            int grabPotion = new Menu().getIntResult("Use potion ?\n" + " 1-Yes\n" + " 2-No");
            switch (grabPotion) {
                case 1 -> {
                    mage.grabPotion(this);
                    System.out.println("Your points of life is now at : " + mage.getPointLife());
                }
                case 2 -> {
                }
            }

        } else {
            System.out.println("You need to be a wizard for use this potion.");
        }
    }
}
