def solution(s):
    a = s.split()
    b = [int(x) for x in a]
    
    max = b[0]
    min = b[0]
    
    for i in range(len(a)):
        if b[i] > max:
            max = b[i]
        if b[i] < min:
            min = b[i]

    answer = '{} {}'.format(min, max)
    return answer