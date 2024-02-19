def solution(brown, yellow):
    width = 3
    length = 3
    sum_by = brown + yellow
    # mul_by = brown * yellow
    
    for i in range(1, sum_by):
        if(sum_by % i == 0):
            width = max(i, sum_by//i)
            length = min(i, sum_by//i)
            if((width - 2) * (length - 2) == yellow):
                break
    
    answer = [width, length]
    return answer