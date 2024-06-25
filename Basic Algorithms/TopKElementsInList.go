package main 

import "fmt"

func topKFrequent(arr []int, k int) []int {
    HashMap := make(map[int]int)

    for _, n := range arr {
        HashMap[n]++
    }

    ans := make([]int, k)

    for i := 0; i < k; i++ {
        maxVal := 0
        for key, value := range HashMap {
            if value > maxVal {
                maxVal = value
                ans[i] = key
            }
        }
        delete(HashMap, ans[i])
    }

    return ans
} 

