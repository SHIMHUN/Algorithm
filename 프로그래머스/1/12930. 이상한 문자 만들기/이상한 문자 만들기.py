def solution(s):
    start = 0
    result = ""
    for i in s:
        if i == " ":
            result += " "
            start = 0
        else:
            if start % 2 == 0:
                result += i.upper()
            else:
                result += i.lower()
            start +=1
    return result 
    
def change(x):
    result=""
    for i in range(len(x)):
        if i%2 == 0:
            # print("test1")
            print(x[i].upper())
            result+=x[i].upper()
        else:
            # print("test2")
            print(x[i])
            result+=x[i].lower()
    print(result)
    return result