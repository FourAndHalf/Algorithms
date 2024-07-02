function productExceptSelf(nums []int) []int {
    res := make([]int, len(nums))
    length := len(nums)

    for i := range res {
        res[i] := 1
    }

    prefix := 1
    for i := 0;i < length;i++ {
        res[i] := prefix
        prefix *= nums[i]
    }

    suffix := 1
    for i := length-1;i >= 0;i-- {
        res[i] *= suffix
        suffix *= nums[i]
    }

    return res
}
