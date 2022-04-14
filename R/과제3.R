## 1번
install.packages("ggplot2")
library(ggplot2)

ggplot(data=pressure, aes(x=temperature, y=pressure)) + geom_point() # 산점도
cor(pressure$temperature, pressure$pressure) # 상관계수


## 2번
남자 <- c(73.9, 73.1, 74.4, 74.2, 73.5, 73.0, 74.2, 74.5, 73.8, 73.1, 74.5, 74.2)
여자 <- c(51.4, 50.5, 52.4, 52.4, 51.9, 50.9, 52.6, 52.7, 52.2, 51.5, 53.2, 53.1)
data <- rbind(남자, 여자)
colnames(data) <- c(20144, 20151, 20152, 20153, 20154, 20161, 20162, 20163, 20164, 20171, 20172, 20173)

#(1)
par(mar = c(5,5,2,5))
plot(colnames(data), 남자, type="l", lty=1, lwd=1, col=1, xlab="분기") # 남자
par(new = T)
plot(colnames(data), 여자, type="l", lty=2, lwd=1, col=2, axes=F, xlab=NA, ylab=NA) # 여자
axis(side=4)
mtext(side=4, line=3, "여자")
legend("topright", legend=c("남자", "여자"), lty=c(1,2), col=c(1,2))

#(2)
df <- data.frame(남자, 여자)
rownames(df) <- c(20144, 20151, 20152, 20153, 20154, 20161, 20162, 20163, 20164, 20171, 20172, 20173)
ggplot(df) + 
  geom_line(aes(x=rownames(df), y=남자), color='red', size=1, group=1) + 
  geom_line(aes(x=rownames(df), y=여자), color='blue', size=1, group=1)


## 3번
df <- data.frame(table(mtcars$gear))
ggplot(df, aes(x=Var1, y=Freq)) + geom_bar(stat="identity", width=0.7, fill="magenta")


## 4번
#(1)
ggplot() + geom_boxplot(data=iris, aes(x=Species, y=Petal.Width, fill=Species))

#(2)
combn(levels(iris$Species), 2)


## 5번
mymax <- function(x) {
  return(max(x))
}
n <- as.numeric(readLines(n=3))
cat("최대값: ", mymax(n), "\n")


## 6번
result <- 0
num <- 0

for (i in 1:100) {
  if (i %% 3 == 0) {
    result <- result + i
    num <- num + 1
  }
}
cat("합:", result, "\n개수:", num, "\n")


## 7번
for (x in 101:200) {
  if (x%%3==0 & x%%4==0) {
    cat(x, "")
  }
}


## 8번
fib <- function(n) {
  x <- c(0,1)
  while(length(x) < n) {
    new <- x[length(x)-1] + x[length(x)]
    x <- c(x,new)
  }
  return(x)
}

fib(40)


## 9번
maxmin <- function(x) {
  cat("최대값:", max(x), ", 최소값:", min(x))
}
maxmin(c(5,2,6,9,3,1,4))


## 10번
install.packages("mice")
library(mice)
ds <- ampute(iris[,1:4], 0.2)$amp

#(1)
col_na <- function(y) {
  return(sum(is.na(y)))
}
(na_count <- sapply(ds, col_na)) # 열별 결측값 개수

#(2)
ds[!complete.cases(ds),]

#(3)
sum(rowSums(is.na(ds))>0)

#(4)
(ds.new <- ds[complete.cases(ds),])


## 11번
#(1)
st <- data.frame(state.x77)

boxplot(st$Population)$out
boxplot(st$Income)$out
boxplot(st$Illiteracy)$out
boxplot(st$Life.Exp)$out
boxplot(st$Murder)$out
boxplot(st$HS.Grad)$out
boxplot(st$Frost)$out
boxplot(st$Area)$out

# 이상치 벡터 a에 저장
out.val <- vector()
for (i in 1:length(st)) {
  out.val <- c(out.val, boxplot.stats(st[,i])$out)
}
out.val

#(2)
for (i in 1:length(st)) {
  st[,i][st[,i] %in% out.val] <- NA
}
(st2 <- st[complete.cases(st),])

#(3)
head(st[order(st$Illiteracy),], 10)

#(4)
subset(st, Area > st["Alabama","Area"] & Area < st["California","Area"], 
       select = c("Population", "Income", "Area"))

#(5)
(st3 <- cbind(st, state.region))
split(st3, st3$state.region)

#(6)
vars <- c("Population", "Income", "Illiteracy", "Area")
target <- state.x77[,vars]
pairs(target, main="Multi plots") # 산점도
cor(target) # 상관계수

#(7)
ggplot(data=st3, aes(x=Population, y=Area)) + 
  geom_point(aes(color=state.region), alpha=0.5, size=2)

#(8)
for (i in 1:length(st3.split)) {
  print(cor(st3.split[[i]]$Population, st3.split[[i]]$Income))
}

#(9)
st3[order(st3$state.region, st3$Population),]

#(10)
attach(st3)
(agg <- aggregate(st3[,-9], by = list(region=state.region), FUN = mean)) # 평균
(agg <- aggregate(st3[,-9], by = list(region=state.region), FUN = median)) # 중앙값
(agg <- aggregate(st3[,-9], by = list(region=state.region), FUN = sd)) # 표준편차
detach(st3)
