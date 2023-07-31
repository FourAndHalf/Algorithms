export{};

function threeSum(nums: number[]): number[][] {
    nums.sort((a, b) => (a-b));
    let solution: number[][] = [];

    nums.forEach((value, i): void => {                                                      //! Time Complexity = O(n)
        if(i > 0 && value === nums[i-1]) return;
        let left = i+1;
        let right = nums.length-1;

        while(left < right) {                                                               //! Time Complexity = O(n)
            let sum = value + nums[left] + nums[right];
            if(sum > 0) {
                right--;
            } else if(sum < 0) {
                left++;
            } else {
                solution.push([nums[i], nums[left], nums[right]]);
                left++;
                while(left < right && nums[left] === nums[left-1]) left++;
            }
        }
    });

    return solution;
}                                                                                           //! Total Time Complexity = O(n^2)

let nums: number[] = [-1, 0, 1, 2, -1, -4];

console.log(threeSum(nums));