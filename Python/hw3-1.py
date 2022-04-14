
class Myerror(Exception):
    print("오류가 발생했습니다.")


f = open("weight.txt",'r')
content = f.readlines()
for line in content:
    a = str(line).split()
    if int(a[2]) == 0 or int(a[2]) < 0 or int(a[2]) >= 250 or int(a[1]) < 0 or int(a[3]) < 0:
        raise Myerror()
    def bmi():
        score = int(a[3]) / (int(a[2])/100)**2
        return score
    def result():
        if score >= 25:
            print("과체중")
        elif 18.5<= score < 25:
            print("정상체중")
        else:
            print("저체중")
    print(bmi)
f.close()


f=open("bmi.txt",'w')
f.write("이름   나이   키  몸무게  bmi   판정")
f.write("\n")
for line in content:
    a = str(line).split()
    data="%s   %s   %s   %s   %s   %s" % (a[0], a[1], a[2], a[3], bmi, result)
    f.write(data)
    f.write("\n")
f.close()


try:
    f = open('weight.txt','r')
except FileNotFoundError:
    print("파일이 없습니다.")
