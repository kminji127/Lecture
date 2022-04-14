data = c(1,2,3,4)
data
class(data) # "numeric"

y <- matrix(data, nrow = 2, ncol = 2)
y
class(y) # "matrix" "array"

y <- matrix(1:10, 5, 2) # nrow, ncol 생략 가능
y

y1 <- matrix(data, nrow = 2, byrow = T)
y1

y <- matrix(1:10, 4, 3)
y

x1 <- c(5, 40, 50:52)
x2 <- c(30, 5, 6:8)
(mr = rbind(x1, x2))
(mc = cbind(x1, x2))
x3 <- 1:5
(rbind(mr, x3))
(cbind(mc, x3))

class(mc)
dim(mc)
ncol(mc)
nrow(mc)
length(mc)
mc[1,1]
mc[3,2]
mc[1,]
mc[,2]
mc[mc>30] <- 0
mc
mc[1:2,]
mc[3:5,2]
mc[c(2,4),]

x4 <- c(23,45,17,55,38)
(mr = rbind(x1, x2, x3, x4))
(mr[-2,])
(mr[,-c(1,3)])

colnames(mr) <- c("x1", "x2", "x3", "x4", "x5")
mr
(mr[,-c(1,3)])

x1 <- c(5, 40, 50:52)
x2 <- c(30, 5, 6:8)
mc = cbind(x1, x2)

x = mc[1,]
class(x) # "numeric"
ncol(x) # NULL
nrow(x) # NULL

x1 = mc[1, , drop=F]
class(x1) # "matrix" "array"
ncol(x1) # 2
nrow(x1) # 1

x <- matrix(c(1,2,3,2,3,4), 3, 2)
x
x[x[,2]>=3,]

a <- matrix(c(1,0,-1,2,1,0,1,1,3), 3, 3)
b <- matrix(rep(c(1,2,3), each=3), 3, 3)
a;b
a+b
a-b
2*a;2*b
a*b
a%*%b

(z1 = matrix(1:9, 3, 3))
(z2 = matrix(1:3, 3, 1))
z1+z2 # Error
z1*z2 # Error
z1 + c(z2)
z1 * c(z2)
z1 %*% z2

(z1 <- diag(1:5))
apply(z1, 1, max)
apply(z1, 1, mean)
apply(z1, 2, min)
apply(z1, 2, mean)

(z2 <- diag(rep(1,5)))
(z3 <- diag(rep(0,5)))