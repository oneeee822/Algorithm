import sys
input = sys.stdin.readline

n, k = map(int, input().split())
divide = 1000000007

def factorial(n):
    
    result = 1
    
    for i in range(2,n+1):
        result = (result*i)%divide
        
    return result
        
def pow(n,k):
    
    if(k==0):
        return 1
    elif(k==1):
        return n
    
    tmp = pow(n,k//2)
    if(k%2==0):
        return tmp*tmp%divide
    else:
        return tmp*tmp*n%divide

top = factorial(n)
bottom = pow(factorial(k)*factorial(n-k)%divide ,divide-2)

print(top*bottom%divide)
  