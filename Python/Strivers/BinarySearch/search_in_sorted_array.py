def binary_search(arr: list[int], target: int) -> int:
    low = 0
    high = len(arr) - 1

    while low <= high:
        mid = (low + high) // 2
        
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            low = mid + 1
        else:
            high = mid - 1
            
    return -1

def binary_search_recursive(arr: list[int], target: int, low: int, high: int) -> int:
    if low > high:
        return -1
    
    mid = (low + high) // 2
    
    if arr[mid] == target:
        return mid
    elif arr[mid] < target:
        return binary_search_recursive(arr, target, mid + 1, high)
    else:
        return binary_search_recursive(arr, target, low, mid - 1)

if __name__ == "__main__":
    test_arr = [1, 3, 5, 7, 9, 11, 13, 15]
    
    print("--- Iterative Binary Search ---")
    print(f"Target 7 found at index: {binary_search(test_arr, 7)}") 
    print(f"Target 1 found at index: {binary_search(test_arr, 1)}") 
    print(f"Target 15 found at index: {binary_search(test_arr, 15)}")
    print(f"Target 6 found at index: {binary_search(test_arr, 6)}")
    print(f"Target 5 in empty array: {binary_search([], 5)}")

    print("\n--- Recursive Binary Search ---")
    print(f"Target 7 found at index: {binary_search_recursive(test_arr, 7, 0, len(test_arr) - 1)}") 
    print(f"Target 1 found at index: {binary_search_recursive(test_arr, 1, 0, len(test_arr) - 1)}") 
    print(f"Target 15 found at index: {binary_search_recursive(test_arr, 15, 0, len(test_arr) - 1)}")
    print(f"Target 6 found at index: {binary_search_recursive(test_arr, 6, 0, len(test_arr) - 1)}")
    print(f"Target 5 in empty array: {binary_search_recursive([], 5, 0, -1)}")
