package dungeon.cases;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Type of case set with enum
 */
public enum CasesType {
    /**
     * List of const in CasesType with value / typeof value -> String
     */
    Big("Big"),
    Little("Little"),
    Empty("Empty"),
    Sword("Sword"),
    Mace("Mace"),
    Shield("Shield"),
    Spell("Spell"),
    Start("Start"),
    Dragon("Dragon"),
    Wizard("Wizard"),
    Gobelin("Gobelin");

    /**
     * Attribute value / type -> String
     * For used String value in method enumContainsValue with one parameter typeof String
     */
    private final String value;

    /**
     * Constructor of CasesType Enum when this enum is imported somewhere in project
     * @param value String
     */
    CasesType(String value) {
        this.value = value;
    }

    /**
     * This method return boolean after as compared value of constant (in this Enum) and a String passed
     * For example :
     * In Ennemy class, for custom message to user for different ennemy case,
     * I used this method for compare value in the enum class and the name of parent class of my current object.
     * If the return is true, I used CasesType.valueof(name of class parent) for display the good value of enum at the user.
     * @param passedValue String
     * @return boolean
     */
    public static boolean enumContainsValue(String passedValue){
        for (CasesType casesType : CasesType.values())
        {
            if (casesType.toString().equals(passedValue))
            {
                return true;
            }
        }

        return false;
    }

    public String toString(){
        return this.value;
    }
}
