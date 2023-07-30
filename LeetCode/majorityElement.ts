export {};

//* Moore Voting Algorithm
function majorityElement(nums: number[]): number {
    nums.sort;
    let candidate: number = 0;
    let count: number = 0;

    for(let i = 0;i < nums.length;i++) {                //! Time Complexity = O(n)
        if(count === 0) {
            candidate = nums[i];
            count++;
        } else if(candidate === nums[i]) {
            count++;
        } else {
            count--;
        }
    }
    return candidate;
}                                                       //! Total Time Complexity = O(n)

//* HashMap Method
function hashmapMajorityElement(nums: number[]): number {
    let map = new Map<number, number>();

    for(let i = 0;i < nums.length;i++) {                            //! Time Complexity = O(n)
        if(map.has(nums[i])) {
            let value = map.get(nums[i]);
            if(value !== undefined) {
                map.set(nums[i], value+1);
            }
        } else {
            map.set(nums[i], 1);
        }
    }

    let n = nums.length/2;
    let keys = map.keys();
    for(let key of keys) {                                          //! Time Complexity = O(n)
        let value = map.get(key);
        if(value !== undefined && value > n ) {
            return key;
        }
    }

    return 0;
}                                                                   //! Total Time Complexity = O(n)

let nums: number[] = [3, 2, 3];

console.log(majorityElement(nums));