package dungeon;

import dungeon.menus.Menu;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

/**
 * Method Main for setup the program
 */
public class Main {

    /**
     * method main for invoke a new Menu and call menuPrincipal method of this class
     * @param args String[]
     */
    public static void main(String[] args) {
        Menu mainMenu = new Menu();
        mainMenu.menuPrincipal();
    }
}
