package dungeon;

import dungeon.menus.Menu;

/**
 * Method Main for setup the program
 */
public class Main {
    /**
     * method main for invoke a new Menu and call menuPrincipal method of this class
     * @param args String[]
     */
    public static void main(String[] args)  {
        Menu mainMenu = new Menu();
        mainMenu.menuPrincipal();
    }
}
