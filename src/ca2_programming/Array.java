package ca2_programming;

import java.util.HashSet;
import java.util.Scanner;

public class Array {
        
    public static void PrintArray(int[] a) {
        // Iterate over array with a for loop and add all the elements to a string then print
        String s = "";
        for (int i = 0; i < a.length; ++i)
            s += a[i] + ", ";

        System.out.printf("%s\n", s);
    }
  
    // Task 5
    public static int[] BubbleSort(int[] a, int n) {
        //https://en.wikipedia.org/wiki/Bubble_sort
        int iSwaps = 0;
        
        // Iterate over each index of the array.
        for (int i = 0; i < n-1; ++i) {
            boolean bSwapped = false;
            
            // For each value walk the array and compare the proceeding value. 
            for (int j = 0; j < n-1; ++j) {
                if (a[j] > a[j+1]) {
                    int t=a[j];     // Store temporary value.
                    a[j] = a[j+1];  // Swap value.
                    a[j+1] = t;     // Swap value.
                    bSwapped = true;// Set swapped to true.
                    ++iSwaps;
                }
            }
            if (!bSwapped) break; // If no swaps were done this iteration then array is sorted.
        }
        System.out.printf("Total swaps: %d\n", iSwaps);
        
        return a;
    }
  
    // Task 5
    public static int[] GetArrayFromInput(Scanner scanner, int n) throws Exception {
        // Dynamically create array of size n
        int aArr[] = new int[n];

        System.out.printf("Enter array (%d): \n", n);

        String strInput = scanner.nextLine();
        String[] aStrSplit = strInput.split(" ");

        // Check if values are integers and if they match the array dimensions.
        if (!Utils.IsInteger(aStrSplit) || aStrSplit.length != n)
            throw new Exception("Invalid array input.");

        // Add value to the respective array index.
        for (int i = 0; i < n; ++i)
            aArr[i] = Integer.parseInt(aStrSplit[i]);

        return aArr;
    }

        // Task 1
    public static String FirstRepeatElement(int a[], int s) {
        // Stores each index of the array into the hashset then checks if the current index already exists. (More optimized than nested for loops).
        HashSet<Integer> hashSet = new HashSet<>();
        
        // Iterate over all array values then check if they exist in the hash set. If they dont add them and repeat.
        for (int i = 0; i < s; ++i) {
            if (hashSet.contains(a[i])) {
                return Integer.toString(a[i]);
            } else {
                hashSet.add(a[i]);
            }
        }
        return "No repeated elements found.";
    }
}
