## 리스트
# * list()
# * scan(what=list())

Scandata <- scan("data3.txt", what = list("","",0), skip=1, fileEncoding="UTF-8")
str(Scandata)
names(Scandata) <- c("gender", "jobcat", "salary")

x <- c(10, 20, 30)
y <- c("A", "B", "C", "D")
# (List <- list(x, y))
# names(List) <- c("X", "Y")
(List1 <- list(X=x, Y=y)) # 위 2줄 통합

List1[1] # 원소명+값
List1[[1]] # 값
List1$X # 값

class(List1) # "list"
class(List1[1]) # "list"
class(List1[[1]]) # "numeric"
class(List1$X) # "numeric"

(List2 <- list(x1=0, x2=x, x3=y, x4=mean))
class(List2$x4) # "function"
List2[c(1,3)] # 1,3번째 리스트
List2[c(1,3)][2] # 1,3번째 리스트 중 2번째 리스트
List2[c(2,3)][[1]]

mean(Scandata[[3]])
mean(Scandata[3]) # 인자가 수치형 또는 논리형이 아니므로 NA를 반환

List2[[4]](x) # x <- c(10, 20, 30)
# = List2$x4(x)

List2[1] <- NULL # 제거
List2$x4 <- NULL
List2

값 <- pnorm(-2:2) # P(X<=x)인 누적분포함수 (표준정규분포를 따름)
이름 <- c("far.left", "left", "mid", "right", "far.right")
List3 <- list() # 빈 리스트 생성
List3[이름] <- 값 # 리스트에 이름, 값 대입
List3 < 0.5 # TTFFF
List3[List3<0.5] <- NULL
List3

List4 <- list(Value=값)
List4 < 0.5 # Error
List4[[1]] < 0.5 # = List4$Value < 0.5
unlist(List4) < 0.5 # 리스트 해제

List3 <- list()
List3[이름] <- 값
(Lst1 <- c(List3, List4))
(Lst2 <- list(List3, List4))
summary(Lst1)
summary(Lst2)

Lst2[[1]]
Lst2[[1]][1]
Lst2[[1]][[1]] # = Lst2[[1]]$far.left
Lst2[[2]]$Value # = Lst2[[2]][[1]]