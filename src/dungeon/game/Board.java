package dungeon.game;

import dungeon.cases.cases.Case;
import dungeon.cases.cases.StartCase;

import java.util.ArrayList;
import java.util.Collections;

public class Board {
    /**
     * Attribute board typeof ArrayList of Case
     */
    private final ArrayList<Case> board = new ArrayList<>();

    /**
     * Constructor without parameters and call initBoard method
     */
    public Board(){
        initBoard();
    }

    /**
     * Return an Integer value of size of board
     * @return int
     */
    public int sizeBoard(){
        return board.size();
    }

    /**
     * return string with toString method of Object who implement Case interface
     * Integer i = index
     * @param i integer
     * @return string
     */
    public String caseInfo(int i){
        return board.get(i).toString();
    }

    /**
     * return object of this Case
     * Integer i = index of arrayList
     * @param i integer
     * @return Object
     */
    public Object getObject(int i){ return board.get(i); }

    /**
     * Set a StartCase object on index 0 of board
     */
    public void startPlace(){
        board.set(0, new StartCase());
    }

    public void emptyPlace(){}

    public void littlePotionPlace(){}
    public void bigPotionPlace(){}


    /**
     * Method for swap case's placement for each new party.
     */
    public void swap(){
        for (int i=0;i<100;i++) {
            int firstIndex = (int) ((Math.random() * 62) + 1);
            int secondIndex = (int) ((Math.random() * 62) + 1);
            Collections.swap(board, firstIndex, secondIndex);
        }
    }

    /**
     * Initialize board
     */
    private void initBoard(){
        startPlace();
        emptyPlace();
        littlePotionPlace();
        bigPotionPlace();
        swap();
    }

}
