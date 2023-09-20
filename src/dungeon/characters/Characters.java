package dungeon.characters;

import dungeon.cases.ennemies.Ennemy;
import dungeon.cases.stuffs.offensiveStuffs.weapons.Weapon;
import dungeon.cases.stuffs.offensiveStuffs.spells.Spell;
import dungeon.game.CharacterDeadException;

/**
 * Class Characters parent of many children
 */
abstract public class Characters {

    /**
     * attribute int id
     * attribute string name
     * attribute int pointLife
     * attribute int pointAttack
     * attribute bool fleeAway
     * attribute bool isFight
     */
    protected int id;
    protected String name;
    protected int pointLife;
    protected int pointAttack;
    private boolean fleeAway;
    private boolean isFight;

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

    protected Characters(int id,String name, int pointLife, int pointAttack) {
        this.id = id;
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
     * Getter method for attribute id
     * @return Integer
     */
    public int getId() {
        return this.id;
    }

    /**
     * Getter method for attribute fleeAway
     * @return boolean
     */
    public boolean isFleeAway() {return fleeAway;}
    /**
     * Getter method for attribute isFight
     * @return boolean
     */
    public boolean isFight() {return isFight;}
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
     * Setter method for set value of attribute fleeAway
     * @param fleeAway boolean
     */
    public void setFleeAway(boolean fleeAway) {this.fleeAway = fleeAway;}

    /**
     * Setter method for set value of attribute isFight
     * @param fight boolean
     */
    public void setFight(boolean fight) {this.isFight = fight;}
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

    protected boolean characterIsAlive(){
        return this.getPointLife() > 0;
    }

    public void receiveAttack(Ennemy ennemy) throws CharacterDeadException {
        this.setPointLife(this.getPointLife() - ennemy.getPointOfAttack());
        if (!characterIsAlive()){
            throw new CharacterDeadException();
        }
    }
}
