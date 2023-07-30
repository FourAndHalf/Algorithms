"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
function majorityElement(nums) {
    nums.sort;
    var candidate = 0;
    var count = 0;
    for (var i = 0; i < nums.length; i++) {
        if (count === 0) {
            candidate = nums[i];
            count++;
        }
        else if (candidate === nums[i]) {
            count++;
        }
        else {
            count--;
        }
    }
    return candidate;
}
var nums = [3, 2, 3];
console.log(majorityElement(nums));
