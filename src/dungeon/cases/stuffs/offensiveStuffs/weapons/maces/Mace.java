package dungeon.cases.stuffs.offensiveStuffs.weapons.maces;

import dungeon.cases.stuffs.offensiveStuffs.weapons.Weapon;

/**
 * Class Mace legacy of Weapon class
 */
public abstract class Mace extends Weapon {
    /**
     * Constructor with 3 parameters : name, attack and type
     * @param name   String
     * @param attack Integer
     * @param type   String
     */
    protected Mace(String name, int attack, String type) {
        super(name, attack, type);
    }
}
