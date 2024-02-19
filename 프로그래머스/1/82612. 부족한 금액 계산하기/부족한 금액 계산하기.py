def solution(price, money, count):
    coin = [price*i for i in range(1, count+1)]
    result = money - sum(coin)
    return 0 if result > 0 else abs(result)