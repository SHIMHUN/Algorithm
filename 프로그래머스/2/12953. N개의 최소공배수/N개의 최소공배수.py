def solution(arr):
    init = max(arr)
    standard = init
    cnt = 0
    while(True):
        for i in arr:
            if standard % i == 0:
                cnt+=1
        if cnt == len(arr):
            return standard
        cnt = 0
        standard=standard+init