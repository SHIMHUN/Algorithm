def solution(d, budget):
    sum = 0
    cnt = 0
    department = sorted(d)
    len_d = len(department)
    for i in range(0, len_d):
        if sum+department[i] > budget:
            return cnt
        sum+=department[i]
        cnt+=1
    return cnt
        
        