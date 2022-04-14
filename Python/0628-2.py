#03-2
#1번
s=0
a=0
while a<=1000:
    a=a+1
    if a%3==0:
        s=s+a
print(s)


#2번
b=0
A=[20,55,67,82,45,33,90,87,100,25]
while A:
    c=A.pop()
    if c>=50:b=b+c
print(b)

#3번
i=0
while i<4:
    i=i+1
    print("*"*i)
