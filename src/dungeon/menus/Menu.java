package dungeon.menus;

import dungeon.Db;
import dungeon.ManipCollection;
import dungeon.characters.Characters;
import dungeon.characters.Mage.Mage;
import dungeon.characters.warrior.Warrior;
import dungeon.game.CharacterDeadException;
import dungeon.game.Game;
import dungeon.game.OutOfBoardException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {
    /**
     * attribute scanner typeof Scanner
     */
    private final Scanner scanner = new Scanner(System.in);
    /**
     * Attribute warriorsList typeof ArrayList<Collection>
     */
    private final ArrayList<Warrior> warriorsList;
    /**
     * Attribute wizardsList typeof ArrayList<Collection>
     */
    private final ArrayList<Mage> wizardsList;

    private final ArrayList<String> collection = new ArrayList<>();

    private final ManipCollection list;

    private Db db;

    /**
     * Constructor method without parameters and initialize array attribute
     */
    public Menu() {
        this.warriorsList = new ArrayList<>();
        this.wizardsList = new ArrayList<>();
        this.list = new ManipCollection(collection);
        this.db = new Db();
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
        int create = getIntResult("Principal menu : \n1 for create character\n2 for show all list of characters\n3 for left the game");
        switch (create) {
            case 1 -> createCharacter();
            case 2 -> showAllLists(warriorsList, wizardsList);
            case 3 -> {
                System.out.println("Left the game");
                System.exit(0);
            }
            case 4 -> showForManipList();
//            case 5 -> this.db.connect();
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
        this.warriorsList.add(warrior);
        infosOfCharacter(warrior,true);
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
        this.wizardsList.add(mage);
        infosOfCharacter(mage,false);
    }

    /**
     * Change infos of the character previously created or play game directly
     * Back to the principal menu
     * Exit program
     * @param character Characters
     * @param isWarrior boolean
     */
    private void infosOfCharacter(Characters character, boolean isWarrior) {
        int setInfo = getIntResult("Indicate if you want to custom your " + (isWarrior ? "warrior" : "wizard") + " \n1 for Yes\n2 for No\n3 for back to main menu\n4 for left the game");
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
            nameCharacter = getStringResult("Thanks to write a valid name");
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
        int playGame = getIntResult("You are ready to play ? " + " \n1 for Yes\n2 for look list of characters\n3 for back to main menu\n4 for left the game");
        switch (playGame) {
            case 1 -> {
                Game game = new Game();
             try{
                 game.play(character,isWarrior);
             } catch (CharacterDeadException | OutOfBoardException e) {
                 System.out.println(e.getMessage());
                 menuPrincipal();
             }
            }
            case 2 ->
                    showAllLists(this.warriorsList,this.wizardsList);
            case 3 ->
                    menuPrincipal();
            case 4 -> {
                System.out.println("Left the game");
                System.exit(0);
            }
            default -> throw new IllegalStateException("Unexpected value: " + playGame);
        };

    }

    /**
     * Method for return selected warrior by user
     * @return Characters typeof Warrior
     */
    private Characters warriorSelected() {
        Characters mySelect;
        System.out.println("Select a warrior :\n");
        for (int i = 0; i < this.warriorsList.size(); i++) {
            System.out.println("Warrior : " + i + " : " + this.warriorsList.get(i));
        }
        System.out.println("Enter a number");
        int selectWarrior = scanner.nextInt();
        mySelect = this.warriorsList.get(selectWarrior);
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
        for (int i = 0; i < this.wizardsList.size(); i++) {
            System.out.println("Wizard : " + i + " : " + this.wizardsList.get(i));
        }
        System.out.println("Enter a number");
        int selectWizard = scanner.nextInt();
        mySelect = this.wizardsList.get(selectWizard);
        System.out.println("Your selection : " + mySelect);
        return mySelect;
    }

    /**
     * Show lists of characters / Select a character in a list if is not empty or back to the main menu
     * If list is not empty : User can choose for a warrior / a mage / back to creation menu / back to main menu or left the game
     * @param warriorsList Collection
     * @param wizardsList Collection
     */
    public void showAllLists(ArrayList<Warrior> warriorsList, ArrayList<Mage> wizardsList) {
        System.out.println("All warriors : \n" + warriorsList + "\nAll wizards : \n" + wizardsList);
        if (this.warriorsList.size() > 0 || this.wizardsList.size() > 0) {
            Characters mySelect;
            int selection = getIntResult("You want to select a character in lists ? " + "\n1 for select a warrior \n2 for select a wizard \n3 for back to the creation menu \n4 for back to main menu \5for left the program");
            switch (selection){
                case 1 -> {
                    mySelect = warriorSelected();
                    readyToPlay(mySelect,true);
                }
                case 2 -> {
                    mySelect = wizardSelected();
                    readyToPlay(mySelect,false);
                }
                case 3 -> createCharacter();
                case 4 -> menuPrincipal();
                case 5 -> {
                    System.out.println("Left the game");
                    System.exit(0);
                }
            }
        } else {
            System.out.println("No characters, you will be redirected to the main menu.");
            menuPrincipal();
        }
    }

    private void showForManipList(){
        for (int i = 0; i < this.collection.size(); i++){
            System.out.println("Element : " + i + " : " + this.collection.get(i) + "\n");
        }

        int question = getIntResult("You want to manipulate this list ? " + " \n1 for research\n2 for delete\n3 for back to main menu");
        switch (question) {
            case 1 -> research(collection);
            case 2 -> delete(collection);
            case 3 -> menuPrincipal();
        }
    }

    private void research(ArrayList<String> list){
        String data = getStringResult("Type letter for research an element the list and press enter.");
        System.out.println(data);

        List<String> researchTest = list.stream().filter(e -> e.contains(data)).toList();

        System.out.println("Result of your research");
        for (int i = 0; i < researchTest.size(); i++){
            System.out.println("Element : " + i + " : " + researchTest.get(i) + ", ");
        }

        int question = getIntResult("What do you want to do ? " + " \n1 for delete\n2 for back to main menu\n3 for left the game");
        switch (question) {
            case 1 -> delete(collection);
            case 2 -> menuPrincipal();
            case 3 ->  {
                System.out.println("Left the game");
                System.exit(0);
            }
        }
    }

    private void delete(ArrayList<String> list1){
        int idDelete = getIntResult("Enter an index of the list to remove element.");

        for (int i = 0; i < list1.size(); i++){
            if (idDelete == i){
                list1.remove(i);
            }
        }
        System.out.println("The list after delete.");
        System.out.println(list1);

        int question = getIntResult("Return to the main menu ? " + " \n1 for yes\n2 for quit");
        switch (question){
            case 1 -> menuPrincipal();
            case 2 ->  {
                System.out.println("Left the game");
                System.exit(0);
            }
        }
    }

}
