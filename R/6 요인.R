setwd("C:/Users/mjkim/Documents/R Projects/R_Study")

# factor 생성
x <- rnorm(30)
bd <- -3:3
범주화 <- cut(x, breaks = bd)
class(범주화)
x; 범주화

# 데이터프레임 생성
# * default: 문자열은 factor(3.x 이전), character(4.x 이후)
Data1 <- read.csv("Employee.csv")
str(Data1)
Data1$gender[1:10]

Data2 <- read.csv("Employee.csv", stringsAsFactors = T)
str(Data2)
Data2$gender[1:10]


# factor 생성함수
x <- gl(4,3)
x
levels(x) <- c("A", "B", "C", "D")
x

# factor 변환함수
(x <- rep(c("A", "B", "C", "D"), 5))
(x1 <- as.factor(x))
(y <- rep(1:4, 5))
(y1 <- as.factor(y))

# factor인지 확인
is.factor(y) # FALSE
is.factor(y1) # TRUE


# factor의 자료형
class(Data2$gender) # "factor"
mode(Data2$gender) # "numeric" 수치형
typeof(Data2$gender) # "integer" 정수형: level의 값
(xx <- c(x1, y1))
class(xx) # "integer"
is.factor(xx) # FALSE


# factor 참조와 Level 제거
# * 범주형이므로 같다, 다르다만 비교 가능
x <- rep(c("A", "B", "C", "D"), 5)
(x1 <- as.factor(x))
y <- rep(1:4, 5)
(y1 <- as.factor(y))

x1[1:5]
x1 == "A"
y1 =="1"
x1 == A # Error
y1 == 1

Data1$gender[1:10] < "여성" # 문자
Data2$gender[1:10] < "여성" # factor -> Error

# Levels 확인
(x3 <- x1[x1 != "D"])
(y3 <- y1[y1 != 4]) # (y3 <- y1[y1 != "4"])

# Level 제거
x3[,drop=T]
y3[,drop=T]

# 결측값 제거
(x4 <- factor(x, levels = c("A", "B", "C"))) # D는 결측값으로 표시
(y4 <- factor(y, levels = 1:3)) # 4는 결측값으로 표시
x4[!is.na(x4)]
y4[!is.na(y4)]


# factor의 활용
temp1 <- Data1[Data1$jobcat != "사무직",]
temp2 <- Data2[Data2$jobcat != "사무직",]
temp1$jobcat # 문자열
temp2$jobcat # factor
table(temp1$jobcat) # 범주 2개 (사무직 X)
table(temp2$jobcat) # Level 3개 (사무직 O)

boxplot(Data1$salary)
boxplot(Data1$salary~Data1$jobcat) # 직업별
boxplot(salary~jobcat, data=Data1) # 위와 동일
boxplot(salary~jobcat, data=Data2) # 위와 동일
boxplot(salary~jobcat, data=temp1) # 사무직 X
boxplot(salary~jobcat, data=temp2) # 사무직 O

# factor을 벡터로
class(x1)
as.character(x1)
(yy = as.character(y1))
class(yy) # "character"
as.numeric(y1)
as.numeric(x1) # factor는 정수형
