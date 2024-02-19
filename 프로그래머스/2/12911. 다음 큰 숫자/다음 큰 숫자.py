def solution(n):
    init_num = bin(n).count("1")
    find_num = n+1
    while True:
        if init_num == bin(find_num).count("1"):
            return find_num
        find_num+=1