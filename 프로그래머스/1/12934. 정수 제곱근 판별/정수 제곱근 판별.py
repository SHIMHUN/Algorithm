import math

def solution(n):
    x = math.sqrt(n)
    return (x+1)**2 if str(x)[-1] == "0" else -1