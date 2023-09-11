package dungeon;

import dungeon.menus.Menu;

public class Main {
    public static void main(String[] args)  {
        Menu mainMenu = new Menu();
        // appelez ici la methode selon le choix de l'utilisateur (creer perso // quitter)
        mainMenu.menuPrincipal();
    }
}
