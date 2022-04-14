## 결측값
x <- c(1,2,3,NA,5,NA,8)
sum(x) # NA (오류)
sum(x, na.rm = T) # 결측값 제외
is.na(x) # NA는 TRUE(1), 나머지는 FALSE(0) 반환
sum(is.na(x)) # NA 개수
x[is.na(x)] <- 0 # NA를 0으로 치환
x

x <- c(1,2,3,NA,5,8)
(y <- as.vector(na.omit(x))) # NA 제거

x <- iris
x[1,2] <- NA; x[1,3] <- NA
x[2,3] <- NA; x[3,4] <- NA
head(x) # NA 포함하는 데이터프레임

col_na <- function(y) {
  return(sum(is.na(y)))
}
(na_count <- sapply(x, col_na)) # 열별 결측값 개수

is.na(x)
rowSums(is.na(x)) # 행별 NA 개수
sum(rowSums(is.na(x))>0) # NA가 포함된 행의 개수

head(x)
# complete.cases(): 결측치가 없으면 TRUE, 있으면 FALSE (is.na 반대)
x[!complete.cases(x),] # 결측치 있는 행
y <- x[complete.cases(x),] # 결측치 없는 행
head(y)


## 이상치
st <- data.frame(state.x77)
boxplot(st$Income)
boxplot(st$Income)$out # 이상치

out.val <- boxplot.stats(st$Income)$out
st$Income[st$Income %in% out.val] = NA # 이상치 NA 처리
st$Income
newdata <- st[complete.cases(st),] # 결측치 없는 행
head(newdata$Income)


## 정렬
v1 <- c(1,7,6,8,4,2,3)
order(v1) # 값 순서
(v1 <- sort(v1)) # 오름차순
(v1 <- sort(v1, decreasing = T)) # 내림차순

order(iris$Sepal.Length)
iris[order(iris$Sepal.Length),] # 특정 행 오름차순 정렬
iris[order(iris$Sepal.Length, decreasing = T),] # 특정 행 내림차순 정렬
iris[order(iris$Species, iris$Sepal.Length),] # 품종 별 정리 -> 각각 오름차순

v3 <- c(1,7,2,5)
order(v3) # v3을 정렬할 때 뽑을 순서 (1,2,5,7의 위치)
rank(v3) # v3에서 현재 값의 순위


## 분리(split)
(Sp <- split(iris, iris$Species))
summary(Sp)
class(Sp) # list
Sp$setosa


## 추출
subset(iris, Species == "setosa")
subset(iris, Sepal.Length > 5.1)
subset(iris, Sepal.Length > 5.1 & Sepal.Width > 3.9)
subset(iris, Sepal.Length > 5.1, select = c(Petal.Length, Petal.Width)) # 변수 선택

x <- c(3,1,7,8,5,9,4)
which(x>5) # 5보다 큰 값의 위치 (3 4 6)
which(iris$Species == "setosa") # 1:50
which.max(iris$Sepal.Length) # 최대값 위치
which.min(iris$Sepal.Width) # 최소값 위치

x <- 1:100
# x에서 10개의 수를 임의로 비복원추출(기본값)
y <- sample(x, size = 10, replace = FALSE) # replace=T : 복원추출
y

idx <- sample(nrow(iris), size=50) # 50개의 행 비복원추출
iris.50 <- iris[idx,]
head(iris.50)

# 조합(combination)
combn(5,3) # 5개 중 3개를 뽑는 조합
x = c("red", "green", "blue", "black", "white")
(com <- combn(x,2)) # x의 원소를 2개씩 뽑는 조합
for (i in 1:ncol(com)) { # 1:10
  cat(com[,i], "\n")
}


## 데이터 요약(aggregate)
# 기준 변수(컬럼)에 따라 집계

# iris에서 각 품종별로 꽃받침의 폭과 길이의 평균
(agg <- aggregate(iris[,-5], by = list(iris$Species), FUN = mean))

# mtcars에서 cyl, vs를 기준으로 다른 컬럼들의 최대값
head(mtcars)
(agg <- aggregate(mtcars, by = list(mtcars$cyl, mtcars$vs), FUN = max))
# Group.1 = cyl, Group.2 = vs
(agg <- aggregate(mtcars, by = list(cyl=mtcars$cyl, vs=mtcars$vs), FUN = max))

attach(mtcars) # 앞으로 명령어의 기준은 mtcars
(agg <- aggregate(mtcars, by = list(cyl, vs), FUN = max))
detach(mtcars) # attach 해제
