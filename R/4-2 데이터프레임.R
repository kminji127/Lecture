# 데이터프레임 생성: read.csv(), read.table()
data1 <- read.csv("Employee.csv")
str(data1)
head(data1)

colnames(data1) # = names(data1)
colnames(data1)[2] # 2번째 위치의 변수명
rownames(data1)[1:10] # 1:10번째 행이름


# 데이터프레임으로 변환: as.data.frame(), data.frame()
# 1. 리스트 -> 데이터프레임 변환
temp <- scan("data3.txt", what = list("","",0), skip = 1, fileEncoding = "UTF-8")
str(temp)
data2 <- as.data.frame(temp) # = data.frame(temp)
colnames(data2) <- c("gender", "jobcat", "salary") # 변수명 지정 / colnames 대신 names도 가능
str(data2)

# 2. 벡터 -> 데이터프레임 변환
x1 <- c(rnorm(10), rnorm(10,1), rnorm(10,2)) # 난수 30개 생성
x2 <- rep(c("A", "B", "C"), each=10)
data3 <- data.frame(x1, x2)
head(data3)
str(data3)

data4 <- data.frame(Y=x1, X=x2) # 변수명 지정
head(data4)
nrow(data4) # 행의 개수
ncol(data4) # 열의 개수 = length(data4)


# 데이터프레임에 자료 추가: data$새변수명 <- 벡터
x3 <- rep(c("A", "B", "C"), 5)
x4 <- rep(c("A", "B", "C"), 4)
length(x3); length(x4)
tempData <- data.frame(x1, x2, x3) # = data4$x3 <- x3
tempData <- data4$x4 <- x4 # 30은 12 배수 아님 -> Error


# 데이터프레임 참조
# 1. $: 값만
head(data1$salary)
class(data1$salary) # numeric
data1$salary[1:10] # salary 변수의 1:10번 값

# 2. []: 변수 + 값
head(data1[5])
class(data1[5]) # data.frame
head(data1[c(3,5)])

# 3. [[]]: 값만
head(data1[[5]])
class(data1[[5]]) # numeric

# 4. 행렬 형태
data1[,5] # = data1$salary (numeric)
data1[1:10,5] # = data1$salary[1:10] (numeric)

head(data1[c(5,6)]) # 5,6번째 변수 + 값 (data.frame)
head(data1[,c(5,6)])
head(data1[c("salary", "salbegin")])
head(data1[,c("salary", "salbegin")])

data1[[c(5,6)]] # 5번째 변수의 6번째 자료


# 논리연산, subset()
# * 변수(열) 선택
Empy <- read.csv("Employee.csv")
head(Empy)

test <- Empy[c(2,4,5)] # 2,4,5열
head(test)

test2 <- Empy[c('gender', 'jobcat')]
head(test2)

# * 관측값(행) 선택
ck <- seq(1, nrow(Empy), by=2) # 1부터 474까지 2 간격
test <- Empy[ck,] # ck 행 선택 : 1,3,...,473
head(test)

# * salary가 50000 이상인 자료
test <- Empy[Empy$salary >= 50000,]
head(test)

# * salary가 50000 이상이고 jobtime이 90 미만인 자료
test <- with(Empy, Empy[salary >= 50000 & jobtime < 90,])
head(test)

# 함수를 이용하는 방법
# * 변수 선택
test <- subset(Empy, select = c(5,4,2))
head(test)

# * 관측 개체 선택
test <- subset(Empy, subset = (salary>50000 & jobtime<90))
head(test)
test <- subset(Empy, subset = ck) # 논리형이 아니므로 에러 발생


# 데이터프레임 병합: rbind, cbind, merge
# 1. 열(좌우)병합 - 행 개수 동일해야 함
Empy$LogSal <- log(Empy$salary)
head(Empy)

Data1 <- Empy[c(1,2,3)]
Data2 <- Empy[c(4,5)]
names(Data2)[1] <- c("educ") # 변수명 동일해도 병합 가능
Data <- cbind(Data1, Data2)
str(Data);head(Data)

Data <- data.frame(Data) # 데이터프레임으로 변환
str(Data) # 동일한 변수에 .숫자 추가됨

# 2. 행(상하)병합 - 변수명 동일해야 함
Data1 <- Empy[1:100, c(1,2,3)]
Data2 <- Empy[400:nrow(Empy), c(3,2,1)]
head(Data1);head(Data2)

Data <- rbind(Data1, Data2) # Data1 먼저
head(Data)
Data <- rbind(Data2, Data1) # Data2 먼저
head(Data)

# 3. merge - 행, 열 다를 때
Data1 <- Empy[1:20, c(1,2,3)]
Data2 <- Empy[10:35, c(1,4,5,6)]
head(Data1); head(Data2)

merge(Data1, Data2, by="id") # id 기준 병합 (공통된 id 값들만 출력)
merge(Data1, Data2, by="id", all.x=T) # Data1의 결측값 포함
merge(Data1, Data2, by="id", all.y=T) # Data2의 결측값 포함
Data <- merge(Data1, Data2, by="id", all=T) # 둘다 결측값 포함
Data

names(Data2)[1] <- "id2"
merge(Data1, Data2, by.x="id", by.y="id2") # 기준 변수명 다를 때

order(Data2$salary) # 정렬(작은 순서대로 위차값)
Data2 <- Data2[order(Data2$salary),] # 오름차순 정렬
head(Data2)
Data2 <- Data2[order(-Data2$salary),] # 내림차순 정렬
head(Data2)


# 데이터프레임 함수
# * 벡터 또는 행렬 함수 이용 가능
# * colMeans, colSums, rowMeans, rowSums, var, cov, cor, plot
Empy <- read.csv("Employee.csv")
# * 벡터 함수
mean(Empy$salary)
mean(Empy[[5]])
mean(Empy[,5])
# * 데이터프레임 (벡터 함수 x)
mean(Empy[5]) # Error
sd(Empy[5]) # Error
var(Empy[5]) # 적용 가능

numData <- Empy[-c(2,4,9)] # 숫자형 벡터만
head(numData)
colMeans(numData) # 열 기준 평균값
rowMeans(numData) # 행 기준 평균값
var(numData) # 분산
cov(numData) # 공분산
cor(numData) # 상관계수 [-1,1]
plot(numData) # 산점도


# R에서 제공하는 데이터 리스트
data()

# state.x77 데이터 확인
state.x77
View(state.x77)
head(state.x77)

iris
str(iris)
iris[1:10,]
ncol(iris)
nrow(iris)
iris[iris$Species=="setosa",]
subset(iris, subset = Petal.Length >= 1.5)
iris[-(1:100),c(2,4)]
data <- rnorm(50)
data.group <- cut(data, breaks = -3:3)
hist(data, breaks=-3:3)
(data.tbl <- table(data.group))
names(data.tbl) <- c("G1", "G2", "G3", "G4", "G5", "G6")
data.tbl
data.group <- cut(data, breaks=-3:3, labels=c("G1", "G2", "G3", "G4", "G5", "G6"))
(data.tbl <- table(data.group))
(data.prop <- prop.table(data.tbl))
(data.csum <- cumsum(data.prop))
data.freq <- cbind(data.tbl, 100*data.prop, 100*data.csum)
x1<- c("a", "b", "c", "d")
x2 <- c(1,2,3,4)
(a <- data.frame(x1=x1, x2=x2))

x2 <- c("a", "b", "c", "d", "e", "f")
x3 <- c(6,5,4,3,2,1)
(b <- data.frame(x2=x2, x3=x3))

merge(a,b, by.x=names(a), by.y = names(b), all.y=T)
