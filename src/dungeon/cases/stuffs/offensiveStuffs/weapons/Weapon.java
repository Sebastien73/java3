package dungeon.cases.stuffs.offensiveStuffs.weapons;

import dungeon.cases.cases.Case;
import dungeon.cases.stuffs.offensiveStuffs.weapons.swords.Sword;
import dungeon.characters.Characters;
import dungeon.characters.warrior.Warrior;
import dungeon.menus.Menu;

/**
 * Class parent of many children
 * Implement Case interface
 */
abstract public class Weapon implements Case {

    /**
     * Attribute protected nameOfWeapon typeof String
     * This attribute will be used by children class of Weapon class
     */
    protected String nameOfWeapon;

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
    protected Weapon(String name,int attack,String type){
        this.nameOfWeapon = name;
        this.attack = attack;
        this.type = type;
    }

    /**
     * Return attribute value of nameOfWeapon. Type -> String
     * @return attribute value
     */
    public String getNameOfWeapon() {
        return this.nameOfWeapon;
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
        this.nameOfWeapon = name;
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
        if (currentCharacter instanceof Warrior warrior) {
            System.out.println("You find " + ((this instanceof Sword)?"a sword!\n":"a mace"));
            int getWeapon = new Menu().getIntResult("Get this weapon ?\n" + " 1-Yes\n" + " 2-No");;
            switch (getWeapon) {
                case 1 -> {
                    warrior.grabWeapon(this);
                    System.out.println("Your attack is now at : " + warrior.getPointAttack());
                }
                case 2 -> {}
            }
        } else {
            System.out.println("You need to be a warrior for use this weapon.");
        }
    }
}
