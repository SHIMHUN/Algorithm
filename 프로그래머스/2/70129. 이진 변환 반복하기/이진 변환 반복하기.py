import re

def solution(s):
    conv_cnt = 0 # 이진 변환의 횟수 conv_cnt
    rm_cnt = 0 # 제거된 0의 갯수 rm_cnt
    
    conv_before = s # 이진 변환 전 결과
    conv_after = "" # 이진 변환 결과
    
    while True:
        # 1. 모든 0 제거
        rm_cnt += conv_before.count("0") # 제거할 0 갯수
        
        rm_result = re.sub(r'0','',conv_before) # 0 제거
        
        # 2. 이진법으로 문자열 변환
        conv_after = bin(len(rm_result))[2:] # 이진 변환 완료
        conv_before = conv_after
        
        # 3. 갯수 카운트
        conv_cnt += 1
        
        # 이진 변환 결과 "1"시 루프 종료
        if conv_before == "1":
            break

    answer = [conv_cnt, rm_cnt]
    return answer