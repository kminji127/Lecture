#1번
money=10000
print("%d원의 금액이 적립되어 있습니다." % money)
print('')
prompt="""다음 메뉴에 해당되는 번호를 입력하세요.
1. 아메리카노  1500
2. 카페라떼    2000
3. 에스프레소  1800
4. 주문을 끝냅니다.
"""
menu=1
while money>=1500 and 1<=menu<=3:
    print(prompt)
    menu=int(input("-->"))
    if menu==1:
        print("손님께서는 아메리카노를 주문하셨습니다.")
        money=money-1500
        print("잔돈은 %d입니다." % money)
    elif menu==2:
        print("손님께서는 카페라떼를 주문하셨습니다.")
        money=money-2000
        print("잔돈은 %d입니다." % money)
    else:
        print("손님께서는 에스프레소를 주문하셨습니다.")
        money=money-1800
        print("잔돈은 %d입니다." % money)
    if menu==4:
        print("주문을 끝냅니다. 이용해 주셔서 감사합니다.")
        break
    if money<1500:
        print("잔액이 부족합니다.")
print('')
print('')

#2번
def mymin(*args):
    result=args[0]
    for score in args[1:]:
        if score < result:
            result=score
    return(result)
result = mymin(-10, 0, -20, 3, 8)
print(result)
