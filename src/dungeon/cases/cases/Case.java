package dungeon.cases.cases;

import dungeon.characters.Characters;

public interface Case {

     default void interaction(Characters character) {};
}
