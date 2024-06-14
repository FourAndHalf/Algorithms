package main

import "fmt"

func BinarySearch(arr []int, target int) int {
    left, right := 0, len(arr) - 1
    
    // Binary Search Implementation
    for left <= right {
        mid := left + (right - left)/2
        if arr[mid] == target {
            return mid
        } else if arr[mid] < target {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return -1;
}

func main() {
    testArray := []int{
        1, 3, 5, 7, 9, 11, 13, 15, 17, 19,
        21, 23, 25, 27, 29, 31, 33, 35, 37, 39,
        41, 43, 45, 47, 49, 51, 53, 55, 57, 59,
        61, 63, 65, 67, 69, 71, 73, 75, 77, 79,
        81, 83, 85, 87, 89, 91, 93, 95, 97, 99,
    }

    // Test Cases 
    targets := []int{1, 25, 50, 75, 99, 2, 100}

    for _, target := range targets {
        result := BinarySearch(testArray, target)
        
        if result != -1 {
            fmt.Printf("Target %d found at index %d \n", target, result)
        } else {
            fmt.Printf("Target %d not found in array \n", target)
        }
    }
}
