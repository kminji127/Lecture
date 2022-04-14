#06-4 간단한 메모장 만들기
# memo.py

import sys

option = sys.argv[1]

if option == '-a':
    memo = sys.argv[2]
    f=open('memo.txt','a')
    f.write(memo)
    f.write('\n')
    f.close()
elif option == '-v':
    f=open('memo.txt','r')
    memo = f.read()
    f.close()
    print(memo)
