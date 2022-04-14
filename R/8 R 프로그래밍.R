## 조건문
# If
a = 4; b = 0
if(a < 2) { # if(a<2) b=1
  b = 1
}

# If~else
a=3
if(a<2) { # if(a<2) b=1 else b=0
  b=1
} else {
  b=0
}

# 복합 조건문
a = 3
if(a < 2) {
  b = 1
} else {
  if(a < 3) {
    b = 2
  }
  if(a >= 3) {
    b = 3
  }
}
#if(a<2) b=1 else
#  if(a<3) b=2
#  if(a>=3) b=3

# ifelse
a <- 10; b <- 20
ifelse(a>b, c<-a, c<-b) # c = 20
#if(a>b) {
#  c <- a
#} else {
#  c <- b
#}


## 반복문
# for
for (i in 1:10) {
  print(i)
}

for(i in 1:10) {
  cat("2 *", i, "=", 2*i, "\n") # cat: print 강화 버전, 줄바꿈 "\n" 사용 가능
}

n <- 1000000
x <- 1:n
evensum <- 0
for (value in x) {
  if (value %% 2 == 0) evensum <- evensum + value
}
evensum

sum(x[x %% 2 == 0]) # 반복문보다 빠른 속도
sum(x[!x %% 2 == 0])

item = c("C", "B", "D", "A", "F")
# which("A" == item) # "A" 위치값 = 4
for(x in c("A", "B")) {
  cat(x, "is", which(x==item), "-th item.\n")
}

for (x in c("A", "B", "K")) {
  cat(x, "is", which(x==item), "-th item.\n")
}

for (x in c("A", "B", "K")) {
  if(x %in% item) { # %in% : 벡터에 속하는가 (문자, 숫자 비교 가능)
    cat(x, "is", which(x==item), "-th item.\n") # "A", "B"만 출력
  }
}

# while
x <- numeric() # NULL
for(i in 1:1000) {
  난수 <- rnorm(1)
  x <- c(x, 난수)
  if (난수 < -1.0)
    break
}
x

난수 <- rnorm(1)
x <- 난수
while(난수 >= -1.0) {
  난수 <- rnorm(1)
  x <- c(x, 난수)
}
x

x <- numeric()
repeat {
  난수 <- rnorm(1)
  x <- c(x, 난수)
  if (난수 < -1.0) break
}
x


## 함수 만들기
# 함수명 <- function(매개변수) { return value }
mymax <- function(x,y) {
  num.max <- x
  if (y > x) num.max <- y
  return(num.max) # 실행 결과
}
mymax(10,15)
mymax(20,14)

mydiv <- function(x, y=2) { # 디폴트값 지정
  result <- x/y
  return(result)
}
mydiv(x=10, y=3)
mydiv(10,3) # x=10, y=3
mydiv(10) # x=10, y=2

# 리턴 값 여러 개 : list()
myfunc <- function(x,y) {
  val.sum <- x+y
  val.mul <- x*y
  return(list(sum=val.sum, mul=val.mul))
}
(result <- myfunc(5,8))
result$sum
result$mul

setwd("C:/Users/mjkim/Documents/R Projects/R_Study")
source("myfunc.R") # 함수 불러오기
myfunc(2,3) # 함수 이용


## apply 함수: for, while에서 처리 속도 향상, 결과가 벡터
for (i in 1:4) {
  mean(iris[,i])
}

apply(iris[,1:4], 2, mean) # 열 방향, 결과가 벡터
apply(iris[,1:4], 1, mean) # 행 방향, 결과가 벡터

# lapply: 열 방향, 결과가 리스트
lapply(iris[,1:4], mean)

# sapply: 벡터 또는 리스트로 선택 가능
sapply(iris[,1:4], mean) # 벡터
sapply(iris[,1:4], mean, simplify = F) # 리스트

myfunc <- function(x) {
  a <- max(x)
  b <- min(x)
  return(a-b)
}
sapply(iris[,1:4], myfunc) # 최대값 - 최소값


## 사용자 입력값 받기
n <- readline(prompt = "숫자를 입력하세요: ")
cat("입력한 숫자는", n, "입니다. \n")

sink("test.txt", append = T) # 출력할 파일 열기, append=T: 내용 뒤에 이어서 저장
for(i in 1:100) {
  print(i)
}
sink() # 출력할 파일 닫기
scan("test.txt", "")