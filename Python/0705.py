#1번
class Calculator:
    def __init__(self):
        self.value=0
    def add(self, val):
        self.value=self.value+val

class UpgradeCalculator(Calculator):
    def minus(self, val):
        self.value=self.value-val

cal=UpgradeCalculator()
cal.add(10)
cal.minus(7)
print(cal.value)
print('')

#2번
class MaxLimitCalculator(Calculator):
    def add(self, val):
        self.value=self.value+val
        if self.value>100:
            self.value=100
        

cal=MaxLimitCalculator()
cal.add(50)
cal.add(60)
print(cal.value)

print('')

#3번
print('')

#4번
