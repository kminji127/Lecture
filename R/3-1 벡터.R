# 벡터(vector)
## * 자료의 최소 단위
## * [ ]로 인덱싱: 1부터 시작

# setwd("D:/data/statpg2/")   
testdata <- scan("data1.txt") # 벡터 형식

head(testdata,10) # 처음 10개 자료 보여줌

testdata[1] # 첫번째 값

testdata[c(2,3,5)] # 2,3,5번째 값


test <- testdata[1:5] # 1~5번째 값을 test 벡터에 저장
test

## * 벡터에 데이터 추가, 삽입, 제거
(test <- c(0,test,0)) # 0 57000 40200 21450 21900 45000 0
test[1] <- 99
test[10] <- 7
test # 99 57000 40200 21450 21900 45000 0 NA NA 7
x <- c(5,6)
test <- append(test,x,after=5) # 5행 이후에 벡터 (5, 6) 추가
test # 99 57000 40200 21450 21900 5 6 45000 0 NA NA 7
test[c(-10,-11)]   # test[-c(10,11)] : 10, 11번째 값 제거

# testdata에서 값이 30000 이상인 자료만 선택

testdata >= 30000

id <- which(testdata >= 30000) # 30000 이상 값의 위치
id
testdata[-id] # 30000 이상 값 제거

testdata[!(testdata >= 30000)] # 30000 이상이 아닌 값들만

## * 결측값: NA
(test <- c(NA, testdata[1:5]))
is.na(test)    # 결측값 확인
결측값 <- c("NA"," ", "", NA)
is.na(결측값) # FALSE FALSE FALSE  TRUE


## * 원소에 이름을 부여할 수 있음
test <- testdata[1:4]
names(test) <- c("X1","X2","X3")
test
test[c("X1","X3")]

################################################

#### 통계함수
# 벡터함수
## * mean: 평균
## * median: 중앙값
## * min: 최솟값
## * max: 최댓값
## * sd: 표준편차
## * quantile: 제1, 3사분위수
## * fivenum: Tukey's five number summaries

# 벡터분석 가능함수
## * length: 벡터의 길이=표본크기(결측값 없는 경우)
## * sum: 합
## * var: 분산
## * summary: 주요 통계

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

# 반올림 관련 함수
a <- c(-2.456, 3.6789, 5.23445676)
ceiling(a) # 올림 : -2 4 6
floor(a) # 내림 : -3 3 5
trunc(a) # 소수점 버림 : -2 3 5
round(a) # 반올림 : -2 4 5
round(a, digits = 2) # 반올림, 소수점 2자리까지 표기(3자리에서 반올림)