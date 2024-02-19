def solution(absolutes, signs):
    int_set = list(zip(absolutes, signs))
    return sum([int_set[x][0] if int_set[x][1] == True else int_set[x][0]*(-1) for x in range(len(int_set))])