def solution(n):
    answer = 0
    result = []
    
    while True:
        if n==0:
            break
        result.append(n%3)
        n=n//3
    return sum([3**(len(result)-i-1) * result[i] for i in reversed(range(len(result)))])

#     tmp = ''
#     while n:
#         tmp += str(n % 3)
#         pri
#         print(tmp)
#         n = n // 3

#     answer = int(tmp, 3)
#     return answer
    