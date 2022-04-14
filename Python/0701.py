#3장 연습문제
#3번
k=0
while True:
    k=k+1
    if k>5:
        break
    print("*"*k)

print('')

#4번
for i in range(1,101):
    print(i, end=" ")

print('')
print('')

#5번
a=[70,60,55,75,95,90,80,80,85,100]
average=0
for i in a:
    average=average+i
print(average/len(a))

print('')

#6번
numbers=[1,2,3,4,5]
result=[n*2 for n in numbers if n%2==1]
print(result)

print('')

#4장 연습문제
#1번
def is_odd(num):
    if num%2==0:
        print("%d는 짝수입니다."% num)
    else:
        print("%d는 홀수입니다." % num)
    return
result=is_odd(4)
result2=is_odd(5)

print('')
print('')

#2번
def add_many(*args):
    sum=0
    for i in args:
        sum=sum+i
    return sum/len(args)
result=add_many(1,4,8,2)
print(result)
