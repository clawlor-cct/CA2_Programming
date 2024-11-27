package ca2_programming;

public class Utils {
    // Utility Funcs
    public static boolean IsInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean IsInteger(String[] aStr) {
        try {
            for (int i = 0; i < aStr.length; i++)
                Integer.parseInt(aStr[i]);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }  
}
