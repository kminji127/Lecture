#3번

while True:
    print("")
    repeat=int(input("반복횟수를 입력하세요 : "))
    if repeat<=0:break
    print("")
    for i in range(repeat,0,-1):
        print("*"*i)
    if repeat==0:
        print("0 이하는 출력할 수 없습니다. 종료합니다.")
        break
