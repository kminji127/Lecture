# 문제 1
Empy <- read.csv("Employee.csv", stringsAsFactors = T)
boxplot(Empy$salbegin) # 이상점 존재
# 1.1
#(1)
t.test(Empy$salbegin, mu=16000, alternative = "two.sided") # 평균이 16000인가? -> 귀무가설 기각 -> 16000이라고 볼 수 없다

averageTest <- function(x, cl=0.95) {
  result <- t.test(log(x), conf.level=cl)
  결과 <- exp(c(result[[4]][1], result[[4]][2]))
  names(결과) <- c("하한", "상한")
  return(결과)
}
averageTest(Empy$salbegin)

#(2)
var.test(log(Empy$salbegin)~Empy$gender, data=Empy) # 귀무가설 기각 -> 등분산성 불만족
t.test(log(Empy$salbegin)~Empy$gender, var.eq=F, data=Empy) # 귀무가설 기각 -> 평균 다름

#(3)
with(Empy, boxplot(log(salbegin), log(salary), names=c("초봉", "연봉"))) # 이상점 존재
var.test(log(Empy$salbegin), log(Empy$salary)) # 귀무가설 기각 -> 등분산성 불만족
t.test(log(Empy$salbegin), log(Empy$salary), mu=0, alternative = "two.sided", var.eq=F, paired = T, data=Empy) # 평균이 같다는 귀무가설 기각 -> 평균 다름

# 1.2
out_salbegin <- boxplot.stats(Empy$salbegin)$out
out_salary <- boxplot.stats(Empy$salary)$out
Empy$salbegin[Empy$salbegin %in% out_salbegin] = NA # 이상치 NA 처리
Empy$salary[Empy$salary %in% out_salary] = NA # 이상치 NA 처리
newEmpy <- Empy[complete.cases(Empy),] # 결측치 없는 행 -> 이상치 삭제
#(1)
t.test(newEmpy$salbegin, mu=16000, alternative = "two.sided") # 평균이 16000인가? -> 귀무가설 기각 -> 16000이라고 볼 수 없다

#(2)
var.test(log(newEmpy$salbegin)~newEmpy$gender, data=newEmpy) # 귀무가설 기각 -> 등분산성 불만족
t.test(log(newEmpy$salbegin)~newEmpy$gender, var.eq=F, data=newEmpy) # 귀무가설 기각 -> 평균 다름


#(3)
with(newEmpy, boxplot(log(salbegin), log(salary), names=c("초봉", "연봉"))) # 이상점 존재
var.test(log(newEmpy$salbegin), log(newEmpy$salary)) # 귀무가설 기각 -> 등분산성 불만족
t.test(log(newEmpy$salbegin), log(newEmpy$salary), mu=0, alternative = "two.sided", var.eq=F, paired = T, data=newEmpy) # 평균이 같다는 귀무가설 기각 -> 평균 다름



# 문제 2
auto <- read.csv("imports-85.data", header=F, stringsAsFactors = T, na.strings = "?")
auto <- subset(auto, V8 != "fwd") # engine_wheels(V8)이 fwd(전륜구동)인 경우 자료에서 제거
boxplot(V26~V8, horizontal = T, data = auto) # 이상점 존재
boxplot(log(V26)~V8, horizontal = T, data = auto) # 로그 변환 -> 이상점 x

#(1)
with(auto, tapply(log(V26), V8, shapiro.test)) # 4wd, rwd 모두 정규성 만족
bartlett.test(log(V26)~V8, data=auto) # 귀무가설 기각 불가 -> 등분산성 만족
m = aov(log(auto$V26) ~ auto$V8)
summary(m) # 유의확률 Pr(>F)=0.000305 -> 귀무가설 기각 -> 가격 차이 있음

#(2)
TukeyHSD(m) # 튜키 방법: p adj=0.000305 -> 유의한 평균 차이
by(auto$V26, auto$V8, mean, na.rm=T) # 평균 비교

ttest <- function(x) {
  result.var <- var.test(x~auto$V8)
  if(result.var$p.value > 0.05) # 등분산성 만족하면
    result <- t.test(x~auto$V8, var.eq=T)
  else # 등분산성 불만족
    result <- t.test(x~auto$V8)
  output <- c(result[[5]], result$conf.int)
  return(output)
}
Result <- ttest(auto$V26)
names(Result) <- c("4wd 평균", "rwd 평균", "신뢰하한", "신뢰상한")
Result


# 문제 3
Empy <- read.csv("Employee.csv", stringsAsFactors = T)
#(1)
boxplot(salary~jobcat, horizontal = T, data = Empy) # 이상점 존재 -> 로그 취함
with(Empy, tapply(log(salary), jobcat, shapiro.test)) # 경영자: 정규성 만족, 나머지: 정규성 불만족
bartlett.test(log(salary)~jobcat, data=Empy) # 기각 -> 등분산성 불만족
m = aov(log(Empy$salary) ~ Empy$jobcat)
summary(m) # 유의확률 Pr(>F): 2e-16 *** -> 귀무가설 기각 -> 직종 간 연봉 차이 있음

pairwise.t.test(log(Empy$salary), Empy$jobcat) # 2개씩 짝지어 확인
pairwise.t.test(log(Empy$salary), Empy$jobcat, p.adj="bonf") # 본페로니 방법

#(2)
boxplot(salbegin~jobcat, horizontal = T, data = Empy) # 이상점 존재 -> 로그 취함
with(Empy, tapply(log(salbegin), jobcat, shapiro.test)) # 경영자: 정규성 만족, 나머지: 정규성 불만족
bartlett.test(log(salbegin)~jobcat, data=Empy) # 귀무가설 기각 -> 등분산성 불만족
m = aov(log(Empy$salbegin) ~ Empy$jobcat)
summary(m) # 유의확률 Pr(>F): 2e-16 *** -> 귀무가설 기각 -> 직종 간 초봉 차이 있음

pairwise.t.test(log(Empy$salbegin), Empy$jobcat) # 2개씩 짝지어 확인 -> 사무직-관리직 제외 전부 차이 있음
pairwise.t.test(log(Empy$salbegin), Empy$jobcat, p.adj="bonf") # 본페로니 방법

#(3)
aaov <- function(dfrm, choice=c(6,3)) {
  m = aov(dfrm[[choice[1]]]~dfrm[[choice[2]]])
  summary(m)
}
by(Empy, Empy$gender, aaov) # 남자, 여자 모두 귀무가설 기각 -> 직종 간 초봉 차이 있음

# 문제 4
#(1)
with(iris, tapply(Sepal.Length, Species, shapiro.test)) # 모든 종 정규성 만족
with(iris, tapply(Petal.Width, Species, shapiro.test)) # setosa 제외 정규성 만족
bartlett.test(Sepal.Length~Species, data=iris) # 귀무가설 기각 -> 등분산성 불만족
bartlett.test(Petal.Width~Species, data=iris) # 귀무가설 기각 -> 등분산성 불만족

m1 = aov(iris$Sepal.Length~iris$Species)
summary(m1) # 유의확률 Pr(>F): 2e-16 -> 귀무가설 기각 -> 품종에 따라 Sepal.Length 차이 있음

m2 = aov(iris$Petal.Width~iris$Species)
summary(m2) # 유의확률 Pr(>F): 2e-16 -> 귀무가설 기각 -> 품종에 따라 Petal.Width 차이 있음

#(2)
(lm_out = lm(Sepal.Length~Petal.Length, data=iris))
summary(lm_out)

par(mfrow=c(2,2))
plot(lm_out)

#(3)
predict(lm_out, newdata = data.frame(Petal.Length=5))

#(4)
ggplot(iris, aes(Petal.Length, Sepal.Length)) + geom_point() + 
  stat_smooth(method = 'lm', color='black') +
  geom_text(x=21, y=25, label="Sepal.Length = -4.3066 + 0.4089 Petal.Length", size=5, color="blue")

#(5)
ggplot(iris, aes(x = Petal.Length, y = Sepal.Length)) +
  geom_point(aes(color = Species)) +
  geom_smooth(method = 'lm') +
  facet_wrap(~Species) +
  scale_color_brewer(palette = 'Set1')
