/**
 * Student Declaration:
 *
 * Name: Shimon Esterkin
 * ID: 207972258
 * Course Number: 20454
 *
 * In this assignment, I used an AI-based assistant (ChatGPT) strictly for the following purposes:
 * - Code formatting and indentation alignment.
 * - Generating professional Javadoc-style documentation for all methods.
 * - Ensuring visual consistency and clean structure across all elements of the class.
 * - Verifying method organization and aesthetic clarity.
 *
 * No part of the algorithmic logic was copied or inserted without full understanding,
 * and all recursive implementations were developed and verified independently.
 */
public class Ex13_20454 {

    /**
     * Q1 - Counts the number of valid partitions of the array into two disjoint and complementary sets
     * such that the absolute difference between their sums equals the absolute difference between their sizes,
     * and both differences equal the parameter `diff`.
     *
     * Inductive recursive logic:
     * - Base case: once all elements have been tried in all possible combinations (i == arr.length),
     *   check if the current partition is valid. If so, increment the count and print the sets.
     * - Recursive case: at each step, try placing the current element in either group A or group B.
     *   Proceed recursively to test all such combinations.
     *
     * This method uses the following private helper methods:
     * - isValidPartition(int[], int[], int, int[], int): checks whether two groups meet the problem criteria.
     * - sum(int[], int): calculates sum recursively.
     * - areDisjoint(int[], int, int[], int): checks recursively if groups are disjoint.
     * - toString(int[], int, int[], int): formats result string.
     * - hasDuplicates(), hasValue(): recursive checks for duplicates.
     *
     * @param arr  the original array to be partitioned.
     * @param diff the required absolute difference for both sums and sizes.
     * @return the total number of valid disjoint complementary partitions meeting the condition.
     */
    public static int countEqualDiff(int[] arr, int diff) {
        // Case 1: empty array can form two empty groups when diff == 0
        if (arr != null && arr.length == 0 && diff == 0)
            return 1;
    
        // Case 2: single element - valid only if its value equals diff
        if (arr != null && arr.length == 1 && diff == Math.abs(arr[0]))
            return 1;
    
        // Case 3: check for null, duplicates, or invalid size/diff combinations.
        if (arr == null || arr.length <= 1 || hasDuplicates(arr))
            return 0;
    
        // Start recursive search with initial empty groups
        return countEqualDiff(arr, 0, new int[arr.length], 0, new int[arr.length], 0, diff, 0);
    }
    
    /**
     * Recursive helper method that explores all possible disjoint and complementary partitions
     * of the array into two sets A and B, ensuring that both the sum and size difference
     * between the sets equals `diff`. Each valid partition is printed.
     *
     * @param arr   The original input array.
     * @param i     Current index in arr during recursive traversal.
     * @param a     Temporary array holding group A elements.
     * @param sizeA Current logical size of group A.
     * @param b     Temporary array holding group B elements.
     * @param sizeB Current logical size of group B.
     * @param diff  Required difference for both sum and size.
     * @param count Accumulated count of valid partitions.
     * @return Total number of valid partitions found recursively.
     */
    private static int countEqualDiff(int[] arr, int i,
                                      int[] a, int sizeA,
                                      int[] b, int sizeB,
                                      int diff, int count) {
        // Base case: all elements have been distributed
        if (i == arr.length) {
            // Validate disjointness and the difference condition
            if (isValidPartition(a, b, sizeA, sizeB, diff)) {
                // Print the valid partition and increment count
                System.out.print(toString(a, sizeA, b, sizeB) + "\n");
                return count + 1;
            }
            // Not valid — return count as-is
            return count;
        }

        // Option 1: Add current element to group A
        a[sizeA] = arr[i];
        count = countEqualDiff(arr, i + 1, a, sizeA + 1, b, sizeB, diff, count);

        // Option 2: Add current element to group B
        b[sizeB] = arr[i];
        count = countEqualDiff(arr, i + 1, a, sizeA, b, sizeB + 1, diff, count);

        return count;
    }

    /**
     * Verifies whether the difference between the sums and sizes of A and B equals `diff`.
     *
     * @param a     Group A.
     * @param b     Group B.
     * @param sizeA Logical size of group A.
     * @param sizeB Logical size of group B.
     * @param diff  Expected difference for both sum and size.
     * @return True if the condition holds.
     */
    private static boolean isValidPartition(int[] a, int[] b, int sizeA, int sizeB, int diff) {
        // Calculate sums recursively
        int sumA = sum(a, sizeA - 1);
        int sumB = sum(b, sizeB - 1);
        
        // Checks whether both the sum and size differences equal the given diff.
        return Math.abs(sumA - sumB) == diff && Math.abs(sizeA - sizeB) == diff;
    }

    /**
     * Recursively computes the sum of the first i+1 elements in the array.
     *
     * @param arr The array whose elements will be summed.
     * @param i   The last index to include in the sum.
     * @return The sum of elements from index 0 to i.
     */
    private static int sum(int[] arr, int i) {
        // Base case: no elements left to add
        if (i < 0) return 0;

        // Recursive case: add current element to sum of previous elements
        return arr[i] + sum(arr, i - 1);
    }

    /**
     * Recursively checks from index i onwards whether the current element
     * appears again later in the array.
     *
     * @param arr The array being checked.
     * @param i   Current index to check for duplicates.
     * @return True if a duplicate is found, false otherwise.
     */
    private static boolean hasDuplicates(int[] arr) {
        // Start recursive duplicate check from index 0
        return hasDuplicates(arr, 0, arr.length);
    }

    /**
     * A recursive helper that checks whether arr[i] appears again later in the array.
     *
     * @param arr  the array to check.
     * @param i    the current index being examined.
     * @param size the length of the array.
     * @return true if a duplicate of arr[i] is found later in the array, false otherwise.
     */
    private static boolean hasDuplicates(int[] arr, int i, int size) {
        // Base case: finished checking all elements
        if (i >= size - 1) return false;
    
        // Inner recursive check: does arr[i] appear later?
        return hasDuplicates(arr, i + 1, size, arr[i]) || hasDuplicates(arr, i + 1, size);
    }

    /**
     * Recursively checks if target appears in arr starting from index i.
     *
     * @param arr    the array to check.
     * @param i      the current index to start checking from.
     * @param size   the length of the array.
     * @param target the value to search for.
     * @return true if target is found in arr[i..size-1], false otherwise.
     */
    private static boolean hasDuplicates(int[] arr, int i, int size, int target) {
        // Base case: reached end of array
        if (i >= size) return false;
    
        // Found match
        if (arr[i] == target) return true;
    
        // Continue checking
        return hasDuplicates(arr, i + 1, size, target);
    }

    /**
     * Recursively creates a space-separated string of array elements from index 0 to i.
     *
     * @param arr The array whose elements are being printed.
     * @param i   Last index to include in the string.
     * @return A space-separated string of elements.
     */
    private static String toString(int[] arr, int i) {
        // Base case: empty string if no elements to print
        if (i < 0) return "";

        // Concatenate result from previous elements with current element
        return toString(arr, i - 1) + arr[i] + " ";
    }
    
    /**
     * Builds and returns a formatted string showing two disjoint sets,
     * their sums, and their respective sizes. Each group is wrapped in angled brackets.
     *
     * @param a     Array representing group A.
     * @param sizeA Logical size of group A.
     * @param b     Array representing group B.
     * @param sizeB Logical size of group B.
     * @return A formatted string describing both groups.
     */
    private static String toString(int[] a, int sizeA, int[] b, int sizeB) {
        return "{" + toString(a, sizeA - 1) + "} sum = " + sum(a, sizeA - 1) + " count = " + sizeA + "\n" +
               "{" + toString(b, sizeB - 1) + "} sum = " + sum(b, sizeB - 1) + " count = " + sizeB + "\n";
    }

    /**
     * Q2 - Calculates the minimum initial energy required to reach the bottom-right cell
     * of a 2D matrix, moving only right or down, while keeping energy level ≥ 1 at all times.
     *
     * The traveler starts at the top-left corner, and each cell affects the energy level
     * positively or negatively. The goal is to find the least amount of energy required to
     * ensure survival from start to finish.
     *
     * Inductive recursive logic:
     * - Base case: at the destination cell, calculate energy directly based on the cell's value.
     * - Recursive case: at each cell (i, j), explore right and down paths recursively, determine
     *   the minimum required energy from the next step, and adjust based on current cell.
     *
     * Memoization is used to store previously computed results and avoid redundant recursion.
     *
     * @param mat a 2D matrix where each value represents energy gain or loss.
     * @return the minimum initial energy needed to safely reach the goal.
     */ 
    public static int minPoints(int[][] mat) {
        return minPoints(mat, 0, 0, new int[mat.length][mat[0].length]);
    }
    
    /**
     * A recursive helper that calculates the minimum required energy to move from cell (i, j)
     * to the goal (bottom-right), moving only right or down.
     *
     * @param mat   the matrix of energy values.
     * @param i     current row.
     * @param j     current column.
     * @param memo  a memoization matrix for storing subproblem results.
     * @return the minimum energy required starting at cell (i, j).
     */
    private static int minPoints(int[][] mat, int i, int j, int[][] memo) {
        // If out of bounds, return an invalid high cost
        if (i >= mat.length || j >= mat[0].length)
            return Integer.MAX_VALUE;
    
        // If at the destination cell, return energy required to survive here
        if (i == mat.length - 1 && j == mat[0].length)
            return Math.max(1, 1 - mat[i][j]);
    
        // Return cached result if available
        if (memo[i][j] > 0)
            return memo[i][j];
    
        // Recurse: compute minimum energy needed from right and down paths
        int right = minPoints(mat, i, j + 1, memo);
        int down = minPoints(mat, i + 1, j, memo);
        int minNext = Math.min(right, down);
    
        // Compute energy needed at current cell to proceed safely
        int required = minNext - mat[i][j];
    
        // Store and return the result, ensuring energy is at least 1
        memo[i][j] = Math.max(1, required);
        return memo[i][j];
    }
}
