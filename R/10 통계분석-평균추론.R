## 단일 모집단: t.test (모평균, 표본이 크고 정규성 충족 시)
# * 핵심 가정: 정규성(이상점 여부)
# * 분포: T-분포

## 두 모집단: t.test
# * 핵심 가정: 등분산성, 정규성
# * 분포: T-분포

## 세 모집단 이상: lm, aov (ANOVA)
# * 핵심 가정: 등분산성, 정규성
# * 분포: F-분포

setwd("C:/Users/mjkim/Documents/R Projects/R_Study")
auto <- read.csv("imports-85.data", header = F, stringsAsFactors = T)

# 4. 연료 타입: diesel, gas
# 8. drive-wheels(구동): 4wd, fwd, rwd
# 9. 엔진 위치: front, rear
# 17. 엔진 크기: 61~326
# 22. horsepower(마력): 48~288
# 24. city-mpg(시내주행 연비): 13~49
# 25. highway-mpg(고속도로 연비): 16~54
# 26. 가격: 5118~45400

# city-mpg(V24)의 평균에 대한 신뢰구간 -> 히스토그램으로 정규성 검정
hist(auto$V24)

attach(auto) # 경로에 추가
hist(V24)
(V24 <- log(V24)) # V24와 auto$V24는 별개
auto$V24[1:10]
V24[1:10]
detach(auto) # 경로 해제

(V24 <- auto$V24)

# 단일 모집단 분포의 정규성을 검정하는 방법
# * shapiro.test (샤피로 윌크 검정): 표본이 정규분포로부터 추출되었는가 : p-value < 0.05면 정규분포 따른다는 귀무가설 기각
# * qqnorm (분위수-분위수 그림)
shapiro.test(V24) # H0 기각 -> 정규성 만족 X
qqnorm(V24) # 분위수-분위수 그림
qqline(V24) # 대각선 qqline()을 기준으로 산점도 점들이 가깝게 선형을 이루며 붙어있으면 정규성을 띔
boxplot(V24) # 이상점 존재
hist(V24) # 히스토그램

# 다른 정보가 없는 경우: 변환, 비모수적 방법
(LV24 <- log(V24))
hist(LV24)
qqnorm(LV24); qqline(LV24)
boxplot(LV24) # 이상점 없음
shapiro.test(LV24) # H0 기각


## 가설검정
ru = t.test(LV24, mu=log(25), alternative = "greater") # 평균이 25보다 큰가? -> H0 기각 불가
ru
str(ru)

# 시내주행 연비, 고속도로 연비의 기하평균 신뢰구간
# (자료의 곱)^(1/표본크기) = n제곱근 = exp(mean(log(자료)))
geotest <- function(x, cl=0.95) {
  logx <- log(x)
  result <- t.test(logx, conf.level=cl)
  결과 <- exp(c(result[[4]][1], result[[5]], result[[4]][2]))
  names(결과) <- c("하한", "기하평균", "상한")
  return(결과)
}
geotest(V24)
geotest(auto$V25)

sapply(auto[c(24,25)], geotest)
lapply(auto[c(24,25)], geotest, 0.99) # 신뢰수준 99%

# 고속도로 연비(V25)에 대해 95% 신뢰구간과 평균이 25인지에 대한 가설검정
hist(auto$V25)
shapiro.test(V25) # H0 기각 -> 정규성 만족 X
qqnorm(V25); qqline(V25)
boxplot(V25) # 이상점 존재

LV25 <- log(V25)
hist(LV25)
qqnorm(LV25); qqline(LV25)
boxplot(LV25) # 이상점 존재
shapiro.test(LV25) # H0 기각x -> 정규성 만족

ru25 = t.test(LV25, mu=log(25), alternative = "two.sided") # 평균이 25인가? -> H0 기각 -> 평균 25라고 할 수 없음
ru25
str(ru25)

averageTest <- function(x, cl=0.95) {
  result <- t.test(log(x), conf.level=cl)
  결과 <- exp(c(result[[4]][1], result[[4]][2]))
  names(결과) <- c("하한", "상한")
  return(결과)
}
averageTest(LV25) # (3.362705, 3.424940)



## 두 모집단 평균 비교: 독립표본
auto <- read.csv("imports-85.data", header=F, stringsAsFactors = T, na.strings = "?") # "?" 결측값으로 처리
str(auto)

# 디젤과 가솔린 엔진 차량의 가격 비교
# 연료 타입: V4, 가격: V26 -> 반응(V26)~그룹(V4)
boxplot(V26~V4, horizontal = T, data = auto) # 이상값 존재

# 비대칭, 휘발유차량 이상점
boxplot(log(V26)~V4, horizontal = T, data = auto) # 이상값 없어짐, 정규성 만족
auto$LV26 <- log(auto$V26) # 새 변수 지정 (로그 취한 값)
auto = within(auto, LV26 <- log(V26)) # 위와 같은 명령어

# 정규성
with(auto, tapply(LV26, V4, shapiro.test)) # 디젤: 정규성 만족(기각 불가), 가스: 정규성 불만족(기각)

#등분산성
var.test(LV26~V4, data=auto) # p-value = 0.9628 -> 기각 불가(등분산성 만족)

# Independent t-test
t.test(LV26~V4, var.eq=T, data=auto) # p-value = 0.05152 -> 기각 불가(평균 차이 X)

(결과 <- t.test(LV26~V4, var.eq=T, data=auto)) # 리스트 형식
exp(결과$estimate) # 디젤, 휘발유 차량의 기하평균
exp(결과$conf.int) # 기하평균의 비에 대한 신뢰구간

# 다른 입력방식
X <- auto$LV26[auto$V4=="diesel"]
Y <- auto$LV26[auto$V4=="gas"]
t.test(X,Y, var.eq=T, alternative = "greater") # p-value = 0.02576 -> 기각(디젤차 가격 > 가스차 가격)

# 연료타입에 따라 고속도로 연비에 차이가 있는가?
(a = var.test(V25~V4, data=auto)) # p-value = 0.06866 -> 기각 불가(등분산성 만족)
(b = t.test(V25~V4, var.eq=T, data=auto)) # p-value = 0.005977 -> 기각(차이 있음)
# * 같은 데이터프레임에 있을 필요 X, 길이는 같아야 함
vv25 = auto$V25
(b = t.test(vv25~V4, var.eq=T, data=auto)) # 동일한 결과

vv4 <- auto$V4 # 연료 타입
ttest <- function(x) {
  result.var <- var.test(x~vv4)
  if(result.var$p.value > 0.05) # 등분산성 만족하면
    result <- t.test(x~vv4, var.eq=T)
  else # 등분산성 불만족
    result <- t.test(x~vv4)
  output <- c(result[[1]], result[[2]], result[[3]], result[[5]], result$conf.int)
  return(round(output, 4)) # 소수점 네 자리 수
}

Result <- sapply(auto[c(24,25,26)], ttest)
rownames(Result) <- c("검정통계량", "자유도", "p-값", "디젤평균", "휘발유평균", "신뢰하한", "신뢰상한")
colnames(Result) <- c("시내연비", "고속도로연비", "가격")
Result


## 엔진크기(V17: (61~326) => 150 이하, 초과로 나눔)에 따른 디젤과 가솔린(V4) 엔진 연비(V24) 비교
C17 <- cut(auto$V17, breaks = c(60,150,326), labels = c("G1", "G2")) # (,]
table(auto$V4, C17)

ttest <- function(x){
  t.test(x~vv4, var.eq=T) # length(vv4)=205
}
tapply(auto$V24, C17, ttest) # Error: 변수의 길이 다름
tapply(iris$Sepal.Length, iris$Species, mean)  

ttest24 <- function(dfrm){
  t.test(V24~V4, var.eq=T, data=dfrm) # V24와 V4 길이 같음
}
by(auto, C17, ttest24) # G1, G2일 때 모두 차이 있음

ttest <- function(dfrm, choice=c(24,4)) {
  t.test(dfrm[[choice[1]]]~dfrm[[choice[2]]], var.eq=T)
}
by(auto, C17, ttest) # V24~V4
by(auto, C17, ttest, c(26,4)) # V26~V4 -> G1, G2일 때 모두 기각 불가(차이 없음)


# 짝표본

## 시내주행 연비(V24)와 고속도로 주행연비(V25) 차이가 5M보다 큰지? (같은 자동차-짝표본)
## 동일 자동차끼리 맵핑
with(auto, boxplot(V24, V25, names=c("시내", "고속도로"))) # 이상점 존재
auto$LD <- auto$V25 - auto$V24 # 차
with(auto, boxplot(LD)) # 이상점 존재

t.test(auto$LD, mu=5, alternative = "greater") # 기각 -> 차이가 5M보다 크다
t.test(auto$V25, auto$V24, mu=5, alternative = "greater", paired = T, data=auto) # 같은 결과
