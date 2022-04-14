## 자동차의 주행속도(speed)와 제동거리(dist)에 대한 관계분석
str(cars)
summary(cars$speed)
plot(cars$speed, cars$dist) # 산점도

# 단순회귀모형: dist_i = a + b*speed_i + 오차
(lm_out = lm(dist~speed, data=cars))
summary(lm_out) # 모형 결과 확인
coef(lm_out) # 회귀계수
cars$speed[1:5] # 독립변수 X (4 4 7 7 5)
fitted(lm_out)[1:5] # 모형에 의해 추정(예측)된 값 (독립변수 대입)
cars$dist[1:5] # 실제 값
predict(lm_out, newdata = data.frame(speed=15)) # speed가 15일 때 모형에 의해 추정된 dist 값

# 잔차(residuals): 실제값과 선형회귀모형으로부터 구한 예측값의 차이
residuals(lm_out)[1:5]
cars$dist[1:5] - fitted(lm_out)[1:5] # 직접 계산

# 회귀계수의 신뢰구간
confint(lm_out) # 95%
confint(lm_out, level = 0.99) # 99%


## 모형진단(가정검진): 잔차그림 이용해서 오차항의 가정 확인
# plot(lm결과, which=c(1:6))
# which: 출력할 그래프의 종류 1~6까지 6가지 그래프
# plot(lm_out): lm 결과를 쓰면 4가지 그림 결과 보임
plot(lm_out, which=1) # 오차항이 평균=0이고 분산이 일정한지 확인
plot(lm_out, which=2) # 오차항이 정규분포 따르는지 확인
plot(lm_out, which=3) # 이상점을 탐지할 수 있는 그래프 빨간색 추세선이 0인 직선이 가장 이상적이며, 크게 벗어난 값은 이상점일 가능성 있음
plot(lm_out, which=4) # 회귀직선의 모양에 크게 영향을 끼치는 점을 찾는 그래프

par(mfrow=c(2,2))
plot(lm_out)


# 회귀직선의 시각화
plot(cars$speed, cars$dist, xlab = "speed", ylab = "distance")
abline(lm_out, col="green")
cor(cars$speed, cars$dist) # 0.8068949


## 추정값의 신뢰구간 포함하는 그래프
summary(cars$speed)
speed.range <- seq(min(cars$speed), max(cars$speed), .1) # 최소부터 최대까지 0.1씩 증가한 값
y_ci <- predict(lm_out, newdata = data.frame(speed=speed.range), interval = "confidence")

# 결과 행렬
matplot(speed.range, y_ci, xlab = "speed", ylab = "distance", type = "n")
matlines(speed.range, y_ci, lty = c(1,2,2))

# ggplot 이용하기
# 선만 그리고 싶을 때: stat_smooth(method='lm', se=F)
library(ggplot2)
ggplot(cars, aes(speed, dist)) + geom_point() + 
  stat_smooth(method = 'lm', color='black') +
  geom_text(x=21, y=25, label="dist = -17.579 + 3.932 speed", size=5, color="blue")
