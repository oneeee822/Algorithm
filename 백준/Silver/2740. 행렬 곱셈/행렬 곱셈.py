n, m = map(int, input().split())
a = [list(map(int, input().split())) for i in range(n)]

m, k = map(int, input().split())
b = [list(map(int, input().split())) for i in range(m)]

axb = [[0]*k for i in range(n)]

for rows in range(n):
    for cols in range(k):
        x = 0;
        for i in range(m):
            x += a[rows][i] * b[i][cols]
            
        axb[rows][cols] = x
        
for answer in axb:
    print(*answer)