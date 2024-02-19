def solution(n):
    # return int(''.join(list(map(str, sorted(map(int, str(n)), reverse=True)))))
    return int("".join(sorted(list(str(n)), reverse=True)))