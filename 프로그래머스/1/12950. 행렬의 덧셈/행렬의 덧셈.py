def solution(arr1, arr2):
    
    # 방법 1. for문 2개 이용
    outer = []
    inner = []
    for i in range(len(arr1)):
        for j in range(len(arr1[i])):
            inner.append(arr1[i][j] + arr2[i][j])
        outer.append(inner)
        inner = []
    return outer
    
    # 방법 2. zip 활용 phythonic하게 구현
    return [[i+j for i, j in zip(x,y)] for x, y in zip(arr1, arr2)]
    