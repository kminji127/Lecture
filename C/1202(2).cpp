#include<stdio.h>
#include<ctype.h>
#include<string.h>
#include<stdlib.h>

/*12.02
int count_word(const char* s);

char s3[] = "Man is immortal, because he has a soul";
char seps[] = " ,\t\n";
char* token, * context;

int main(void)
{
	//12장 33 - lab: 단어 세기
	int wc = count_word("the c book");
	printf("단어의 개수: %d\n\n", wc);

	//12장 40 - 문자열 연결
	char dst[12] = "Hello";
	char src[6] = "World";
	strcat_s(dst, src);
	printf("%s\n\n", dst);

	//12장 44 - 문자열 비교
	char s1[80];
	char s2[80];
	int result;

	printf("첫번째 단어: ");
	scanf_s("%s", &s1, sizeof(s1));
	printf("두번째 단어: ");
	scanf_s("%s", &s2, sizeof(s2));

	result = strcmp(s1, s2);
	if (result < 0)
		printf("%s가 %s보다 앞에 있습니다.\n", s1, s2);
	else if (result == 0)
		printf("%s와 %s는 같습니다.\n", s1, s2);
	else
		printf("%s가 %s보다 뒤에 있습니다.\n", s1, s2);


	//12장 49 - 문자열 검색
	char s[] = "A joy that's shared is a joy made double";
	char sub[] = "dream";
	char* p;
	int loc;
	p = strstr(s, sub);
	loc = (int)(p - s);
	if (p != NULL)
		printf("첫번째 %s이/가 %d에서 발견되었음\n\n", sub, loc);
	else
		printf("%s이/가 발견되지 않았음.\n\n", sub);


	//12장 51 - 문자열 토큰 분리
	token = strtok_s(s3, seps, &context);
	while (token != NULL)
	{
		printf("토큰: %s\n", token);
		token = strtok_s(NULL, seps, &context);
	}

	printf("\n");

	//12장 55 - 문자열 수치 변환
	char love[] = "100";
	int value;

	sscanf_s(love, "%d", &value);
	printf("%d\n", value);
	value++;
	sprintf_s(love, "%d", value);
	printf("%s\n", love);


	//12장 65 - 2차원 배열로 입력
	int i;
	char fruits[3][20];
	for (i = 0; i < 3; i++)
	{
		printf("과일 이름을 입력하시오: ");
		scanf_s("%s", fruits[i]);
	}
	for (i = 0; i < 3; i++)
		printf("%d번째 과일: %s\n\n", i, fruits[i]);


	return 0;
}


int count_word(const char* s)
{
	int i;
	int wc = 0;
	int waiting = 1;

	for (i = 0; s[i] != NULL; ++i)
	{
		if (isalpha(s[i]))
		{
			if (waiting)
			{
				wc++;
				waiting = 0;
			}
		}
		else
			waiting = 1;
	}

	return wc;
}

*/

/*12.11
int main(void)
{
	printf("%10.3f\n\n", 12.3245);
	int a, b;
	printf("6개의 정수 입력: ");
	scanf_s("%3d %3d", &a, &b);
	printf("%d %d\n\n", a, b);


	FILE* fp = NULL;
	fopen_s(&fp, "sample.txt", "w");

	if ((fopen_s(&fp,"sample.txt","w"))!=0)
		printf("파일 열기 실패\n");

	else
		printf("파일 열기 성공\n");

	fputc('a', fp);
	fputc('b', fp);
	fputc('c', fp);
	fclose(fp);


	FILE* fp1, * fp2;
	char file1[100], file2[100];
	char buffer[100];
	errno_t err;

	printf("원본 파일 이름: ");
	scanf_s("%s", &file1, sizeof(file1));

	printf("복사 파일 이름: ");
	scanf_s("%s", &file2, sizeof(file2));

	if ((fopen_s(&fp1, file1, "r")) != 0) 
	{
		fprintf(stderr, "원본 파일 %s를 열 수 없습니다.\n", file1);
		exit(1);
	}

	if ((fopen_s(&fp2, file2, "r")) != 0)
	{
		fprintf(stderr, "복사 파일 %s를 열 수 없습니다.\n", file2);
		exit(1);
	}
	
	fclose(fp1);
	fclose(fp2);

	return 0;
}

*/