N = int(input())
cost = 0

distance = list(map(int,input().split()))
price = list(map(int,input().split()))

min = price[0]
for i in range(N-1):
    if min>price[i]:
        min = price[i]
    
    cost += min*distance[i]
    
print(cost)