def solution(k, a):
    MOD = int(1e9 + 7)
    count = 0

    
    a = sorted(a)
    i = 0
    j = 0
    lena = len(a)
    while (i < lena):
        if a[i] - a[j] == k:
            d1 = 1
            d2 = 1
            while True:
                if i+1 < lena and a[i+1] == a[i]:
                    i += 1
                    d1 += 1
                elif a[j+1] == a[j]:
                    j += 1
                    d2 += 1
                else:
                    i += 1
                    j += 1
                    count += d1*d2
                    break
        elif a[i] - a[j] > k:
            j += 1
        else:
            i += 1
            
    return count%MOD
