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
    private String getResult(String question) {
        System.out.println(question);
        return scanner.next();
    }
    public  int getIntResult(String question) {
        try {
            return Integer.parseInt(getResult(question));
        } catch (NumberFormatException e) {
            return getIntResult(question);
        }
    }

    public Warrior createWarrior(){
        return new Warrior();
    }
    public Mage createWizard(){
        return new Mage();
    }

    private  String getStringResult(String question){
        String a = getResult(question);
        try{
            Integer.parseInt(a);
        }catch (NumberFormatException e){
            return a;
        }
        return getStringResult(question);
    }

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

    private void warriorSelect() {
        System.out.println("Warrior selected");
        Warrior warrior = createWarrior();
        infosOfCharacter(warrior,true);
    }

    private void wizardSelect() {
        System.out.println("Wizard selected");
        Mage mage = createWizard();
        infosOfCharacter(mage,false);
    }

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

    private void setInfosOfCharacter(Characters character, boolean isWarrior) {
        setParameters(character,isWarrior);
    }

    private void setParameters(Characters character, boolean isWarrior) {
        setNameCharacter(character);
        setPointOfLifeCharacter(character, isWarrior);
        setPointOfAttackCharacter(character,isWarrior);
        readyToPlay(character,isWarrior);
    }

    private void setNameCharacter(Characters character) {
        String nameCharacter = getStringResult("Enter name for your character");

        if (!nameCharacter.isEmpty()) {
            character.setName(nameCharacter);
        } else {
            nameCharacter = getStringResult("Thanks to write a valid name");
        }
    }

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

    private void readyToPlay(Characters character, boolean isWarrior) {
        Game game = new Game();
        game.play(character,isWarrior);
    }
}
