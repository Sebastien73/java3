package dungeon;

public class Config {

    public static String getUrl() {
//        return "jdbc:mysql://localhost:3306/dnd?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
        return "jdbc:mysql://localhost:3306/java_project";
    }

    public static String getUserName() {
        return "seb";
    }

    public static String getPassword() {
        return "sebsebsebpassword";
    }
}
