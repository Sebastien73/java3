package dungeon.game;

import dungeon.cases.ennemies.Ennemy;
import dungeon.characters.Characters;
import dungeon.menus.Menu;

import java.util.Scanner;

/**
 * Class game for control of party and player
 */
public class Game {
    /**
     * Attribute board typeof Board Class
     */
    private final Board board;
    /**
     * Attribute scanner typeof Scanner
     */
    private final Scanner scanner;

    /**
     * Constructor when invok new Game object
     */
    public Game(){
        this.board = new Board();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Method play for set up a party with a selected character by user and boolean for know the type of his character
     * @param character Characters
     * @param isWarrior boolean
     */
    public void play(Characters character, boolean isWarrior) throws CharacterDeadException, OutOfBoardException {
        int positionPlayer = 0;

        System.out.println("Game is starting\n" + character.getName() + " type -> " + (isWarrior ? "warrior" : "mage") + " is on case : " + positionPlayer + "/" + board.sizeBoard());
        System.out.println(board.caseInfo(positionPlayer));

        while (board.sizeBoard() > positionPlayer && character.getPointLife() > 0) {

            boolean continu = false;

            if (character.isFleeAway()){
                positionPlayer -= (int) ((Math.random() * 6) + 1);
                if (positionPlayer < 0) {
                    positionPlayer = 1;
                }
                displayCharacterPositionAndInteract(character,positionPlayer);
                character.setFleeAway(false);
            }


            System.out.println("Roll?\n  1-Yes\n  2-Left the party and back to main menu");
            int response = scanner.nextInt();
            switch (response) {
                case 1 -> continu = true;
                case 2 -> new Menu().menuPrincipal();
            }

            if (continu) {
                positionPlayer += (int) ((Math.random() * 6) + 1);
                if (positionPlayer >= board.sizeBoard()) {
                    throw new OutOfBoardException();
                }
            }
            if (character.getPointLife() <= 0){
                throw new CharacterDeadException();
            }
            displayCharacterPositionAndInteract(character,positionPlayer);
            if (character.isFight()){
                fight((Ennemy) board.getObject(positionPlayer), character);
                character.setFight(false);
            }
        }
    }

    private void displayCharacterPositionAndInteract(Characters character, int positionPlayer) throws CharacterDeadException {
        System.out.println("Now " + character.getName() + " is on : " + positionPlayer + "/" + board.sizeBoard() + "\n" + board.caseInfo(positionPlayer));
        this.board.interaction(positionPlayer, character);
    }

    private void fight(Ennemy ennemy, Characters current) throws CharacterDeadException {
        while (ennemy.getPointOfLife() > 0) {
            ennemy.receiveAttack(current);
            System.out.println( ennemy.getRace()+" have now : " + ennemy.getPointOfLife() + " points of life");
            if (ennemy.ennemyIsAlive()){
                System.out.println("This "+ennemy.getRace()+" is now attacking you");
                current.receiveAttack(ennemy);
                System.out.println("This "+ennemy.getRace()+" hit "+current.getName() + " and you have now : " + current.getPointLife() + " points of life");
                ennemy.chooseUserWhileFight(current);
            }
        }
        System.out.println("This "+ennemy.getRace() + " is dead!\nYou has still : "+current.getPointLife()+" points of life.");
    }
}
