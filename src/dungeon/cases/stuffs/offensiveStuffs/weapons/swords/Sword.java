package dungeon.cases.stuffs.offensiveStuffs.weapons.swords;

import dungeon.cases.stuffs.offensiveStuffs.weapons.Weapon;

/**
 * Class Sword legacy of Weapon class
 */
public abstract class Sword extends Weapon {
    /**
     * Constructor with 3 parameters : name, attack and type
     * @param name   String
     * @param attack Integer
     * @param type   String
     */
    protected Sword(String name, int attack, String type) {
        super(name, attack, type);
    }
}
