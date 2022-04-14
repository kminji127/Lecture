## 세 모집단 이상: lm, aov (ANOVA)
# * 핵심 가정: 등분산성, 정규성
# * 분포: F-분포
# https://mansoostat.tistory.com/48


## 자동차 구동(V8)에 따라 마력(V22) 비교
auto <- read.csv("imports-85.data", header=F, stringsAsFactors = T, na.strings = "?")
boxplot(V22~V8, horizontal = T, data = auto) # 이상점 존재
boxplot(log(V22)~V8, horizontal = T, data = auto)
LV22 <- log(auto$V22)

# 정규성
with(auto, tapply(LV22, V8, shapiro.test)) # fwd 정규성 불만족

QQ_plot = function(x) { # 다른 방법
  qqnorm(x)
  qqline(x)
}
par(mfrow=c(1,3)) # partition 분리
by(LV22, auto$V8, QQ_plot)
tapply(LV22, auto$V8, QQ_plot)

# 등분산성
bartlett.test(LV22~V8, data=auto) # 기각 불가(등분산성 만족)

install.packages("car") # 다른 방법
library(car)
leveneTest(LV22~auto$V8) # Pr(>F): 0.6337

# 분산분석 실시
(m = aov(LV22 ~ auto$V8))
summary(m) # 분산분석표 : 유의확률 Pr(>F): 2e-16 *** -> 0.001로 기각 가능

# (귀무가설 기각 시) 사후검정
TukeyHSD(m) # 튜키 방법: p adj < 0.05면 유의한 평균 차이
by(LV22, auto$V8, mean, na.rm=T) # 평균 비교

pairwise.t.test(LV22, auto$V8) # 2개씩 짝지어 확인
pairwise.t.test(LV22, auto$V8, p.adj="bonf") # 본페로니 방법

install.packages("agricolae") # agricolae
library(agricolae)
(aa = LSD.test(m, "auto$V8", p.adj="bonf", group=F))

install.packages("DescTools") # DescTools
library("DescTools")
PostHocTest(m, method = "lsd")
 # method: bonferroni, hsd, scheffe


## 엔진크기(V17: (61~326) => 150 이하, 초과로 나눔)에 따른 구동(V8)에 따라 마력(V22) 비교
C17 <- cut(auto$V17, breaks = c(60,150,326), labels = c("G1", "G2")) # (,]
table(auto$V8, C17)

aaov <- function(dfrm, choice=c(22,8)) {
  m = aov(dfrm[[choice[1]]]~dfrm[[choice[2]]])
  summary(m)
}
by(auto, C17, aaov) # G1, G2 기각 가능
by(auto, C17, aaov, c(26,8)) # 구동에 따라 가격 차이 있음

# 사후검정 방법 1
aaov1 <- function(dfrm, choice=c(22,8)) {
  m = aov(dfrm[[choice[1]]]~dfrm[[choice[2]]])
  anova_m = summary(m)
  port_test = LSD.test(m, "dfrm[[choice[2]]]", p.adj="bonf", group=F)
  return = c(anova_m, port_test)
}
by(auto, C17, aaov1)

# 사후검정 방법 2
auto$G17 <- cut(auto$V17, breaks = c(60,150,326), labels = c("G1", "G2"))
table(auto$G17)
g1 = subset(auto, G17 == "G1") # 그룹 분할
g2 = subset(auto, G17 == "G2")

g1_aov = aov(g1$V22~g1$V8)
summary(g1_aov)
(g1_post = LSD.test(g1_aov, "g1$V8", p.adj = "bonf", group = F))

g2_aov = aov(g2$V22~g2$V8)
summary(g2_aov)
(g2_post = LSD.test(g2_aov, "g2$V8", p.adj = "bonf", group = F))
