def fibo(n):
    first = 0
    second = 1
    for i in range(n):
        first, second = second, first + second
    
    return first

def solution(n):
    
    nth_fibo = fibo(n)
    answer = nth_fibo % 1234567
    return answer