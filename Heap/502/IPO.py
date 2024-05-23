import heapq

def findMaximizedCapital(k, w, profits, capital):
    projects = sorted(zip(capital, profits))
    
    max_profit_heap = []
    current_capital = w
    i = 0
    n = len(profits)
    
    for _ in range(k):
        while i < n and projects[i][0] <= current_capital:
            heapq.heappush(max_profit_heap, -projects[i][1])
            i += 1

        if not max_profit_heap:
            break
        
        current_capital -= heapq.heappop(max_profit_heap)
    
    return current_capital

k = 2
w = 0
profits = [1, 2, 3]
capital = [0, 1, 1]
print(findMaximizedCapital(k, w, profits, capital)) 