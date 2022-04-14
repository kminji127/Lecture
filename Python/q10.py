import os
os.chdir("C:\doit")
f=os.popen("dir")
print(f.read())
