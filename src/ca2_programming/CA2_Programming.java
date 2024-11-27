package ca2_programming;

import java.util.HashSet;
import java.util.Scanner;

public class CA2_Programming {
    
    // Vars
    private static Scanner scanner = new Scanner(System.in);
   
    // Helper Funcs
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

    public static void PrintMatrix(int m[][]) {
        // Iterate over matrix with a nested for loop and add all the elements to a string then print
        String str = "";
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++)
                str += "\t" + m[i][j];

            str += "\n";
        }      
        System.out.printf("%s\n", str);
    }

    // Task 4
    public static int[] SpiralOrderMatrix(int m[][], int r, int c) {  
        int iOrderIndex = 0;
        int aMatrixOrdered[] = new int[r*c];
        
        // Run as long as top/bottom & left/right dont go past each other.
        int iTop = 0, iLeft = 0, iBottom = r-1, iRight = c-1;
        while (iTop <= iBottom && iLeft <= iRight ) {        
            // Iterate the top row length
            for (int i = iLeft; i <= iRight; ++i)
                aMatrixOrdered[iOrderIndex++] = m[iTop][i]; // Traverse at top index the length of left to right.
            iTop++;
            
            //Iterate the right column length
            for (int i = iTop; i <= iBottom; ++i)
                aMatrixOrdered[iOrderIndex++] = m[i][iRight]; // Traverse at right index the length of top to bottom.
            iRight--;

            //Iterate the bottom row length
            for (int i = iRight; i >= iLeft; --i)
                aMatrixOrdered[iOrderIndex++] = m[iBottom][i]; // Traverse at bottom index the length of right to left.
            iBottom--;

            //Iterate the left column length
            for (int i = iBottom; i >= iTop; --i)
                aMatrixOrdered[iOrderIndex++] = m[i][iLeft]; // Traverse at left index the length of bottom to top.
            iLeft++;          
        }
        
        return aMatrixOrdered;
    }
    
    // Task 3
    public static int[][] GetMatrixFromInput(int r, int c) throws Exception {
        // Dynamically create multidemensional array of r x c
        int aMatrix[][] = new int[r][c];

        System.out.printf("Enter matrix (%dx%d): \n", r, c);
        for (int i = 0; i < r; ++i) {
            String strInput = scanner.nextLine();
            String[] aStrSplit = strInput.split(" ");
            
            // Check if values are integers and if they match the matrix dimensions.
            if (!IsInteger(aStrSplit) || aStrSplit.length != c)
                throw new Exception("Invalid matrix input.");

            // Add value to the respective matrix index.
            for (int j = 0; j < c; ++j)
                aMatrix[i][j] = Integer.parseInt(aStrSplit[j]);
        }

        return aMatrix;
    }

    // Task 3
    public static int[] DiagSumMatrix(int m[][]) {

        int iSumDiagPri = 0;
        int iSumDiagSec = 0;

        for (int i = 0, j = m.length-1; i < m.length; ++i, --j) {
            iSumDiagPri += m[i][i]; // Primary diagoonal
            iSumDiagSec += m[i][j]; // Secondary diagonal
        }   

        return new int[]{iSumDiagPri, iSumDiagSec};
    }

    // Task 2
    public static int[][] GenMultTable(int n) {
        // Dynamically create multidemensional array of n x n
        int aMatrix[][] = new int[n][n];

        // Iterate over each value with a nested for loop and multiply both indices + 1 (So we arn't multiplying by 0)
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                aMatrix[i][j] = (i + 1) * (j + 1);
            }
        }

        return aMatrix;
    }

    // Task 1
    public static String FirstRepeatElement(int a[], int s) {
        // Stores each index of the array into the hashset then checks if the current index already exists. (More optimized than nested for loops).
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < s; ++i) {
            if (hashSet.contains(a[i])) {
                return Integer.toString(a[i]);
            } else {
                hashSet.add(a[i]);
            }
        }
        return "No repeated elements found.";
    }

    public static void main(String[] args) {

//        ////////////////////////////////////////////////
//        // Task 1
//        int iArr[] = {4, 5, 6, 7, 4, 8, 7, 4, 8, 4, 9};
//        System.out.printf("First repeated element: %s\n", FirstRepeatElement(iArr, iArr.length));
//        ////////////////////////////////////////////////
//        
//        ////////////////////////////////////////////////
//        // Task 2
//        System.out.printf("Enter size of multiplication table: ");
//        String strMulTablSize = scanner.nextLine();
//        if (IsInteger(strMulTablSize))
//            PrintMatrix(GenMultTable(Integer.parseInt(strMulTablSize)));
//        else
//            System.out.printf("Invalid table size.\n");
//        ////////////////////////////////////////////////
//        
        ////////////////////////////////////////////////
        // Task 3
//        try {
//            System.out.printf("Enter matrix size: ");
//            String strMatrixSize = scanner.nextLine();
//            if (IsInteger(strMatrixSize)) {
//                int iSize               = Integer.parseInt(strMatrixSize);
//                int aMatrix[][]         = GetMatrixFromInput(iSize, iSize);
//                int aMatrixDiagSum[]    = DiagSumMatrix(aMatrix);
//                System.out.printf("Pri: %d, Sec: %d\n", aMatrixDiagSum[0], aMatrixDiagSum[1]);
//            }
//            else
//                System.out.printf("Invalid matrix size.\n");
//        }
//        catch (Exception e) {    
//            System.out.printf("ERROR: %s\n", e.toString());
//        }
        ////////////////////////////////////////////////
        
        ////////////////////////////////////////////////
        // Task 4
//        try {
//            System.out.printf("Enter rows and columns of matrix: ");
//            String strMatrixSize = scanner.nextLine();
//            String[] aStrSplit = strMatrixSize.split(" ");
//            if (IsInteger(aStrSplit)) {
//                int iRows               = Integer.parseInt(aStrSplit[0]);
//                int iColumns            = Integer.parseInt(aStrSplit[1]);
//                int aMatrix[][]         = GetMatrixFromInput(iRows, iColumns);
//                int aOrderedMatrix[]    = SpiralOrderMatrix(aMatrix, iRows, iColumns);
//                
//                for (int i = 0; i < aOrderedMatrix.length; i++) {
//                    System.out.printf("%d, ", aOrderedMatrix[i]);
//                }
//            }
//            else
//                System.out.printf("Invalid matrix dimensions.\n");
//        }
//        catch (Exception e) {    
//            System.out.printf("ERROR: %s\n", e.toString());
//        }
        ////////////////////////////////////////////////

        scanner.close();
    }

}
