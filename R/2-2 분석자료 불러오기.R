# 직접 입력
# 1. c() 벡터생성
x <- c(1,2,3,4)
y <- c('A', 'B', 'C', 'D')

# 데이터프레임 자료 생성
data = data.frame(id=x, group=y)
data=data.frame(x,y)
View(data) # 대문자 V

# 2. scan()
# * 주요 옵션: scan(file="", what="자료형", n=-1, sep="구분자", skip=0, nlines=0, fileEncoding="")
# * 옵션 없는 경우 수치형 벡터 생성
data <- scan()
# * 문자형 자료 : what="" 또는 what="character"
data2 <- scan(what = "")
# * 다변량 자료
data3 <- scan(what = list(0,"")) # 숫자, 문자
View(data3)

# edit() 함수
df = data.frame()
df = edit(df)
df

# 파일 불러오기
# scan(), read.table(), read.csv()
# * 주요 옵션: scan(file="파일명", what="자료형", n=-1, sep="구분자", skip=특정 행까지 제외, nlines=특정 행까지 가져오기, fileEncoding="")

# * 작업 디렉토리 변경
getwd()
dir(getwd()) # 파일 목록
setwd("") # 작업공간 변경(경로는 \로 표시)

x1 <- scan("data1.txt") # 숫자형 자료
str(x1) # 자료에 대한 정보보

# * 부분자료 읽기
x2 <- scan("data1.txt", n = 10) # 10개 자료
x3 <- scan("data1.txt", nlines = 10) # 10행까지

# * 문자형 자료
gender <- scan("gender.txt", "")

# * 다변량 자료
x4 <- scan("data2.txt", what = list("", "", 0)) # 문자, 문자, 숫자(첫째행 문자 때문에 오류)
x4 <- scan("data2.txt", what = list("", "", 0), skip = 1)
x4 <- read.table("data2.txt", header = T) # dataFrame 형식, 칼럼명 있음
str(x4)

x5 <- scan("data3.txt", what = list("", "", 0), skip = 1) # 저장 방식 때문에 오류
x5 <- scan("data3.txt", what = list("", "", 0), skip = 1, fileEncoding = "UTF-8")
str(x5)

# 칼럼명 없는 파일
(student <- read.table(file = "student.txt"))
names(student) <- c("번호", "이름", "키", "몸무게") # 칼럼명 지정정

# 탐색기를 통한 파일 선택
(student1 <- read.table(file.choose(), header = TRUE))

# 구분자가 있는 경우
student2 <- read.table(file = "student2.txt", sep = ";", header = TRUE)

# 결측값 처리
student3 <- read.table(file = "student3.txt", header = TRUE, na.strings = "-")

student4 <- read.csv(file = "student4.txt", sep = ",", na.strings = "-") # sep 생략 가능
csvData <- read.csv(file = "data.csv", na.strings = "-")

# 파일 저장
student # 파일 확인
getwd()
write.table(student, "st.txt", row.names = F, quote = F)
write.csv(student, "st.csv", row.names = F, quote = F)