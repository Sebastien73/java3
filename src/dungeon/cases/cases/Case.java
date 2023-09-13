package dungeon.cases.cases;

import dungeon.characters.Characters;

/**
 * Set up interface for each case of board
 */
public interface Case {
    /**
     * Method interaction with one parameter typeof Characters.
     * This method will be implements of all class needed to treat an interaction when current character meet something on a case
     * @param character Characters
     */
    void interaction(Characters character);
}
