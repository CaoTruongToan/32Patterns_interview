def singleNumber(nums):
    accumulator = 0
    for num in nums:
        accumulator ^= num
    return accumulator

nums = [5, 3, 5, 4, 3]
result = singleNumber(nums)
print(result) 




