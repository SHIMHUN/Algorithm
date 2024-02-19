def solution(left, right):
    return sum([divisor(x) for x in range(left, right+1)])

def divisor(x):
    count = len(list(filter(lambda y : x%y == 0, range(1, x+1))))
    return x if count % 2 == 0 else x*-1

