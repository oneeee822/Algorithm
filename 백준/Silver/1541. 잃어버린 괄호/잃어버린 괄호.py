minus = input().split('-')

plus = []

for a in minus:
    
    sum = 0
    tmp = a.split('+')
    
    for b in tmp:
        sum += int(b) 
        
    plus.append(sum)
    
    
ans = plus[0]
for i in range(1,len(plus)):
    ans-=plus[i]
    
print(ans)