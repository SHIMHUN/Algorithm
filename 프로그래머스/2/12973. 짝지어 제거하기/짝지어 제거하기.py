def solution(s):
    answer = -1

    conv_s = []
    
    for i in s:
        if len(conv_s) == 0 or conv_s[-1] != i:
            conv_s.append(i)
        else:
            conv_s.pop()
    
    return 1 if len(conv_s) == 0 else 0