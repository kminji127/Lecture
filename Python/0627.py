#02-5
#1번 문제
dic={'name':'홍길동','birth':1128,'age':30}
print(dic)

#2번 문제: 3번. 리스트는 key 값으로 못 들어감


#3번 문제
a={'A':90, 'B':80}
b=a.get('C',70)
print(b)

#02-6
#1번
a=[1,1,1,2,2,3,3,3,4,4,5]
s1=set(a)
b=list(s1)
print(b)

#2번
a={'a', 'b', 'c'}
print(type(a))

a={}
print(type(a))

a=set()
print(type(a))

#02-7
a=[1,2,3,4]
while a:
    print(a.pop())

if []:
    print("참")
else:
    print("거짓")

#1번
a=[1,2,3]
b=[1,2,3]
print(id(a))
print(id(b))
print(a is b)


#2번
a=[1,2,3]
a=a+[4,5]
print(a)
print(id(a))

a=[1,2,3]
a.extend([4,5])
print(a)
print(id(a))
