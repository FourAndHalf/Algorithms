public class Solution {
    public int MinEatingSpeed(int[] piles, int h) {
        int lower = 1;
        int upper = piles.Max();

        while (lower < upper) {
            int mid = lower + (upper - lower)/2;

            if (CanEatAll(piles, h, mid)) {
                upper = mid;
            } else {
                lower = mid + 1;
            }
        }

        return lower;
    }

    public bool CanEatAll(int[] piles, int h, int speed) {
        int hoursNeeded = 0;
        foreach (int pile in piles) {
            hoursNeeded += (int)Math.Ceiling((double)pile/speed);
        }

        return hoursNeeded <= h;
    }
}
