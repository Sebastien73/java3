package dungeon.menus;

import dungeon.characters.Characters;
import dungeon.characters.Mage.Mage;
import dungeon.characters.warrior.Warrior;
import dungeon.game.Game;

import java.util.ArrayList;
import java.util.Scanner;
public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private ArrayList<Warrior> warriorsList;
    private ArrayList<Mage> wizardsList;

    /**
     * @param question string
     * @return scanner.next()
     * Get next result of prompt for switch options
     */
    private String getResult(String question) {
        System.out.println(question);
        return scanner.next();
    }

    /**
     * @param question string
     * @return scanner.next()
     * Get int for prompt in switch menu options
     */
    public  int getIntResult(String question) {
        try {
            return Integer.parseInt(getResult(question));
        } catch (NumberFormatException e) {
            return getIntResult(question);
        }
    }

    /**
     * @return new Warrior()
     * Invoke a new Warrior
     */
    public Warrior createWarrior(){
        return new Warrior();
    }

    /**
     * @return new Mage()
     * Invoke a new Mage
     */
    public Mage createWizard(){
        return new Mage();
    }

    /**
     * @param question string
     * @return string result
     */
    private  String getStringResult(String question){
        String a = getResult(question);
        try{
            Integer.parseInt(a);
        }catch (NumberFormatException e){
            return a;
        }
        return getStringResult(question);
    }

    /**
     * Principal menu
     * Create character or exit program
     */
    public void menuPrincipal(){
        int create = getIntResult("Principal menu : \n1 for create character\n2 for left the game"); //// On déclare la variable selector1 de type INT avec comme valeur l'attente d'un entier pour la variable clavier
        switch (create) { // On initialise un nouveau switch
            case 1 -> //Si la réponse est 1 alors on print une chaîne de caractére
                    createCharacter();
            case 2 -> { //Si la réponse est 2 alors on print une chaîne de caractére et on stop le programme
                System.out.println("Left the game");
                System.exit(0);
            }
        }
    }

    /**
     * Menu of creation of character
     * Back to previously menu
     * Exit program
     */
    public void createCharacter() {
        int create = getIntResult("Select type character : \n1 for Warrior\n2 for Wizard\n3 for back previously menu\n4 for left the game"); //// On déclare la variable selector1 de type INT avec comme valeur l'attente d'un entier pour la variable clavier
        switch (create) { // On initialise un nouveau switch
            case 1 -> //Si la réponse est 1, on va créer un guerrier
                    warriorSelect();
            case 2 -> //Si la réponse est 2, on va créer un mage
                    wizardSelect();
            case 3 -> //Si la réponse est 3, retour menu précédent
                    menuPrincipal();
            case 4 -> { //Si la réponse est 4 alors on print une chaîne de caractére et on stop le programme
                System.out.println("Left the game");
                System.exit(0);
            }
        }
    }

    /**
     * Select warrior type
     * Call infosOfCharacter
     */
    private void warriorSelect() {
        System.out.println("Warrior selected");
        Warrior warrior = createWarrior();
        infosOfCharacter(warrior,true);
    }

    /**
     * Select mage type
     * Call infosOfCharacter
     */
    private void wizardSelect() {
        System.out.println("Wizard selected");
        Mage mage = createWizard();
        infosOfCharacter(mage,false);
    }

    /**
     *
     * @param character Characters
     * @param isWarrior boolean
     * Change infos of the character previously created or play game directly
     * Back to the principal menu
     * Exit program
     */
    private void infosOfCharacter(Characters character, boolean isWarrior) {
        int setInfo = getIntResult("Indicate if you want to custom your " + (isWarrior ? "warrior" : "wizard") + " \n1 for Yes\n2 for No\n3 for back previously menu\n4 for left the game");
        switch (setInfo) {
            case 1 ->
                    setInfosOfCharacter(character,isWarrior);
            case 2 ->
                   readyToPlay(character,isWarrior);
            case 3 -> //Si la réponse est 3, retour menu précédent
                    menuPrincipal();
            case 4 -> { //Si la réponse est 4 alors on print une chaîne de caractére et on stop le programme
                System.out.println("Left the game");
                System.exit(0);
            }
        }
    }

    /**
     *
     * @param character Characters
     * @param isWarrior boolean
     * Call setParameters method
     */
    private void setInfosOfCharacter(Characters character, boolean isWarrior) {
        setParameters(character,isWarrior);
    }

    /**
     *
     * @param character Characters
     * @param isWarrior boolean
     * Call different method to set attributes of character
     * Last method called : readyToPlay
     */
    private void setParameters(Characters character, boolean isWarrior) {
        setNameCharacter(character);
        setPointOfLifeCharacter(character, isWarrior);
        setPointOfAttackCharacter(character,isWarrior);
        readyToPlay(character,isWarrior);
    }

    /**
     *
     * @param character Character
     * Set a name for current character
     */
    private void setNameCharacter(Characters character) {
        String nameCharacter = getStringResult("Enter name for your character");

        if (!nameCharacter.isEmpty()) {
            character.setName(nameCharacter);
        } else {
            nameCharacter = getStringResult("Thanks to write a valid name");
        }
    }

    /**
     * @param character Characters
     * @param isWarrior boolean
     * Set point of life for current character
     */
    private void setPointOfLifeCharacter(Characters character, boolean isWarrior) {
        int pointOfLife = getIntResult("Enter number for points of life " + (isWarrior ? "(between 5 and 10)" : "(between 3 and 6)"));
        if (isWarrior) {
            while (pointOfLife < 5 || pointOfLife > 10) {
                pointOfLife = getIntResult("Enter a good value (between 5 and 10)");
            }
        }
        if (!isWarrior) {
            while (pointOfLife < 3 || pointOfLife > 6) {
                pointOfLife = getIntResult("Enter a good value (between 3 and 6)");
            }
        }
        character.setPointLife(pointOfLife);
    }

    /**
     * @param character Characters
     * @param isWarrior boolean
     * Set points of strength for current character
     */
    private void setPointOfAttackCharacter(Characters character, boolean isWarrior){
        int pointAtk = getIntResult("Enter number for attack's points" + ((isWarrior) ? "(between 5 and 10)" : "(between 8 and 15)"));
        if (isWarrior) {
            while (pointAtk < 5 || pointAtk > 10) {
                pointAtk = getIntResult("Enter a good value (between 5 and 10)");
            }
        }
        if (!isWarrior) {
            while (pointAtk < 8 || pointAtk > 15) {
                pointAtk = getIntResult("Enter a good value (between 8 and 15)");
            }
        }
        character.setPointAttack(pointAtk);
    }

    /**
     * @param character Characters
     * @param isWarrior boolean
     * Invoke a new object Game
     * Call play method with the current character and boolean
     */
    private void readyToPlay(Characters character, boolean isWarrior) {
        Game game = new Game();
        game.play(character,isWarrior);
    }
}
