#calculator.py
#2번
class Calculator:
    def __init__(self, list):
        self.list=list
    def sum(self):
        result=0
        for i in self.list:
            result=result+i
        return result
    def avg(self):
        total=self.sum()
        result=total/len(self.list)
        return result

