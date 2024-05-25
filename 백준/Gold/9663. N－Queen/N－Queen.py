n = int(input())

ans = 0
row = [0]*n

def is_promising(x):
    for i in range(x):
        if row[x] == row[i] or abs(row[x]-row[i])==abs(x-i):
            return False
    return True
            
def n_queen(x):
    global ans
    if x==n:
        ans +=1
        return
    else:
        for i in range(n):
            row[x] = i #x행 i열에 퀸
            if is_promising(x):
                n_queen(x+1)
                
n_queen(0)
print(ans)
    