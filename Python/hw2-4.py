#4번
from calculator import Calculator
class AdvCalculator(Calculator):
    def minval(self):
        result=self.list[0]
        for n in self.list[1:]:
            if n < result:
                result=n
        return result
    def maxval(self):
        result=self.list[0]
        for k in self.list[1:]:
            if k > result:
                result=k
        return result
