
/*
 * Circular Network Swap
 *
 * A circular network has n components represented as a string named components. 
 * Each component is either a Compute ('C') unit or a Network ('N') unit. 
 * The components are arranged in a circle, meaning the first component is adjacent to the last component.
 *
 * Determine the minimum number of swaps needed to group all the Compute units together, and all the Network units together.
 *
 *
 * Test Case
 *
 * components = "CNCN"
 *
 * There are several possible solutions:
 * 
 * Swap indexes 1 and 2 to get CCNN
 * Swap indexes 0 and 3 to get NNCC
 * Swap indexes 0 and 1 to get NCCN
 * Swap indexes 2 and 3 to get CNNC
 *
 * The minimum number of moves is 1.
 *
 * Time Complexity: O(n)
 *
*/

using System;

class Solution
{
    public static int getMinimumMoves(string components)
    {
        int n = components.Length;
        int totalC = 0;

        foreach (char c in components)
            if (c == 'C') totalC++;

        if (totalC == 0 || totalC == n)
            return 0;

        // Extend the string to handle circular nature
        string extended = components + components;

        int currentC = 0;
        for (int i = 0; i < totalC; i++)
            if (extended[i] == 'C') currentC++;

        int maxC = currentC;

        for (int i = 1; i < n; i++)
        {
            if (extended[i - 1] == 'C') currentC--;
            if (extended[i + totalC - 1] == 'C') currentC++;
            maxC = Math.Max(maxC, currentC);
        }

        return totalC - maxC;
    }

    // Test method
    static void Main()
    {
        Console.WriteLine(getMinimumMoves("CNCN")); // Output: 1
        Console.WriteLine(getMinimumMoves("NNN"));  // Output: 0
        Console.WriteLine(getMinimumMoves("NCCNNC")); // Additional test
    }
}

