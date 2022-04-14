## 1번
# (1)
25 + 99
# (2)
456 - 123
# (3)
2 * (3 + 4)
# (4)
(3 + 5 * 6) / 7
# (5)
(7-4) * 3
# (6)
210 + 35
# (7)
1256 %% 7
# (8)
184 %% 5
# (9)
1976 / 24
# (10)
16*25 + 186*5 - 67*22


## 2번
(y <- 2*6^2 + 5*6 + 10)
(y <- 2*8^2 + 5*8 + 10)
(y <- 2*10^2 + 5*10 + 10)


## 3번
# (1)
d <- c(101:200)
# (2)
d
# (3)
d[10]
# (4)
tail(d, 10)
# (5)
d[d %% 2 == 0]
# (6)
d.20 <- head(d, 20)
d.20
# (7)
d.20[-5]
# (8)
d.20[-c(5,7,9)]


## 4번
d1 <- 1:50
d2 <- 51:100
# (1)
d1
d2
# (2)
d1 + d2
d2 - d1
d1 * d2
d2 / d1
# (3)
sum(d1)
sum(d2)
# (4)
sum(d1+d2)
# (5)
max(d2)
min(d2)
# (6)
mean(d2)
mean(d1)
mean(d2) - mean(d1)
# (7)
d1[order(-d1)]
# (8)
d3 <- append(head(d1[order(-d1)], 10), head(d2[order(-d2)], 10))
d3


## 5번
v1 <- 51:90
# (1)
v1[which(v1<60)]
# (2)
length(v1[v1<70])
# (3)
sum(v1[v1>65])
# (4)
v1[v1>60 & v1<73]
# (5)
v1[v1<65 | v1>80]
# (6)
v1[v1 %% 7 == 3]


## 6번
# (1)
score <- matrix(c(10,40,60,20,21,60,70,30), 4, 2)
colnames(score) <- c("m", "f")
score
# (2)
colnames(score) <- c("male", "female")
score
# (3)
score[2,]
# (4)
score[,'female']
# (5)
score[3,2]


## 7번
# (1)
(a <- rnorm(5, 0, 1))
# (2)
(b <- rnorm(4, 1, 1))
# (3)
(c <- rnorm(3, 1, 0.5))
# (4)
(lst <- list(lev1=a, lev2=b, lev3=c))
# (5)
lst$lev1 <- NULL
lst1 <- lst
lst1
median(append(lst1$lev2, lst1$lev3))


## 8번
# (1)
id <- c(10, 20, 30, 40, 50)
name <- c("John", "Tom", "Paul", "Jane", "Grace")
score <- c(95, 46, 98, 74, 85)
df <- data.frame(id, name, score)
df
# (2)
df$score
df[,3]
df[,"score"]
# (3)
df[c('id', 'score')]
# (4)
df[c(2,3),]
# (5)
df[2,3]


## 9번
# (1)
st <- data.frame(state.x77)
# (2)
colnames(st)
# (3)
rownames(st)
# (4)
nrow(st)
ncol(st)
# (5)
summary(st)
# (6)
st["Florida",]
# (7)
st[,"Income"]
# (8)
st["Texas", "Area"]
# (9)
st["Ohio", c("Population", "Income")]
# (10)
subset(st, subset = Population >= 5000)
# (11)
nrow(st[st$Income>=4500,])
# (12)
mean(st[st$Illiteracy<2.0,]$Income) # 문맹률 2.0 미만인 주의 평균 수입
mean(st[st$Illiteracy>=2.0,]$Income) # 문맹률 2.0 이상인 주의 평균 수입
mean(st[st$Illiteracy<2.0,]$Income) - mean(st[st$Illiteracy>=2.0,]$Income) # 차이

## 10번
# (1)
Korean <- c(93,76,87,92,98,75,82)
name <- c("kim", "lee", "park", "oh", "yang", "min", "jung")
(Korean <- data.frame(name, Korean))

English <- c(90,94,88,75,79,87,88,90)
name <- c("kim", "lee", "park", "oh", "yang", "min", "jung", "choi")
(English <- data.frame(name, English))

merge(Korean, English, by="name", all.y = T)

# (2)
y <- merge(Korean, English, by="name", all.y = T)
cumsum(y$Korean[which(is.na(y$Korean)==F)]) # Korean 누적합
cumsum(y$English) # English 누적합