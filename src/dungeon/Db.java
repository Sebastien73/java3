package dungeon;

import dungeon.characters.Characters;
import dungeon.characters.Mage.Mage;
import dungeon.characters.warrior.Warrior;

import java.sql.*;
import java.util.ArrayList;

public class Db {
    private Connection connect = null;
    private PreparedStatement preparedStatement = null;
    public void getConn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connect = DriverManager.getConnection(Config.getUrl(),Config.getUserName(),Config.getPassword());

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Warrior> getWarrior(){
        ArrayList<Warrior> warrior = new ArrayList<>();
        try
        {
            getConn();
            Statement stmt = this.connect.createStatement();
            String sql = ("SELECT * FROM characters WHERE Type ='Warrior'");
            ResultSet w = stmt.executeQuery(sql);

            while(w.next()){
                int id = w.getInt("id");
                String name = w.getString("name");
                int life = w.getInt("pointLife");
                int attack = w.getInt("pointAttack");

                Warrior warriorRes = new Warrior(id,name,life,attack);
                warrior.add(warriorRes);
            }
            this.connect.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return warrior;
    }

    public ArrayList<Mage> getWizard(){
        ArrayList<Mage> wizard = new ArrayList<>();
        try
        {
            getConn();
            Statement stmt = this.connect.createStatement();
            String sql = ("SELECT * FROM characters WHERE Type ='Mage'");
            ResultSet w = stmt.executeQuery(sql);

            while(w.next()){
                String name = w.getString("name");
                int life = w.getInt("pointLife");
                int attack = w.getInt("pointAttack");

                Mage wizardRes = new Mage(name,life,attack);
                wizard.add(wizardRes);
            }

            this.connect.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return wizard;
    }

    public void addCharacter(Characters character, boolean isWarrior) {
        try
        {
            getConn();
            System.out.println("In progress...");

            this.preparedStatement = this.connect.prepareStatement("INSERT INTO characters(name,pointLife,pointAttack,type)"+"VALUES(?,?,?,?)");
            this.preparedStatement.setString(1, character.getName());
            this.preparedStatement.setInt(2, character.getPointLife());
            this.preparedStatement.setInt(3, character.getPointAttack());
            this.preparedStatement.setString(4, isWarrior?"Warrior":"Mage");
            this.preparedStatement.executeUpdate();

            System.out.println("This "+ (isWarrior ? "warrior" : "wizard") + " has been created.");
            this.connect.close();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteCharacter(int id){
        try {
            getConn();
            System.out.println("In progress...");

            this.preparedStatement = this.connect.prepareStatement("DELETE from characters "+"WHERE id = ?;");
            this.preparedStatement.setInt(1, id);
            this.preparedStatement.executeUpdate();
            System.out.println("This character has been deleted.");
            this.connect.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCharacter(int id){

    }
}
