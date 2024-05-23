import heapq

def kSmallestPairs(nums1, nums2, k):
    min_heap = []
    result = []

    for i in range(min(k, len(nums1))):
        heapq.heappush(min_heap, (nums1[i] + nums2[0], i, 0))

    while k > 0 and min_heap:
        sum, i, j = heapq.heappop(min_heap)
        result.append([nums1[i], nums2[j]])
        if j + 1 < len(nums2):
            heapq.heappush(min_heap, (nums1[i] + nums2[j + 1], i, j + 1))
        k -= 1

    return result

nums1 = [1, 7, 11]
nums2 = [2, 4, 6]
k = 3

result = kSmallestPairs(nums1, nums2, k)
for pair in result:
    print(pair)
