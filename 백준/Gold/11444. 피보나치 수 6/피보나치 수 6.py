import sys
input = sys.stdin.readline

n = int(input())
p = 1000000007

def mul(a,b):
    n = len(a)
    c = [[0]*n for i in range(n)]
    
    for row in range(n):
        for col in range(n):
            
            e = 0;
            for i in range(n):
                e += a[row][i]*b[i][col]
                
            c[row][col] = e%p
    
    return c
    
def square(m,n):
    
    if n ==1:
        for i in range (len(m)):
            for j in range (len(m)):
                m[i][j] %= p
                
        return m
                
    k = square(m,n//2)
    if n%2:
        return mul(mul(k,k),m)
    else:
        return mul(k,k)

matrix = [[1,1],[1,0]]
print(square(matrix,n)[0][1])