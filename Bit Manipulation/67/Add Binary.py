def addBinary(a: str, b: str) -> str:
    i, j = len(a) - 1, len(b) - 1
    carry = 0
    ans = []

    while i >= 0 or j >= 0 or carry:
        bit1 = int(a[i]) if i >= 0 else 0
        bit2 = int(b[j]) if j >= 0 else 0
        total = bit1 + bit2 + carry
        carry, val = divmod(total, 2)
        ans.append(str(val))
        i -= 1
        j -= 1

    return ''.join(reversed(ans))

a = "101"
b = "110"
print(addBinary(a, b)) 
