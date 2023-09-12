package dungeon.cases.stuffs.offensiveStuffs.spells;

import dungeon.cases.cases.Case;
import dungeon.characters.Characters;
import dungeon.characters.Mage.Mage;
import dungeon.menus.Menu;
import dungeon.cases.stuffs.offensiveStuffs.spells.ThunderSpell;

/**
 * Class parent of many children
 * Implement Case interface
 */
public abstract class Spell implements Case {
    /**
     * Attribute protected nameOfWeapon typeof String
     * This attribute will be used by children class of Weapon class
     */
    protected String nameOfSpell;

    /**
     * Attribute private attack typeof Integer
     * This attribute could be modified with his getter/setter
     */
    private int attack;

    /**
     * Attribute protected type typeof String
     * This attribute will be used by children class of Weapon class
     */
    protected String type;

    /**
     * Constructor with 3 parameters : name, attack and type
     * @param name String
     * @param attack Integer
     * @param type String
     */
    protected Spell(String name,int attack,String type){
        this.nameOfSpell = name;
        this.attack = attack;
        this.type = type;
    }

    /**
     * Return attribute value of nameOfWeapon. Type -> String
     * @return attribute value
     */
    public String getNameOfWeapon() {
        return this.nameOfSpell;
    }

    /**
     * Return attribute value of attack. Type -> Integer
     * @return attribute value
     */
    public int getAttack() {
        return this.attack;
    }

    /**
     * Value of type String for set name attribute nameOfWeapon for weapon.
     * @param name String
     */
    public void setNameOfWeapon(String name) {
        this.nameOfSpell = name;
    }

    /**
     * Value of type Integer for set attribute attack for weapon.
     * @param pointAttack Integer
     */
    public void setAttack(int pointAttack) {
        this.attack = pointAttack;
    }

    @Override
    public void interaction(Characters currentCharacter) {
        if (currentCharacter instanceof Mage mage) {
            System.out.println("You find " + ((this instanceof ThunderSpell)?"a thunder spell!\n":"a fireball spell"));
            int getSpell = new Menu().getIntResult("Get this spell ?\n" + " 1-Yes\n" + " 2-No");
            switch (getSpell) {
                case 1 -> {
                    mage.grabSpell(this);
                    System.out.println("Your attack is now at : " + mage.getPointAttack());
                }
                case 2 -> {}
            }
        }else{
            System.out.println("You need to be a wizard for use this spell.");
        }
    }
}
