package dungeon.game;

public class CharacterDeadException extends Exception{
    public CharacterDeadException(){
        super("OMG ! Your character is dead! Game over! Try again :)");
    }
}
