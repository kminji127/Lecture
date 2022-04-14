## 기본함수: cut, table, prop.table
salary <- scan('data1.txt')
summary(salary)
head(salary)

group <- c(10000, 20000, 30000, 50000, 75000, 100000, 150000) # 경계값
(salary.group <- cut(salary, breaks=group)) # 계급화
class(salary.group) # factor
head(salary.group)
# cut(salary, breaks = c(10000, 20000, 30000, 50000, 75000, 100000, 150000), right = F)
# * cut() 함수는 "right=T" 옵션이 디폴트 -> (m,n] (m 초과 n 이하)
# * "right=F"을 설정하면 [m,n) (m 이상 n 미만)
(salary.tbl <- table(salary.group)) # 도수분포표
names(salary.tbl) <- c("G1", "G2", "G3", "G4", "G5", "G6") # 계급명
salary.tbl

# 계급화와 계급명 설정을 동시에
salary.group <- cut(salary, breaks=group, labels=c("G1", "G2", "G3", "G4", "G5", "G6"))
(salary.tbl <- table(salary.group)) # 도수분포표

(salary.prop <- prop.table(salary.tbl)) # 상대도수(비율)
(salary.csum <- cumsum(salary.prop)) # 누적상대도수
salary.freq <- cbind(salary.tbl, round(100*salary.prop, 1), round(100*salary.csum, 1)) # 합치기
colnames(salary.freq) <- c("도수", "상대도수(%)", "누적상대도수(%)")
salary.freq

## 히스토그램
hist(salary)
hist(salary, nclass = 30) # 막대 개수

# 구간 지정
# y축: 도수 => 밀도(전체면적=1)
hist(salary, breaks=c(10000,20000,30000,50000,75000,100000,150000))
hist(salary, breaks=c(10000,20000,30000,50000,75000,100000,150000),
     xlab="임금", ylab="밀도", main="임금 히스토그램",
     las=1, border="blue", col="green") # las: label 글자 방향

# 그림을 2행 3열로 분할할 때 mfrow는 행우선 배치, mfcol은 열우선 배치
par(mfrow=c(2,2))
# breaks=n일 때 막대 개수는 log_2(n)+1로 계산
hist(salary, breaks=5, main="a")
hist(salary, breaks=10, main="b")
hist(salary, breaks=15, main="c")
hist(salary, breaks=20)
dev.off() # 그래프 창 분할 초기화

## 상자그림
boxplot(salary)
boxplot(salary, horizontal=T, xlab="임금", main="임금자료") # 가로 변환
abline(v=mean(salary)) # 평균값에 수직선

boxplot(log(salary,10), horizontal = T) # 로그 변환 => 간격 감소
abline(v=mean(log(salary,10)), col="blue")

# 데이터에 그룹이 있는 경우
str(iris)
head(iris)
boxplot(Petal.Width~Species, data=iris, ylab="Petal.width", las=1) # 품종에 따른 상자그림


## 수치로 자료 요약
k_score=c(96,80,76,96,88,75,78,89,92,70) # 국어 점수
sum(k_score) # 총합
mean(k_score) # 평균
max(k_score) # 최대값
min(k_score) # 최소값
range(k_score) # 범위 : 70 96
var(k_score) # 분산
sd(k_score) # 표준편차
median(k_score) # 중앙값
rank(k_score) # 순위
length(k_score) # 길이
summary(k_score) # 요약
sort(k_score, decreasing=T) # 내림차순 (기본값은 오름차순)
quantile(k_score) # 사분위수
IQR(k_score) # 사분위수범위 Q3-Q1