package ca2_programming;

import java.util.Scanner;

public class Matrix {
 
    public static void PrintMatrix(int[][] m) {
        // Iterate over matrix with a nested for loop and add all the elements to a string then print
        String s = "";
        
        // Iterate over all indexes in the multidemensional array and concatenate them
        for (int i = 0; i < m.length; ++i) {
            for (int j = 0; j < m.length; ++j)
                s += "\t" + m[i][j];
            s += "\n";
        }      
        System.out.printf("%s\n", s);
    }
        
    // Task 2
    public static int[][] GenMultTable(int n) {
        // Dynamically create multidemensional array of n x n
        int mMatrix[][] = new int[n][n];

        // Iterate over each value with a nested for loop and multiply both indices + 1 (So we arn't multiplying by 0)
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                mMatrix[i][j] = (i + 1) * (j + 1);
            }
        }

        return mMatrix;
    }
    
    // Task 4
    public static int[] SpiralOrderMatrix(int[][] m, int r, int c) {  
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
    public static int[] DiagSumMatrix(int[][] m) {
        int iPri = 0, iSec = 0;
        
        // Iterate diagonally with i and anti-diagonally with j
        for (int i = 0, j = m.length-1; i < m.length; ++i, --j) {
            iPri += m[i][i]; // Primary diagonal
            iSec += m[i][j]; // Secondary diagonal
        }   
        
        return new int[]{iPri, iSec};
    }
    
    // Task 3
    public static int[][] GetMatrixFromInput(Scanner scanner, int r, int c) throws Exception {
        // Dynamically create multidemensional array of size (r x c)
        int mMatrix[][] = new int[r][c];

        System.out.printf("Enter matrix (%dx%d): \n", r, c);
        for (int i = 0; i < r; ++i) {
            String strInput = scanner.nextLine();
            String[] aStrSplit = strInput.split(" ");
            
            // Check if values are integers and if they match the matrix dimensions.
            if (!Utils.IsInteger(aStrSplit) || aStrSplit.length != c)
                throw new Exception("Invalid matrix input.");

            // Add value to the respective matrix index.
            for (int j = 0; j < c; ++j)
                mMatrix[i][j] = Integer.parseInt(aStrSplit[j]);
        }
        
        return mMatrix;
    }
}
