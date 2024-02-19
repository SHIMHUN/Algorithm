def solution(n):
    print(type(reversed(list(map(lambda x:int(x),str(n))))))
    return list(reversed(list(map(lambda x:int(x),str(n)))))

    