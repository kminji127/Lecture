#3번
input1=int(input("첫번째 숫자를 입력하세요:"))
input2=int(input("두번째 숫자를 입력하세요:"))
total=input1+input2
print("두 수의 합은 %s입니다" % total)
print('')

#4번 - 3

#5번
f1=open("text1.txt",'w')
f1.write("Life is too short")
f1.close()
f2=open("text1.txt",'r')
print(f2.read())
f2.close()

print('')

#6번
m=open("newfile.txt", 'a')
m.write(input("내용을 입력하세요: "))
m.write("\n")
m.close()

#7번
with open("text.txt",'r') as f:
    body=f.read()

body=body.replace('java', 'python')

with open("text.txt", 'w') as f:
    f.write(body)
