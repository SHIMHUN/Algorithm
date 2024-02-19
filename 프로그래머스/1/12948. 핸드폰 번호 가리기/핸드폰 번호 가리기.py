def solution(phone_number):
    # "*"*(len(phone_number)-4)
    # return ''.join(["*" for _ in phone_number[:len(phone_number)-4]]) + phone_number[len(phone_number)-4:]
    return "*"*(len(phone_number)-4) + phone_number[len(phone_number)-4:]