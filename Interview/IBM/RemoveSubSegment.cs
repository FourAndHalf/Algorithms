
/*
 * Remove Subsegment for Unique Elements
 *
 * Given an array arr of size n, the goal is to remove at most one subsegment (a consecutive sequence of elements) 
 * so that all remaining elements are pairwise distinct, i.e., there are no duplicates.
 *
 * Implement a function that determines the minimum size of at most one contiguous subsegment that can be removed in order to meet the required condition.
 *
 *
 * Test Case
 *
 * n = 4  
 * arr = [3, 3, 3, 5]
 *
 * Here, the subsegment to be removed is given in 1-based indexing. Some possible deletions are:
 *
 * Subsegment to be deleted	    arr before	    arr after	    Condition Met
 * [1, 2]	                    [3, 3, 3, 5]	[3, 5]	        Yes
 * [3, 4]	                    [3, 3, 3, 5]	[3, 3]	        No
 * [4, 4]	                    [3, 3, 3, 5]	[3, 3, 3]	    No
 *
 * Minimum size of the subsegment that satisfies the condition is 2.
 *
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n) [For HashSet]
 *
 * 💡 Strategy:
 * Use a two-pointer sliding window to find the longest prefix and suffix that can combine (with some subsegment removed in the middle) to form a unique set.
 * Track all duplicates and try removing a subarray such that the combination of the prefix and suffix (i.e., everything outside the subsegment) contains no duplicates.
 *
*/

using System;
using System.Collections.Generic;

class Solution
{
    public static int getMinimumLength(int[] arr)
    {
        int n = arr.Length;
        int answer = n;
        Dictionary<int, int> count = new Dictionary<int, int>();

        int right = n;
        HashSet<int> seen = new HashSet<int>();

        // Build suffix first (elements from end that are unique)
        for (int i = n - 1; i >= 0; i--)
        {
            if (seen.Contains(arr[i])) break;
            seen.Add(arr[i]);
            right = i;
        }

        answer = right; // Case when we remove from index 0 to right-1

        seen.Clear();

        for (int left = 0; left < n; left++)
        {
            if (seen.Contains(arr[left])) break;
            seen.Add(arr[left]);

            // Move right pointer to ensure uniqueness with left side
            while (right < n && seen.Contains(arr[right]))
            {
                right++;
            }

            answer = Math.Min(answer, right - left - 1);
        }

        return answer;
    }

    // Test
    static void Main()
    {
        int[] arr = {3, 3, 3, 5};
        Console.WriteLine(getMinimumLength(arr)); // Output: 2

        int[] arr2 = {1, 2, 3, 2, 1};
        Console.WriteLine(getMinimumLength(arr2)); // Output: 1

        int[] arr3 = {1, 2, 3, 4, 5};
        Console.WriteLine(getMinimumLength(arr3)); // Output: 0
    }
}


/* 
 * Brute Force 
 *
 * Time Complexity: O(n^2)
 *
*/

using System;
using System.Collections.Generic;

class Solution
{
    public static int getMinimumLength(int[] arr)
    {
        int n = arr.Length;
        int answer = n;

        // Try all starting points of the suffix
        for (int i = 0; i <= n; i++)
        {
            HashSet<int> suffixSet = new HashSet<int>();
            bool validSuffix = true;

            // Check suffix starting from i to end
            for (int j = i; j < n; j++)
            {
                if (suffixSet.Contains(arr[j]))
                {
                    validSuffix = false;
                    break;
                }
                suffixSet.Add(arr[j]);
            }

            if (!validSuffix) continue;

            HashSet<int> prefixSet = new HashSet<int>();
            int j = 0;

            // Now try to add prefix from left to (i-1)
            while (j < i)
            {
                if (suffixSet.Contains(arr[j]) || prefixSet.Contains(arr[j]))
                    break;

                prefixSet.Add(arr[j]);
                j++;
            }

            // Calculate length of subarray to remove
            int toRemove = i - j;
            answer = Math.Min(answer, toRemove);
        }

        return answer;
    }

    // Test driver
    static void Main()
    {
        int[] arr = {3, 3, 3, 5};
        Console.WriteLine(getMinimumLength(arr));  // Output: 2
    }
}

