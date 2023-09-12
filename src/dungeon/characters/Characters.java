package dungeon.characters;

import dungeon.cases.stuffs.offensiveStuffs.weapons.Weapon;
import dungeon.cases.stuffs.offensiveStuffs.spells.Spell;

/**
 * Class Characters parent of many children
 */
abstract public class Characters {

    /**
     * attribute string name
     * attribute int pointLife
     * attribute int pointAttack
     */
    protected String name;
    protected int pointLife;
    protected int pointAttack;


    /**
     * Constructor used by children class (protected)
     * @param name string
     * @param pointLife int
     * @param pointAttack int
     */
    protected Characters(String name, int pointLife, int pointAttack) {
        this.name = name;
        this.pointLife = pointLife;
        this.pointAttack = pointAttack;

    }

    /**
     * Getter method for attribute name
     * @return attribute name value
     */
    public String getName() { return this.name; }
    /**
     * Getter method for attribute pointLife
     * @return attribute pointLife value
     */
    public int getPointLife(){ return this.pointLife; }
    /**
     * Getter method for attribute pointAttack
     * @return attribute pointAttack value
     */
    public int getPointAttack(){ return this.pointAttack;}

    /**
     * Setter method for set value of attribute name
     * @param name string
     */
    public void setName(String name) { this.name = name; }
    /**
     * Setter method for set value of attribute pointLife
     * @param pointLife string
     */
    public void setPointLife(int pointLife) { this.pointLife = pointLife; }
    /**
     * Setter method for set value of attribute pointAttack
     * @param pointAttack string
     */
    public void setPointAttack(int pointAttack) { this.pointAttack = pointAttack; }

    /**
     * Method toString with abstract type for may to use in children class
     * @return string
     */
    public abstract String toString();

    /**
     * Method for change attribute value pointAttack when user fall on case with weapon.
     * @param weapon Weapon
     */
    public void grabWeapon(Weapon weapon){
        this.setPointAttack(this.getPointAttack() + weapon.getAttack());
    }

    /**
     * Method for change attribute value pointAttack when user fall on case with weapon.
     * @param spell Weapon
     */
    public void grabSpell(Spell spell){
        this.setPointAttack(this.getPointAttack() + spell.getAttack());
    }

    protected boolean personnageIsAlive(){
        return this.getPointLife() > 0;
    }
}
