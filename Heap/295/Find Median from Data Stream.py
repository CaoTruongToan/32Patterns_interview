import heapq

class MedianFinder:
    def __init__(self):
        self.maxHeap = []  # Max heap (inverted to use as a max heap)
        self.minHeap = []  # Min heap

    def addNum(self, num: int) -> None:
        heapq.heappush(self.maxHeap, -num)
        heapq.heappush(self.minHeap, -heapq.heappop(self.maxHeap))
        
        if len(self.minHeap) > len(self.maxHeap):
            heapq.heappush(self.maxHeap, -heapq.heappop(self.minHeap))

    def findMedian(self) -> float:
        if len(self.maxHeap) > len(self.minHeap):
            return -self.maxHeap[0]
        else:
            return (-self.maxHeap[0] + self.minHeap[0]) / 2.0
        
def main():
    mf = MedianFinder()
    numbers = [3, 1, 5, 2]
    
    for num in numbers:
        mf.addNum(num)
        print(f"Added {num}, current median is: {mf.findMedian()}")

if __name__ == "__main__":
    main()
