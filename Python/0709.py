#06-3
print("[게시판 페이징하기]")
# m = 게시물의 총 건수 \t n = 페이지당 보여줄 게시물 수"
def getTotalPage(m,n):
    if m%n == 0:
        result = m//n
    else:
        result = (m//n)+1
    return result
print("getTotalPage(m,n)")
print("m=5 n=10 -->", getTotalPage(5,10))
print("m=15 n=10 -->", getTotalPage(15,10))
print("m=25 n=10 -->", getTotalPage(25,10))
print("m=30 n=10 -->", getTotalPage(30,10))
