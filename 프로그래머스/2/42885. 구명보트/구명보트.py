def solution(people, limit):
    people.sort()
    
    result = 0
    start = 0
    end = len(people)
    
    while end-start >= 1:
        
        #최소 2개 이상 남아있을 때 루프 검사
        if people[end-1] + people[start] <= limit and end-start >= 2:
            start+=1
            end-=1
        else:
            end-=1
        result+=1
        

    return result