def solution(s):
    answer = True
    left = []
    for i in s:
        if i == "(":
            left.append("(")
        else:
            if left:
                left.pop(-1)
            else:
                return False
    return True if not left else False