import sys

n=int(input())
arr = []
cnt = 0
previous = 0

for i in range(n):
    a,b = map(int,sys.stdin.readline().rstrip().split())
    arr.append([a,b])
    
arr.sort(key=lambda x : (x[1],x[0]))

for start, end in arr:
    if start>=previous:
        cnt+=1
        previous = end
        
print(cnt)