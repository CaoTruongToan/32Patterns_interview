def partition(nums, left, right):
    pivot = nums[right]
    i = left - 1

    for j in range(left, right):
        if nums[j] < pivot:
            i += 1
            nums[i], nums[j] = nums[j], nums[i]

    nums[i + 1], nums[right] = nums[right], nums[i + 1]
    return i + 1

def quick_select(nums, left, right, k):
    if left == right:
        return nums[left]

    pivot_index = partition(nums, left, right)
    target_index = len(nums) - k

    if pivot_index == target_index:
        return nums[pivot_index]
    elif pivot_index < target_index:
        return quick_select(nums, pivot_index + 1, right, k)
    else:
        return quick_select(nums, left, pivot_index - 1, k)

nums = [3, 2, 1, 5, 6, 4]
k = 2

result = quick_select(nums, 0, len(nums) - 1, k)
print("The", k, "nd largest element is:", result)
