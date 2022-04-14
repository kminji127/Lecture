#05-1 클래스
class FourCal:
    def __init__(self,first,second):
        self.first=first
        self.second=second
    def setdata(self, first, second):
        self.first=first
        self.second=second
    def add(self):
        result=self.first+self.second
        return result
    def mul(self):
        result=self.first*self.second
        return result
    def sub(self):
        result=self.first-self.second
        return result
    def div(self):
        result=self.first/self.second
        return result
a=FourCal(127,486)
b=FourCal(19,14)
print("a.add() = "+str(a.add()))
print("b.add() = "+str(b.add()))
print("a.mul() = "+str(a.mul()))
print("b.mul() = "+str(b.mul()))
print("a.sub() = "+str(a.sub()))
print("b.sub() = "+str(b.sub()))
print("a.div() = "+str(a.div()))
print("b.div() = "+str(b.div()))

class MoreFourCal(FourCal):
    def pow(self):
        result=self.first**self.second
        return result
c=MoreFourCal(19,14)
print("c.pow() = "+str(c.pow()))
print(c.add())
print(c.mul())
print(c.sub())
print(c.div())

class SafeFourCal(FourCal):
    def div(self):
        if self.second==0:
            return 0
        else:
            return self.first/self.second
d=SafeFourCal(4,0)
print("d.div() = "+str(d.div()))
print('')
print('')

class HousePark:
    lastname="박"
    def __init__(self, name):
        self.fullname=self.lastname+name
    def travel(self,where):
        print("%s, %s여행을 가다" % (self.fullname, where))
    def love(self, other):
        print("%s, %s 사랑에 빠졌네" %(self.fullname, other.fullname))
    def __add__(self, other):
        print("%s, %s 결혼했네" %(self.fullname, other.fullname))
    def fight(self, other):
        print("%s, %s 싸우네" %(self.fullname, other.fullname))
    def __sub__(self, other):
        print("%s, %s 이혼했네" %(self.fullname, other.fullname))

pey=HousePark("길동")
pes=HousePark("눈송")
print(pey.lastname)
print(pes.lastname)
print(pey.fullname)
print(pes.fullname)
pey.travel("부산")
pes.travel("홋카이도")

class HouseKim(HousePark):
    lastname="김"
    def travel(self,where,day):
        print("%s, %s여행을 %d일 가네" %(self.fullname, where, day))
    
juliet=HouseKim("줄리엣")
print(juliet.fullname)
juliet.travel("독도",3)
print('')
pey.travel("부산")
juliet.travel("부산",3)
pey.love(juliet)
pey+juliet
pey.fight(juliet)
pey-juliet
print('')
class Noonsong(HousePark):
    lastname="눈"
    def mas(self, other):
        print("%s는 %s의 마스코트랍니다. 얼마나 귀엽게요~" %(self.fullname, other))
sm=Noonsong("송이")
sm.travel("숙대")
sm.mas("숙명")
