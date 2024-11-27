package ca2_programming;

import java.util.Scanner;

public class CA2_Programming {
    
    // Vars
    private static Scanner scanner = new Scanner(System.in);

    // https://github.com/clawlor-cct/CA2_Programming
    public static void main(String[] args) {

        ////////////////////////////////////////////////
        // Task 1
        try {
            System.out.printf("\nEnter array size: ");
            String strArraySize= scanner.nextLine();
            if (Utils.IsInteger(strArraySize)) {
                int iSize               = Integer.parseInt(strArraySize);
                int aArr[]              = Array.GetArrayFromInput(scanner, iSize);
                System.out.printf("First repeated element: %s\n", Array.FirstRepeatElement(aArr, iSize));
            }
            else
                System.out.printf("Invalid array size.\n");
        }
        catch (Exception e) {    
            System.out.printf("ERROR: %s\n", e.toString());
        }
        ////////////////////////////////////////////////
        
        ////////////////////////////////////////////////
        // Task 2
        System.out.printf("\nEnter size of multiplication table: ");
        String strMulTablSize = scanner.nextLine();
        if (Utils.IsInteger(strMulTablSize)) {
            int iSize                   = Integer.parseInt(strMulTablSize);
            int mMultTable[][]          = Matrix.GenMultTable(iSize);
            Matrix.PrintMatrix(mMultTable);
        }
        else
            System.out.printf("Invalid table size.\n");
        ////////////////////////////////////////////////
        
        ////////////////////////////////////////////////
        // Task 3
        try {
            System.out.printf("\nEnter matrix size: ");
            String strMatrixSize = scanner.nextLine();
            if (Utils.IsInteger(strMatrixSize)) {
                int iSize               = Integer.parseInt(strMatrixSize);
                int mMatrix[][]         = Matrix.GetMatrixFromInput(scanner, iSize, iSize);
                int aMatrixDiagSum[]    = Matrix.DiagSumMatrix(mMatrix);
                System.out.printf("Primary Diagonal: %d, Secondary Diagonal: %d\n", aMatrixDiagSum[0], aMatrixDiagSum[1]);
            }
            else
                System.out.printf("Invalid matrix size.\n");
        }
        catch (Exception e) {    
            System.out.printf("ERROR: %s\n", e.toString());
        }
        ////////////////////////////////////////////////
        
        ////////////////////////////////////////////////
        // Task 4
        try {
            System.out.printf("\nEnter rows and columns of matrix: ");
            String strMatrixSize = scanner.nextLine();
            String[] aStrSplit = strMatrixSize.split(" ");
            if (Utils.IsInteger(aStrSplit)) {
                int iRows               = Integer.parseInt(aStrSplit[0]);
                int iColumns            = Integer.parseInt(aStrSplit[1]);
                int mMatrix[][]         = Matrix.GetMatrixFromInput(scanner, iRows, iColumns);
                int aOrderedMatrix[]    = Matrix.SpiralOrderMatrix(mMatrix, iRows, iColumns);
                
                System.out.printf("Spiral Ordered Matrix: ");
                Array.PrintArray(aOrderedMatrix);
            }
            else
                System.out.printf("Invalid matrix dimensions.\n");
        }
        catch (Exception e) {    
            System.out.printf("ERROR: %s\n", e.toString());
        }
        ////////////////////////////////////////////////

        ////////////////////////////////////////////////
        //Task 5
        try {
            System.out.printf("\nEnter size of array: ");
            String strArraySize = scanner.nextLine();
            if (Utils.IsInteger(strArraySize)) {
                int iSize               = Integer.parseInt(strArraySize);
                int aArr[]              = Array.GetArrayFromInput(scanner, iSize);
                int aSortedArray[]      = Array.BubbleSort(aArr, iSize);
                
                System.out.printf("Bubble Sorted Array: ");
                Array.PrintArray(aSortedArray);
            }
            else
                System.out.printf("Invalid array dimensions.\n");
        }
        catch (Exception e) {    
            System.out.printf("ERROR: %s\n", e.toString());
        }
        ////////////////////////////////////////////////
        
        scanner.close();
    }

}
