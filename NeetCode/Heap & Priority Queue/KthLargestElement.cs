
/*
 * Kth Largest Element In a Stream
 *
 * Design a class to find the kth largest integer in a stream of values, including duplicates.
 * E.g. the 2nd largest from [1, 2, 3, 3] is 3. The stream is not necessarily sorted.
 *
 * Implement the following methods:
 * 
 * constructor(int k, int[] nums) 
 *      Initializes the object given an integer k and the stream of integers nums.
 * int add(int val) 
 *      Adds the integer val to the stream and returns the kth largest integer in the stream.
 *
 *
 * Test Cases:
 *
 * Input:
 *      ["KthLargest", [3, [1, 2, 3, 3]], "add", [3], "add", [5], "add", [6], "add", [7], "add", [8]]
 *
 * Output:
 *      [null, 3, 3, 3, 5, 6]
 *
 * Explanation:
 *      KthLargest kthLargest = new KthLargest(3, [1, 2, 3, 3]);
 *      kthLargest.add(3);   // return 3
 *      kthLargest.add(5);   // return 3
 *      kthLargest.add(6);   // return 3
 *      kthLargest.add(7);   // return 5
 *      kthLargest.add(8);   // return 6
 *
 * 
 * Time Complexity: O(m * log k)  m: No of time add() is called
 *                                k: Rank of largest number to be tracked
 * Space Complexity: O(k)
 *
 *
*/

public class KthLargest {

    private PriorityQueue<int, int> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<int, int>();
        foreach (int num in nums)
        {
            minHeap.Enqueue(num, num);
            if (minHeap.Count > k) 
            {
                minHeap.Dequeue();
            }
        }
    }
    
    public int Add(int val) {
        minHeap.Enqueue(val, val);
        if (minHeap.Count > k)
        {
            minHeap.Dequeue();
        }
        return minHeap.Peek();
    }
}

