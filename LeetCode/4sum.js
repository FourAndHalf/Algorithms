"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
function fourSum(nums, target) {
    var n = nums.length;
    nums.sort(function (a, b) { return a - b; });
    var solution = [];
    for (var i = 0; i < n - 3; i++) {
        for (var j = i + 1; j < n - 2; j++) {
            var newTarget = target - nums[i] - nums[j];
            var low = j + 1, high = n - 1;
            while (low < high) {
                if (nums[low] + nums[high] < newTarget) {
                    low++;
                }
                else if (nums[low] + nums[high] > newTarget) {
                    high--;
                }
                else {
                    solution.push([nums[i], nums[j], nums[low], nums[high]]);
                    var tempIndex1 = low, tempIndex2 = high;
                    while (low < high && nums[low] == nums[tempIndex1])
                        low++;
                    while (low < high && nums[high] == nums[tempIndex2])
                        high--;
                }
            }
            while (j + 1 < n && nums[j] == nums[j + 1])
                j++;
        }
        while (i + 1 < n && nums[i] == nums[i + 1])
            i++;
    }
    return solution;
}
var nums = [1, 0, -1, 0, -2, 2];
var target = 0;
console.log(fourSum(nums, target));
