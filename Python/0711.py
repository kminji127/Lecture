#08장 종합문제

#8번

f=open('abc.txt','r')
content=f.readlines()
f.close()

content.reverse()

f=open('cba.txt','w')
for line in content:
    line = line.strip()
    f.write(line)
    f.write("\n")
f.write("324")
f.close()

#9번
f=open('sample.txt','r')
line = f.readlines()
f.close()

sum = 0
for i in line:
    sum = sum + int(i)
avg = sum / len(line)


f=open('result.txt','w')
f.write(str(avg))
f.close()
