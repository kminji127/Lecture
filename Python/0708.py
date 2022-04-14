#05-4,5
class MyError(Exception):
    def __str__(self):
        return "허용되지 않는 별명입니다."

def say_nick(nick):
    if nick=='바보':
        raise MyError()
    print(nick)

try:
    say_nick("천사")
    say_nick("바보")
except MyError as e:
    print(e)


def positive(x):
    return x>0

print(list(filter(positive,[1,-3,2,0,-5,6])))

print('')

#연습문제
#4번 - 1
def pos(y):
    return y>0
print(list(filter(positive,[1, -2, 3, -5, 8, -3])))

#4번 - 2
print(list(filter(lambda z:z>0, [1, -2, 3, -5, 8, -3])))
print('')

#5번
a=hex(234)
print(a)
b=int(a,16)
print(b)
print('')

#6번(-)
def two(numberlist):
    result=[]
    for num in numberlist:
        result.append(num*3)
    return result
result=two([1,2,3,4])
print(result)
print('')

def three(numberlist):
    result=[num*3 for num in numberlist]
    return result
result=three([1,3,5,7])
print(result)

print('')
def three_times(x):
    return x*3
print(list(map(three_times, [1,2,3,4])))
print('')

print(list(map(lambda x:x*3, [1,2,3,4])))

#7번
a=[-8, 2, 7, 5, -3, 5, 0, 1]
b=max(a)
c=min(a)
print(b)
print(c)
print(b+c)
print('')

#8번
print(round(17/3,4))
print('')

#12번
import time
a= time.strftime('%Y'+"/"+'%m'+"/"+'%d'+" %X", time.localtime(time.time()))
print(a)
print('')

#13번
print("로또")
result=[]
import random
while len(result)<6:
    number = random.randint(1,45)
    if number not in result:
        result.append(number)
print(result)
print('')

#06-1
print("GuGu(n)를 입력하면 n단이 출력됨")
print("7단")
def GuGu(n):
    result=[]
    for i in range(1,10):
        result.append(n*i)
    return result
print(GuGu(7))
print('')
print('4단')
def GuGu(n):
    result=[]
    i=1
    while i<10:
        result.append(n*i)
        i=i+1
    return result
print(GuGu(4))
print('')
print("11단부터 19단까지 - 1")
def GuGu():
    for k in range(11,20):
        print(k,'단: ',end=" ")
        for j in range(1,20):
            print(k*j,end=" ")
        print('')
print(GuGu())
print("11단부터 19단까지 - 2")
def GuGu():
    n=1
    i=1
    while n<10:
        n=n+1

print('')
print('')


#06-2
result=0
for i in range(1,1000):
    if i%3 == 0 or i%5 == 0:
        result=result+i
    else:
        pass
print("1000 미만의 자연수에서 3의 배수와 5의 배수의 총합은 %d이다." % result)
print('')

a=0
b=0
for n in range(1,101):
    a=a+n

for i in range(1,101):
    b=b+i**2

print("합의 제곱: %d" % a**2)
print("제곱의 합: %d" % b)
print("합의 제곱 - 제곱의 합 = %d" % (a**2-b))
