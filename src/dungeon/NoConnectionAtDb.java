package dungeon;

public class NoConnectionAtDb extends Exception{

    public NoConnectionAtDb(){
        super("WARNING ! The connection at the database isn't established.");
    }
}
