def solution(left, right):
    result = 0
    for i in range(left, right+1):
        if divisor(i) % 2 == 0:
            result += i
        else:
            result -= i
    return result
    divisor(13)
    divisor(14)
    divisor(15)
    divisor(16)
    divisor(17)
def divisor(x):
    return len(list(filter(lambda y : x%y == 0, range(1, x+1))))
    # print(list(filter(lambda y : x%y == 0, range(1, x+1))))

