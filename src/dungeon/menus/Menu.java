package dungeon.menus;

import dungeon.DatabaseConnection;
import dungeon.ManipCollection;
import dungeon.characters.Characters;
import dungeon.characters.Mage.Mage;
import dungeon.characters.warrior.Warrior;
import dungeon.game.CharacterDeadException;
import dungeon.game.Game;
import dungeon.game.OutOfBoardException;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    /**
     * attribute scanner typeof Scanner
     */
    private final Scanner scanner = new Scanner(System.in);

    private final ArrayList<String> collection = new ArrayList<>();

    /**
     * attribute db typeof Db
     */
    private final DatabaseConnection db;

    /**
     * Constructor method without parameters and initialize array attribute
     */
    public Menu() {
        new ManipCollection(collection);
        this.db = new DatabaseConnection();
    }

    /**
     * Get next result of prompt for switch options
     * @param question string
     * @return scanner.next()
     */
    private String getResult(String question) {
        System.out.println(question);
        return scanner.next();
    }

    /**
     * Get int for prompt in switch menu options
     * @param question string
     * @return scanner.next()
     */
    public int getIntResult(String question) {
        try {
            return Integer.parseInt(getResult(question));
        } catch (NumberFormatException e) {
            return getIntResult(question);
        }
    }

    /**
     * Invoke a new Warrior
     * @return Warrior
     */
    public Warrior createWarrior(){
        return new Warrior();
    }

    /**
     * Invoke a new Mage
     * @return Mage
     */
    public Mage createWizard(){
        return new Mage();
    }

    /**
     * This param is a string who contains a question and both options for switch in a menu
     * ex : "Principal menu : \n1 for create character\n2 for show all list of characters\n3 for left the game"
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
     * Create character / Show list of characters / exit program
     */
    public void menuPrincipal() {
        int create = getIntResult("Principal menu : \n1 for fast party\n2 for create character\n3 for show all list of characters\n4 for left the game\n5 for test manip collection");
        switch (create) {
            case 1 -> {
                Warrior warrior = new Warrior();
                readyToPlay(warrior,true);
            }
            case 2 -> createCharacter();
            case 3 -> showAllLists();
            case 4 -> {
                System.out.println("Left the game");
                System.exit(0);
            }
            case 5 -> showForManipList();
        }
    }

    /**
     * Create menu with 4 options
     * create warrior / create wizard / back to main menu / left the game
     */
    public void createCharacter() {
        int create = getIntResult("Select type character : \n1 for Warrior\n2 for Wizard\n3 for back to main menu\n4 for left the game");
        switch (create) {
            case 1 ->
                    warriorSelect();
            case 2 ->
                    wizardSelect();
            case 3 ->
                    menuPrincipal();
            case 4 -> {
                System.out.println("Left the game");
                System.exit(0);
            }
        }
    }

    /**
     * Select character warrior
     * Call createWarrior method and return a new Warrior
     * Add Warrior created previously in warriorList collection
     * Call infosOfCharacter
     */
    private void warriorSelect() {
        System.out.println("Warrior selected");
        Warrior warrior = createWarrior();
        setInfosOfCharacter(warrior,true);
    }

    /**
     * Select character mage
     * Call createWizard method and return a new Mage
     * Add Mage created previously in wizardsList collection
     * Call infosOfCharacter
     */
    private void wizardSelect() {
        System.out.println("Wizard selected");
        Mage mage = createWizard();
        setInfosOfCharacter(mage,false);
    }

//    /**
//     * Change infos of the character previously created or play game directly
//     * Back to the principal menu
//     * Exit program
//     * @param character Characters
//     * @param isWarrior boolean
//     */
//    private void infosOfCharacter(Characters character, boolean isWarrior) {
//        int setInfo = getIntResult("Custom your " + (isWarrior ? "warrior" : "wizard") + " \n1 for Yes\n2 for back to main menu\n3 for left the game");
//        switch (setInfo) {
//            case 1 ->
//                    setInfosOfCharacter(character,isWarrior);
//            case 2 ->
//                    menuPrincipal();
//            case 3 -> {
//                System.out.println("Left the game");
//                System.exit(0);
//            }
//        }
//    }

    /**
     * Call setParameters method
     * @param character Characters
     * @param isWarrior boolean
     */
    private void setInfosOfCharacter(Characters character, boolean isWarrior) {
        setParameters(character,isWarrior);
    }

    /**
     * Call different method to set attributes of character
     * Last method called : readyToPlay
     * @param character Characters
     * @param isWarrior boolean
     */
    private void setParameters(Characters character, boolean isWarrior) {
        setNameCharacter(character);
        setPointOfLifeCharacter(character, isWarrior);
        setPointOfAttackCharacter(character,isWarrior);
        this.db.addCharacter(character, isWarrior);
        readyToPlay(character,isWarrior);
    }

    /**
     * Set a name for current character
     * @param character Character
     */
    private void setNameCharacter(Characters character) {
        String nameCharacter = getStringResult("Enter name for your character");

        if (!nameCharacter.isEmpty()) {
            character.setName(nameCharacter);
        } else {
            System.out.println("Thanks to write a valid name");
            setNameCharacter(character);
        }
    }

    /**
     * Set point of life for current character
     * @param character Characters
     * @param isWarrior boolean
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
     * Set points of strength for current character
     * @param character Characters
     * @param isWarrior boolean
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
     * Invoke a new object Game
     * Call play method with the current character and boolean
     * @param character Characters
     * @param isWarrior boolean
     */
    private void readyToPlay(Characters character, boolean isWarrior) {
        int playGame = getIntResult("""
                You are ready to play ? \s
                1 for Yes
                2 for look list of characters
                3 for back to main menu
                4 for left the game""");
        switch (playGame) {
            case 1 -> {
                Game game = new Game();
                 try {
                     game.play(character,isWarrior);
                 } catch (CharacterDeadException | OutOfBoardException e) {
                     System.out.println(e.getMessage());
                     menuPrincipal();
                 }
            }
            case 2 ->
                    showAllLists();
            case 3 ->
                    menuPrincipal();
            case 4 -> {
                System.out.println("Left the game");
                System.exit(0);
            }
            default -> throw new IllegalStateException("Unexpected value: " + playGame);
        }
    }

    /**
     * Method for return selected warrior by user
     * @return Characters typeof Warrior
     */
    private Characters warriorSelected() {
        Characters mySelect;
        System.out.println("Select a warrior :\n");
        ArrayList<Warrior> warriorsList = this.db.getWarriors();

        for (Warrior warrior : warriorsList) {
            System.out.println(warrior + "\n");
        }

        System.out.println("Enter a number");
        int selectWarrior = scanner.nextInt();
        mySelect = this.db.getCharacter(selectWarrior);
        System.out.println("Your selection : " + mySelect);
        return mySelect;
    }

    /**
     * Method for return selected wizard by user
     * @return Characters typeof Mage
     */
    private Characters wizardSelected() {
        Characters mySelect;
        System.out.println("Select a wizard ?");
        ArrayList<Mage> wizardsList = this.db.getWizards();

        for (Mage wizard : wizardsList) {
            System.out.println(wizard + "\n");
        }

        System.out.println("Enter a number");
        int selectWizard = scanner.nextInt();
        mySelect = this.db.getCharacter(selectWizard);
        System.out.println("Your selection : " + mySelect);
        return mySelect;
    }

    /**
     * Show lists of characters / Select a character in a list if is not empty or back to the main menu
     * If list is not empty : User can choose for a warrior / a mage / back to creation menu / back to main menu or left the game
     */
    public void showAllLists() {
        ArrayList<Warrior> warriorsList = this.db.getWarriors();
        ArrayList<Mage> wizardsList = this.db.getWizards();

        if (!warriorsList.isEmpty()) {
            System.out.println("All warriors : \n");
            for (Warrior warrior : warriorsList) {
                System.out.println(warrior + "\n");
            }
        }
        if (!wizardsList.isEmpty()) {
            System.out.println("All wizards : \n");
            for (Mage wizard : wizardsList) {
                System.out.println(wizard + "\n");
            }
        }

        if (!warriorsList.isEmpty() || !wizardsList.isEmpty()) {
            Characters mySelect;
            int selection = getIntResult("""
                    You want to select a character in lists ?\s
                    1 for select a warrior\s
                    2 for select a wizard
                    3 for delete a character\s
                    4 for update a character\s
                    5 for back to the creation menu\s
                    6 for back to main menu
                    7 for left the program""");
            switch (selection){
                case 1 -> {
                    mySelect = warriorSelected();
                    readyToPlay(mySelect,true);
                }
                case 2 -> {
                    mySelect = wizardSelected();
                    readyToPlay(mySelect,false);
                }
                case 3 -> deleteCharacter();
                case 4 -> updateCharacter();
                case 5 -> createCharacter();
                case 6 -> menuPrincipal();
                case 7 -> {
                    System.out.println("Left the game");
                    System.exit(0);
                }
            }
        } else {
            System.out.println("No characters, you will be redirected to the main menu.");
            menuPrincipal();
        }
    }

    /**
     * Method for list an ArrayList and ask to the user for manipulate or not this list
     */
    private void showForManipList(){
        for (int i = 0; i < this.collection.size(); i++){
            System.out.println("Element : " + i + " : " + this.collection.get(i) + "\n");
        }

        int question = getIntResult("""
                You want to manipulate this list ? \s
                1 for research
                2 for delete
                3 for back to main menu""");
        switch (question) {
            case 1 -> research(collection);
            case 2 -> delete(collection);
            case 3 -> menuPrincipal();
        }
    }

    /**
     * Method for research all result when the user type a letter
     * @param list ArrayList
     */
    private void research(ArrayList<String> list){
        String data = getStringResult("Type letter for research an element the list and press enter.");
        System.out.println(data);

        List<String> researchTest = list.stream().filter(e -> e.contains(data)).toList();

        System.out.println("Result of your research");
        for (int i = 0; i < researchTest.size(); i++){
            System.out.println("Element : " + i + " : " + researchTest.get(i) + ", ");
        }

        int question = getIntResult("""
                What do you want to do ? \s
                1 for delete
                2 for back to main menu
                3 for left the game""");
        switch (question) {
            case 1 -> delete(collection);
            case 2 -> menuPrincipal();
            case 3 ->  {
                System.out.println("Left the game");
                System.exit(0);
            }
        }
    }

    /**
     * Method for delete a specific index at in ArrayList
     * @param list1 ArrayList
     */
    private void delete(ArrayList<String> list1){
        int idDelete = getIntResult("Enter an index of the list to remove element.");

        for (int i = 0; i < list1.size(); i++){
            if (idDelete == i){
                list1.remove(i);
            }
        }
        System.out.println("The list after delete.");
        System.out.println(list1);

        int question = getIntResult("""
                Return to the main menu ? \s
                1 for yes
                2 for quit""");
        switch (question){
            case 1 -> menuPrincipal();
            case 2 ->  {
                System.out.println("Left the game");
                System.exit(0);
            }
        }
    }

    /**
     * Menu for select a type of character what you want to delete
     */
    private void deleteCharacter(){
        int selection = getIntResult("""
                Select type of character what you want to delete\s
                1 for warrior\s
                2 for wizard\s
                3 for back to the main menu
                4 for left the game""");
        switch (selection){
            case 1 -> deleteWarrior();
            case 2 -> deleteWizard();
            case 3 -> menuPrincipal();
            case 4 -> {
                System.out.println("Left the game");
                System.exit(0);
            }
        }
    }

    /**
     * Method for delete a specific warrior with ihs id
     */
    private void deleteWarrior() {
        ArrayList<Warrior> warriorsList = this.db.getWarriors();
        System.out.println("Select a warrior :\n");

        if (!warriorsList.isEmpty()) {
            System.out.println("All warriors : \n");
            for (Warrior warrior : warriorsList) {
                System.out.println(warrior + "\n");
            }
        }

        System.out.println("Enter id what you want to delete");
        int selectWarrior = scanner.nextInt();
        this.db.deleteCharacter(selectWarrior);
    }

    /**
     * Method for delete a specific wizard with ihs id
     */
    private void deleteWizard() {
        System.out.println("Select a wizard :\n");
        ArrayList<Mage> wizardsList = this.db.getWizards();

        if (!wizardsList.isEmpty()) {
            System.out.println("All wizards : \n");
            for (Mage wizard : wizardsList) {
                System.out.println(wizard + "\n");
            }
        }

        System.out.println("Enter id what you want to delete");
        int selectWizard = scanner.nextInt();
        this.db.deleteCharacter(selectWizard);
    }

    /**
     * Menu for select a type of character what you want to update
     */
    private void updateCharacter() {
        int create = getIntResult("Select type character : \n1 for Warrior\n2 for Wizard\n3 for back to main menu\n4 for left the game");
        Characters mySelect;
        switch (create) {
            case 1 -> {
                mySelect = warriorSelected();
                updateSelected(mySelect, true);
            }
            case 2 -> {
                mySelect = wizardSelected();
                updateSelected(mySelect, false);
            }
            case 3 -> menuPrincipal();
            case 4 -> {
                System.out.println("Left the game");
                System.exit(0);
            }
        }
    }

    /**
     * Menu for update all fields or a specific field of character what you want to update
     */
    private void updateSelected(Characters selected, boolean isWarrior) {
        int selection = getIntResult("What you want to update ? : \n1 for all values\n2 for name\n3 for for point of life\n4 for point of attack \n5 for back to main menu\n6 Left the game");
        switch (selection) {
            case 1 -> {
                setNameCharacter(selected);
                setPointOfLifeCharacter(selected, isWarrior);
                setPointOfAttackCharacter(selected, isWarrior);
                this.db.updateCharacter(selected,isWarrior);
                readyToPlay(selected, isWarrior);
            }
            case 2 -> {
                setNameCharacter(selected);
                this.db.updateCharacter(selected,isWarrior);
                readyToPlay(selected, isWarrior);
            }
            case 3 -> {
                setPointOfLifeCharacter(selected, isWarrior);
                this.db.updateCharacter(selected,isWarrior);
                readyToPlay(selected, isWarrior);
            }
            case 4 -> {
                setPointOfAttackCharacter(selected, isWarrior);
                this.db.updateCharacter(selected,isWarrior);
                readyToPlay(selected, isWarrior);
            }
            case 5 -> menuPrincipal();
            case 6 -> {
                System.out.println("Left the game");
                System.exit(0);
            }
        }
    }
}
