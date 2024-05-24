def backTrack(start):
    if len(arr) == m:
        print(' '.join(map(str,arr)))
        return
    
    for i in range(start, n+1):
        arr.append(i)
        backTrack(i)
        arr.pop()
    
    
n, m = map(int, input().split())
arr = []

backTrack(1)