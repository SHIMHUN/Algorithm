def solution(n):
    sum_cnt = 1
    for i in range(1,n//2+1):
        sum_num = 0
        while sum_num < n:
            sum_num += i
            i+=1
        if sum_num == n:
            sum_cnt +=1
    return sum_cnt
    # return len([i  for i in range(1,num+1,2) if num % i is 0])