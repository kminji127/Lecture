setwd("c:/Users/mjkim/Documents/R Projects/R_Study")
gender <- scan("gender.txt", "") # 문자형 자료

# 도수분포표: table(), prop.table()
# * table(): 도수분포표 생성
gender.tbl <- table(gender)
gender.tbl["F"]
sum(gender.tbl) # 전체 도수
gender.tbl / sum(gender.tbl) # 비율(상대 도수)

# * prop.table() : 비율(상대 도수)
prop.table(gender.tbl)
(gender.prop <- round(100 * prop.table(gender.tbl), 1)) # 비율을 %로 수정, 소수점 2자리에서 반올림
(freq.tbl <- cbind(gender.tbl, gender.prop)) # 도수 벡터와 퍼센트 벡터 결합
colnames(freq.tbl) <- c("도수", "상대도수(%)")
freq.tbl


# 원 그래프: pie()
pie(gender.tbl)
names(gender.tbl) <- c("여자", "남자")
pie(gender.tbl)

gender1 <- names(gender.tbl) # 도수 이름
pct <- round(100 * prop.table(gender.tbl), 1) # 비율(%)
lab <- paste(gender1, "(", pct, "%)", set=" ") # 여자(45.6%) 형식으로 표시, 간격은 공백
pie(gender.tbl, labels = lab, col = rainbow(length(gender.tbl)), main = "pie chart")


# 막대 그래프: plot, barplot
barplot(gender.tbl)
barplot(gender.tbl, ylab="도수", xlab="성별", space=0.5)
abline(h=0) # 수평선 그리기

barplot(gender.tbl, horiz = TRUE, # 세로축 기준 (막대가 가로 방향)
        las = 1, # label을 수평으로 표시
        col = c("red", "blue"), space = 0.7, # 색깔, 간격
        main = "성별", # 그래프 제목
        xlab = "도수") # 가로축 label
abline(v=0) # 수직선 그리기
