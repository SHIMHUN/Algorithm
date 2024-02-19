def solution(s):
    if len(s) != 4 and len(s) != 6:
        return False
    return len(s) == len(list(filter(lambda x : ord(x) in range(48,58), s)))