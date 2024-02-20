def solution(arr1, arr2):
    answer = [[]]
    outer = []
    inner = []
    
    for i in range(len(arr1)):
        for j in range(len(arr1[i])):
            inner.append(arr1[i][j] + arr2[i][j])
        outer.append(inner)
        inner = []
    return outer
    
    # print(list(map(lambda x: list(map(lambda y: arr1[x][y] + arr2[x][y], range(len(arr1[x])),range(len(arr1)))))))
    
    return answer