def solution(num):
    calc_cnt = 0
    while calc_cnt < 500:
        if num == 1:
            return calc_cnt
        if num % 2 == 0:
            num/=2
        else:
            num=(num*3)+1
        calc_cnt+=1
    return -1