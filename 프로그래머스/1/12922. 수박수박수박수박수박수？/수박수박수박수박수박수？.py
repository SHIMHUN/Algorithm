def solution(n):
    return "수박"*(n//2) if n%2 == 0 else "수박"*((n-1)//2) + "수"
    # str = "수박"*n
    # return str[:n]