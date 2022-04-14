#1번
def print_personnel(name, position="학생", nationality="대한민국"):
    print("name = %s, position= %s, nationality = %s" %(name, position, nationality))

if __name__=="__main__":
    print_personnel(name="김숙명")
    print_personnel(name="김숙명", position="스태프")
    print_personnel(name="김숙명", position="스태프", nationality="USA")
