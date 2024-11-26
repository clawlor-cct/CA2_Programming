package ca2_programming;
import java.util.HashSet;
import java.util.Scanner;


public class CA2_Programming {

    // Task 2
    public static String GenMultTable(int s) {
        // Create multidemensional array of sxs
        int[][] aTable = new int[s][s];

        // Iterate over each value with a nested for loop and multiply both indices + 1 (So we arn't multiplying by 0)
        for (int i = 0; i < s; ++i) {
            for (int j = 0; j < s; ++j) {
                aTable[i][j] = (i+1) * (j+1);
            }
        }

        String strTable = "Multiplication Table:\n";
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                strTable += "\t" + aTable[i][j];
            }
            strTable += "\n";
        }
        return strTable;
    }
    
    // Task 1
    public static String FirstRepeatElement(int a[], int s) {
        // Stores each index of the array into the hashset then checks if the current index already exists. (More optimized than nested for loops).
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < s; ++i)
            if (hashSet.contains(a[i])) return Integer.toString(a[i]);
            else hashSet.add(a[i]);     
        return "No repeated elements found.";
    }
    
    public static void main(String[] args) {
        int iArr[] = {4, 5, 6, 7, 4, 8, 7, 4, 8, 4, 9};
        
        System.out.println(FirstRepeatElement(iArr, iArr.length));
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of multiplication table: ");
        System.out.print(GenMultTable(scanner.nextInt()));
        
        
        scanner.close();
    }

}
