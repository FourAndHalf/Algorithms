function subarraySum(nums: number[], k: number): number {
    let count: number = 0;
    let hashmap = new Map<number, number>();
    let currSum: number = 0;

    for(let i = 0;i < nums.length;i++) {
        currSum += nums[i];

        if(currSum === k) {
            count++;
        }

        count += hashmap.get(currSum - k) || 0;
        hashmap.set(currSum, (hashmap.get(currSum) || 0) + 1);
    }

    return count;
};

let nums: number[] = [1, 1, 1];
let k: number = 2;

console.log(subarraySum(nums, k));