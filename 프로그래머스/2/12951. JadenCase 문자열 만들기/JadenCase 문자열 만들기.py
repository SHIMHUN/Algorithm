import re

def solution(s):
#   일단 split으로 문장을 쪼개기?
#   re 패키지의 사용법 및 패턴 사용에 대한 사용법  
#   capitalize()라는 함수
    list_s = re.findall(r'\S+|\s', s)
    upper_s = [x.capitalize() for x in list_s]  
    answer = ''.join(upper_s)
    return answer