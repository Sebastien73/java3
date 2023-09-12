package dungeon.game;

import dungeon.characters.Characters;

/**
 * Class game for control of party and player
 */
public class Game {

    /**
     * Attribute character typeof Characters
     */
    private Characters character;
    /**
     * Attribute isWarrior typeof bool
     */
    private boolean isWarrior;


    /**
     * Method play for set up a party with a selected character by user and boolean for know the type of his character
     * @param character Characters
     * @param isWarrior boolean
     */
    public void play(Characters character, boolean isWarrior) {
        System.out.println("STARTING GAME with \n" + character + " type -> " + (isWarrior ? "warrior" : "mage"));
    }
}
