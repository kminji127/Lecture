#13번

data = "4546793"
numbers = list(map(int,data))
result = []

for i, num in enumerate(numbers):
    result.append(str(num))
    if i < len(numbers)-1:
        is_odd = num % 2 == 1
        is_next_odd = numbers[i+1] % 2 == 1
        if is_odd and is_next_odd:
            result.append("-")
        elif not is_odd and not is_next_odd:
            result.append("*")

print("".join(result))
print('')

#14번

def compress_string(s):
    _c=""
    cnt=0
    result=""
    for c in s:
        if c!=_c:
            _c=c
            if cnt: result = result + str(cnt)
            result = result + c
            cnt = 1
        else:
            cnt = cnt+1
    if cnt: result = result + str(cnt)
    return result
    

print(compress_string("aaabbcccccca"))

print('')

#15번

def chkDupnum(s):
    result=[]
    for num in s:
        if num not in result:
            result.append(num)
        else:
            return False
    return len(result) == 10

print(chkDupnum("0123456789"))
print(chkDupnum("01234"))
print(chkDupnum("01234567890"))
print(chkDupnum("6789012345"))
print(chkDupnum("012322456789"))
