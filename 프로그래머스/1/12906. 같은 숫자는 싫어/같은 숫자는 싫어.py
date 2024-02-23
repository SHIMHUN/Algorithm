def solution(arr):
    answer = [arr.pop()]

    while len(arr) >= 1:
        item = arr.pop()
        if item == answer[-1]:
            pass
        else:
            answer.append(item)
    
    answer.reverse()
    return answer