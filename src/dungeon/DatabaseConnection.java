package dungeon;

import dungeon.characters.Characters;
import dungeon.characters.Mage.Mage;
import dungeon.characters.warrior.Warrior;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Class Db
 */
public class DatabaseConnection {
    /**
     * Attribute connect typeof Connection
     */
    private static Connection connect = null;
    /**
     * Attribute preparedStatement typeof PreparedStatement
     */
    private PreparedStatement preparedStatement = null;

    static  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(Config.getUrl(),Config.getUserName(),Config.getPassword());

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Method getConn for trying to connect the app at the db
     */
    public static Connection getInstance() {
        return connect;
    }

    /**
     * Method getWarrior for get all characters with type Warrior in the characters table at the db
     * @return Arraylist<Warrior>
     */
    public ArrayList<Warrior> getWarriors(){
        ArrayList<Warrior> warrior = new ArrayList<>();
        try
        {
            connect = getInstance();
            Statement stmt = connect.createStatement();
            String sql = ("SELECT * FROM characters WHERE Type = 'Warrior'");
            ResultSet w = stmt.executeQuery(sql);

            while(w.next()){
                int id = w.getInt("id");
                String name = w.getString("name");
                int life = w.getInt("pointLife");
                int attack = w.getInt("pointAttack");

                Warrior warriorRes = new Warrior(id,name,life,attack);
                warrior.add(warriorRes);
            }
            connect.close();
        } catch(SQLException e) {
            System.out.println(e.getStackTrace());
        }
        return warrior;
    }

    /**
     * Method getWizard for get all characters with type Mage in the characters table at the db
     * @return Arraylist<Mage>
     */
    public ArrayList<Mage> getWizards(){
        ArrayList<Mage> wizard = new ArrayList<>();
        try
        {
            connect = getInstance();
            Statement stmt = connect.createStatement();
            String sql = ("SELECT * FROM characters WHERE Type = 'Mage'");
            ResultSet w = stmt.executeQuery(sql);

            while(w.next()){
                int id = w.getInt("id");
                String name = w.getString("name");
                int life = w.getInt("pointLife");
                int attack = w.getInt("pointAttack");

                Mage wizardRes = new Mage(id,name,life,attack);
                wizard.add(wizardRes);
            }

            connect.close();
        }
        catch(SQLException e){
            System.out.println(e.getStackTrace());
        }
        return wizard;
    }

    /**
     * Method addCharacter for add a character (Warrior or Mage) in the characters table at the db
     * @param character Character
     * @param isWarrior boolean
     */
    public void addCharacter(Characters character, boolean isWarrior) {
        try
        {
            connect = getInstance();
            System.out.println("Add in progress...");

            this.preparedStatement = connect.prepareStatement("INSERT INTO characters(name,pointLife,pointAttack,type)"+"VALUES(?,?,?,?)");
            this.preparedStatement.setString(1, character.getName());
            this.preparedStatement.setInt(2, character.getPointLife());
            this.preparedStatement.setInt(3, character.getPointAttack());
            this.preparedStatement.setString(4, isWarrior?"Warrior":"Mage");
            this.preparedStatement.executeUpdate();

            System.out.println("This "+ (isWarrior ? "warrior" : "wizard") + " has been created.");
            connect.close();
        } catch(SQLException e){
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Method deleteCharacter for delete an element in characters table at the db with his id
     * @param id int
     */
    public void deleteCharacter(int id){
        try {
            connect = getInstance();
            System.out.println("Delete in progress...");

            this.preparedStatement = connect.prepareStatement("DELETE from characters "+"WHERE id = ?;");
            this.preparedStatement.setInt(1, id);
            this.preparedStatement.executeUpdate();
            System.out.println("This character has been deleted.");
            connect.close();
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Method updateCharacter for update an element in characters table at the db
     * Passed in parameters of this method the character what you want to update and the boolean for know what value to set in type column
     * @param character Characters
     * @param isWarrior boolean
     */
    public void updateCharacter(Characters character, boolean isWarrior){
        try {
            connect = getInstance();
            System.out.println("Update in progress...");

            this.preparedStatement = connect.prepareStatement("UPDATE characters "+"SET name = ?, pointLife = ?, pointAttack = ?, type = ? WHERE id = ?;");
            this.preparedStatement.setString(1, character.getName());
            this.preparedStatement.setInt(2, character.getPointLife());
            this.preparedStatement.setInt(3, character.getPointAttack());
            this.preparedStatement.setString(4, isWarrior? "Warrior":"Mage");
            this.preparedStatement.setInt(5, character.getId());
            this.preparedStatement.executeUpdate();

            System.out.println("This character has been updated.");
            connect.close();
        } catch (SQLException e){
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Method getCharacter for return a character with his id from the table characters at the db
     * @param id Integer
     * @return Characters
     */
    public Characters getCharacter(int id) {
        Characters mySelect = null;
        try {
            connect = getInstance();
            this.preparedStatement = connect.prepareStatement("SELECT * from characters "+"WHERE id = ?;");
            this.preparedStatement.setInt(1, id);
            ResultSet rs = this.preparedStatement.executeQuery();

            while(rs.next()) {
                if (Objects.equals(rs.getString("type"), "Warrior")){
                    mySelect = new Warrior(rs.getInt("id"),rs.getString("name"),rs.getInt("pointLife"),rs.getInt("pointAttack"));
                }
                if (Objects.equals(rs.getString("type"), "Mage")){
                    mySelect = new Mage(rs.getInt("id"),rs.getString("name"),rs.getInt("pointLife"),rs.getInt("pointAttack"));
                }
            }

            connect.close();
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }
        return mySelect;
    }
}
