def solution(arr, divisor):
    # answer = sorted(filter(lambda x: x%divisor==0, arr))
    # return answer if len(answer) != 0 else [-1]
    return sorted(filter(lambda x: x%divisor==0, arr)) or [-1]