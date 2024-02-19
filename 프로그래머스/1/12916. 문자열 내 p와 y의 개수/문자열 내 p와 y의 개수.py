def solution(s):
    answer = True
    if len(list(filter(lambda x : x=="p", s.lower()))) == len(list(filter(lambda x : x=="y", s.lower()))):
        return True
    return False