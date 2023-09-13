package dungeon.game;

public class OutOfBoardException extends Exception{
    public OutOfBoardException(){
        super("You WON!");
    }
}
