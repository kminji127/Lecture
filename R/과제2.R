## 1번
Beer <- c(3,4,1,1,3,4,3,3,1,3,2,1,2,1,2,3,1,1,1,1,4,3,1,2)
# (1)
BeerTbl <- table(Beer)
names(BeerTbl) <- c("domestic can", "domestic bottle", "microbrew", "import")
BeerTbl

# 또는
Beer[Beer==1] <- "domestic can"
Beer[Beer==2] <- "domestic bottle"
Beer[Beer==3] <- "microbrew"
Beer[Beer==4] <- "import"
beer.freq = table(Beer)

# (2)
barplot(BeerTbl, ylab="판매량", xlab="맥주", space=0.5) # 막대 그래프
par(oma = c(1,4,1,1)) # Sets outside margins(하좌상우)
par(mar = c(4,4,1,1)) # Sets inner margins

pie(BeerTbl, main="맥주판매량") # 원 그래프


## 2번
# (1)
score <- c(90,85,73,80,85,65,78,50,68,96)
names(score) <- c("KOR","ENG","MATH","HIST","SOC","MUSIC","BIO","EARTH","PHY","ART")
# (2)
score
# (3)
mean(score)
# (4)
median(score)
# (5)
sd(score)
# (6)
which.max(score)
score[score == max(score)] # 답
subset(score, score == max(score)) # 답
# (7)
boxplot(score)
quantile(score) # Q1=69.25, Q3=85.00
69.25 - 1.5*IQR(score) # 45.625
85.00 + 1.5*IQR(score) # 108.625
# 정상값 범위: [45.625, 108.625] => 이상치 없음
# (8)
hist(score, main="Hong’s score", col="purple")


## 3번
boxplot(Temp~Month, data=airquality, ylab="Temperature", las=1)
