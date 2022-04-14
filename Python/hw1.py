
#1번
print("="*60)
print("{0:^60}".format("I Love Sookmyung Women’s University"))
print("="*60)


#2번
n1=35.6354
n2=82.8192
n3=3
print("n1=35.6354 \t n2=82.8192 \t n3=3")
print("n1+n2=%0.2f" % (n1+n2))
print("n1-n2=%0.2f" % (n1-n2))
print("n1*n2=%0.2f" % (n1*n2))
print("n1/n2=%0.2f" % (n1/n2))
print("n1**n2=%0.2f" % (n1**n3))
print("n1%%n2=%0.2f" % (n1%n2))
print("n1//n2=%0.2f" % (n2//n1))

#format을 사용한 방법



#3번
e_list=["eA", "eB", "eC"]
for number in range(len(e_list)):
    print("%d번째 요소는 " % number + e_list[number] + "입니다.")


#4번
import datetime
now = datetime.datetime.now()
month = now.month

if month>=3 and month<=5:
    print("현재는 봄입니다.")
elif month>=6 and month<=8:
    print("현재는 여름입니다.")
elif month>=9 and month<=11:
    print("현재는 가을입니다.")
else:
    print("현재는 겨울입니다.")
