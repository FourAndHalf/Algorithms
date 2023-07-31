export{};

function fourSum(nums: number[], target: number): number[][] {
    let n = nums.length;
    nums.sort((a, b) => a-b);
    let solution: number[][] = [];

    for(let i=0; i<n-3; i++){                                                   //! Time Complexity = O(n)
        for(let j=i+1; j<n-2; j++){                                             //! Time Complexity = O(n)
            let newTarget = target - nums[i] - nums[j];
            let low = j+1, high = n-1;

            while(low < high) {                                                 //! Time Complexity = O(n)
                if(nums[low] + nums[high] < newTarget) {
                    low++;
                }
                else if(nums[low] + nums[high] > newTarget) {
                    high--;
                } else {
                    solution.push([nums[i], nums[j], nums[low], nums[high]]);
                    let tempIndex1 = low, tempIndex2 = high;
                    while(low < high && nums[low] == nums[tempIndex1]) low++;
                    while(low < high && nums[high] == nums[tempIndex2]) high--;
                }
            }
            while(j+1 < n && nums[j] == nums[j+1]) j++;
        }
        while(i+1 < n && nums[i] == nums[i+1]) i++;
    }
    return solution;
}                                                                               //! Total Time Complexity = O(n)

let nums = [1, 0, -1, 0, -2, 2]; 
let target = 0;

console.log(fourSum(nums, target));