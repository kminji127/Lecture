setwd("C:/Users/mjkim/Documents/R Projects/R_Study")

# 산점도: plot()
iris.2 <- iris[,3:4]
point <- as.numeric(iris$Species) # setosa:1, versicolor:2, virginica:3로 변환됨
color <- c("red", "green", "blue")
plot(iris.2, main="Iris Plot", pch=c(point), col=color[point])
plot(iris$Petal.Length, iris$Petal.Width, pch=16, col=as.integer(iris$Species))


# 상관분석
vars <- c("mpg", "disp", "drat", "wt") # 대상 변수수
target <- mtcars[,vars]
pairs(target, main="Multi Plots") # pairs(): 변수들 간의 상관관계

beers = c(5,2,9,8,3,7,3,5,3,5)
bal= c(0.1, 0.03, 0.19, 0.12, 0.04, 0.095, 0.07, 0.06, 0.02, 0.05)
tbl = data.frame(cbind(beers, bal))
plot(bal~beers, data=tbl) # 또는 plot(tbl)
res = lm(bal~beers, data=tbl) # 회귀식
abline(res) # 회귀선
cor(beers, bal) # 상관계수
cor(iris[,1:4]) # 4개 변수 간 상관계수


# 선 그래프
month = 1:12
late = c(5,8,7,9,4,6,12,13,8,6,6,4)
plot(month, late, main="지각생", type="l", lty=1, lwd=1, xlab="월", ylab="지각 횟수")

# 한 plot에 그림 여러 개 그리기 (시계열 자료에서 설명)
birth <- scan("birth.txt")
marrige <- scan("marriage.txt")
plot(birth)

# ts(데이터, frequency=간격, start=시작일)
## 1: 연단위, 12: 월단위, 4: 쿼터 단위
birth <- ts(birth, start = 1981, frequency = 1)
marrige <- ts(marrige, start = 1981, frequency = 1)

plot(birth)
par(new = T) # 그래프 겹치기
plot(marrige, col = "red")

par(mar = c(5,5,2,5))
plot(birth, ylab="출생아수", xlab="연도")
par(new = T)
plot(marrige, col="red", axes=F, xlab=NA, ylab=NA) # 축 만들지 않음
axis(side=4) # 우측에 축 생성
mtext(side=4, line=2, "혼인건수") # label 생성
legend("topright", legend=c("출생아수", "혼인건수"), lty=c(1,1), col=c(1,2))


# 참고: 색상 표시
cols <- colors()
length(cols) # 657
head(cols); tail(cols)
col2rgb("red") # RGB값

clr.1 <- c("#000000", "#FF0000", "#00FF00", "#0000FF")
clr.2 <- c("#00FFFF", "#FF00FF", "#FFFF00", "#FFFFFF")
par(mar=rep(3,4), mfrow=c(2,1))
barplot(rep(1,4), col=clr.1, axes=F, main="black, red, green, blue")
barplot(rep(1,4), col=clr.2, axes=F, main="cyan, magenta, yellow, white")

# ramp(sequence) of colors
pal.1 <- colorRampPalette(c("white", "black"))
clr.1 <- pal.1(7) # white~black 사이의 7개 색깔 추출
pal.2 <- colorRampPalette(c("red", "green"))
clr.2 <- pal.2(7)

par(mar=rep(3,4), mfrow=c(2,1))
barplot(rep(1,length(clr.1)), col=clr.1, axes=F, main="from white to black")
barplot(rep(1,length(clr.2)), col=clr.2, axes=F, main="from red to green")


## 패키지 설치
install.packages("ggplot2")
library(ggplot2) # 작업공간에 불러오기 (또는 체크)

# 단일 그래프
ggplot(data=iris, aes(x=Petal.Length, y=Petal.Width)) + geom_point() # 산점도

# 다중 그래프 중첩
ggplot() + geom_point(data=iris, aes(x=Petal.Length, y=Petal.Width), 
                      color="red", size=4)
ggplot(data=iris, aes(x=Petal.Length, y=Petal.Width)) + 
  geom_point(aes(color=Species, shape=Species), alpha=0.5, size=2)

gp <- ggplot(data=iris, aes(x=Petal.Length, y=Petal.Width)) + 
  geom_point(aes(color=Species, shape=Species), alpha=0.5, size=2)
gp + ggtitle("IRIS data") + theme(plot.title=element_text(size=14, face="bold", color="blue", hjust=0.5)) # theme(): 제목 속성

ggplot(mtcars, aes(x=wt, y=mpg)) + geom_line(color='red', size=1) # 선 그래프

df = data.frame(table(mtcars$carb))
ggplot(df, aes(x=Var1, y=Freq)) + geom_bar(stat="identity", width=0.7, fill="steelblue") # 막대 그래프

gb <- ggplot() + geom_boxplot(data=iris, aes(x=Species, y=Petal.Length, fill=Species)) # 박스 플롯
gb
gb + coord_flip() # 축 변환

# 요인별 쪼개기
gb + facet_grid(.~Species) # 열
gb + facet_grid(Species~.) # 행
gb + facet_wrap(.~Species, nrow=2) # 2행 2열


# mtcars 기어수별 도수(빈도)에 대해 ggplot으로 막대 그래프
df <- data.frame(table(mtcars$gear))
ggplot(df, aes(x=Var1, y=Freq)) + geom_bar(stat="identity", width=0.7, fill="magenta")
