def solution(x):
    # print(sum([int(x) for x in str(x)]))
    # return True if x % sum(map(int,str(x))) == 0 else False
    return x % sum(map(int,str(x))) == 0 