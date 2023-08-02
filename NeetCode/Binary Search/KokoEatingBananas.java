public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = -1;

        for(int i = 0;i < piles.length;i++) {                       //! Time Complexity = O(n)
            if(r < piles[i]) r = piles[i];
        }

        int result = r;
        
        while(l <= r) {                                             //! Time Complexity = O(log (max (n)))
            int k = l + (r - l)/2;
            int hours = 0;

            for(int pile : piles) {                                 //! Time Complexity = O(n)
                hours += Math.ceil((double)pile / k);
            }

            if(hours <= h) {
                result = Math.min(result, k);
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return result;
    }                                                               //! Total Time Complexity = O(nlog (max (n)))
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int hour = 8;

        System.out.println(minEatingSpeed(piles, hour));
    }
}
