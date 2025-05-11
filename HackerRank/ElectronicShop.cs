
/*
 * Electronics Shop
 *
 * A person wants to determine the most expensive computer keyboard and USB drive that can be purchased with a given budget. 
 * Given price lists for keyboards and USB drives and a budget,
 * find the cost to buy them. If it is not possible to buy both items, return -1.
 *
 *
 * Test Case
 * 
 * b = 60  
 * keyboards = [40, 50, 60]  
 * drives = [5, 8, 12]
 *
 * The person can buy a 40 keyboard + 12 USB drive = 52, or a 50 keyboard + 8 USB drive = 58.
 * Choose the latter as the more expensive option and return 58.
 *
 *
 * Time Complexity: O(n log n + m log m + n + m)
 * Space Complexity: O(1)
 *
*/


using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

class Solution {

    /*
     * Complete the getMoneySpent function below.
     */
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int maxSpent = -1;
        
        Array.Sort(keyboards);
        Array.Sort(drives);
        
        int i = 0, j = drives.Length-1;
        
        while (i < keyboards.Length && j > -1)
        {
            int sum = keyboards[i] + drives[j];
            
            if (sum <= b)
            {
                maxSpent = Math.Max(maxSpent, sum);
                i++;
            }
            else 
            {
                j--;
            }
        }
        
        return maxSpent;
    }

    static void Main(string[] args) {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        string[] bnm = Console.ReadLine().Split(' ');

        int b = Convert.ToInt32(bnm[0]);

        int n = Convert.ToInt32(bnm[1]);

        int m = Convert.ToInt32(bnm[2]);

        int[] keyboards = Array.ConvertAll(Console.ReadLine().Split(' '), keyboardsTemp => Convert.ToInt32(keyboardsTemp))
        ;

        int[] drives = Array.ConvertAll(Console.ReadLine().Split(' '), drivesTemp => Convert.ToInt32(drivesTemp))
        ;
        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */

        int moneySpent = getMoneySpent(keyboards, drives, b);

        textWriter.WriteLine(moneySpent);

        textWriter.Flush();
        textWriter.Close();
    }
}

