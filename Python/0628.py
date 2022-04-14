#03-1
#1번
a="Life is too short, you need python"
if 'wife' in a:
    print('wife')
elif 'python' in a and 'you' not in a:
    print('python')
elif 'shirt' not in a:
    print('shirt')
elif 'need' in a:
    print('need')
else:
    print('none')

b="Life is too short, you need python"
if 'wife' in a: print('wife')
elif 'python' in a and 'you' not in a:
    print('python')
elif 'need' in a:print('need')
elif 'shirt' not in a:print('shirt')
else:print('none')

coffee=10
while True:
    money=int(input("돈을 넣어주세요."))
    if money==300:
        print("커피를 드리겠습니다.")
        coffee=coffee-1
        print("남은 커피의 양은 %d개 입니다." % coffee)
    elif money>300:
        print("커피와 거스름돈 %d원을 받으세요." % (money-300))
        coffee=coffee-1
        print("남은 커피의 양은 %d개 입니다." % coffee)
    else:
        print("돈을 다시 돌려드립니다. 커피를 드릴 수 없습니다.")
        print("남은 커피의 양은 %d개 입니다." % coffee)
    if coffee==0:
        print("커피가 다 떨어졌습니다. 판매를 중지합니다.")
        break
