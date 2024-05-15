import sys
input = sys.stdin.readline

n,b = map(int, input().split())
a = [[*map(int,input().split())]for i in range(n)]

def mul(x,y):
    n = len(x)
    z = [[0]*n for i in range(n)]
    
    for rows in range (n):
        for cols in range (n):
            
            e = 0
            for i in range(n):
                e += x[rows][i]*y[i][cols]
                
            z[rows][cols] = e%1000
                
    return z
    

def square(a,b):
    if b==1:
        for rows in range(len(a)):
            for cols in range(len(a)):
                a[rows][cols] = a[rows][cols]%1000
                
        return a
    
    k = square(a,b//2)
    
    if b%2:
        return mul(mul(k,k),a)
    else:
        return mul(k,k)
        
        
answer = square(a,b)
for i in answer:
    print(*i)
                
    