def reverseBits(n: int) -> int:
    res = 0
    for i in range(8):
        res = (res << 1) | (n & 1)
        n >>= 1
    return res

n = 5
print(f"{reverseBits(n):08b}")
