/*

#include<stdio.h>
#include<string.h>
#define SIZE 3
#define STU_NUMBER 1
#define REG_NUMBER 2

/*12.04
struct student1 {
	int number;
	char name[10];
	double grade;
};

struct student2 {
	int number;
	char name[10];
	double grade;
};

struct point {
	int x;
	int y;
};

struct rect {
	struct point p1;
	struct point p2;
};

struct student3 {
	int number;
	char name[20];
	double grade;
};

int main(void)
{
	
	char love[] = "100";
	int value;

	sscanf_s(love, "%d", &value);
	printf("%d\n", value);
	value++;
	sprintf_s(love, "%d", value);
	printf("%s\n\n", love);


	//11장 14 - 구조체 예제 #1
	struct student1 s;
	s.number = 20190001;
	strcpy_s(s.name, "홍길동");
	s.grade = 4.3;

	printf("학번: %d\n", s.number);
	printf("이름: %s\n", s.name);
	printf("학점: %f\n\n", s.grade);

	//11장 15 - 예제 #2
	struct student2 t;
	printf("학번을 입력하시오: ");
	scanf_s("%d", &t.number);
	printf("이름을 입력하시오: ");
	scanf_s("%s", &t.name, sizeof(t.name));
	printf("학점을 입력하시오(실수): ");
	scanf_s("%lf", &t.grade);

	printf("\n학번: %d\n", t.number);
	printf("이름: %s\n", t.name);
	printf("학점: %f\n\n", t.grade);


	//11장 20 - 사각형 point 구조체 나타내기
	struct rect r;
	int w, h, area, peri;

	printf("왼쪽 상단의 좌표를 입력하시오: ");
	scanf_s("%d %d", &r.p1.x, &r.p1.y);
	printf("오른쪽 상단의 좌표를 입력하시오: ");
	scanf_s("%d %d", &r.p2.x, &r.p2.y);

	w = r.p2.x - r.p1.x;
	h = r.p2.y - r.p1.y;
	area = w * h;
	peri = 2 * (w + h);

	printf("면적은 %d이고 둘레는 %d입니다.\n\n", area, peri);
	

	//11장 28 - 구조체 배열
	struct student3 list[SIZE];
	int i;

	for (i = 0; i < SIZE; i++)
	{
		printf("학번을 입력하시오: ");
		scanf_s("%d", &list[i].number);
		printf("이름을 입력하시오: ");
		scanf_s("%s", &list[i].name, sizeof(list[i].name));
		printf("학점을 입력하시오(실수): ");
		scanf_s("%lf", &list[i].grade);
	}

	for (i = 0; i < SIZE; i++)
		printf("\n학번: %d, 이름: %s, 학점: %f\n", list[i].number, list[i].name, list[i].grade);
	
	printf("\n");

	//11장 31 - 구조체 포인터
	struct student3 u = { 20070204,"홍길동",4.3 };
	struct student3* p;
	p = &u;

	printf("\n학번: %d, 이름: %s, 학점: %f\n", u.number, u.name, u.grade);
	printf("\n학번: %d, 이름: %s, 학점: %f\n", (*p).number, (*p).name, (*p).grade);
	printf("\n학번: %d, 이름: %s, 학점: %f\n\n", p->number, p->name, p->grade);
	
	return 0;
}
*/

/*struct vector
{
	float x;
	float y;
};
struct vector get_vector_sum(struct vector a, struct vector b);

struct student 
{
	int type;
	union
	{
		int stu_number;
		char reg_number[15];
	}id;
	char name[20];
};

void print(struct student s)
{
	switch (s.type)
	{
	case STU_NUMBER:
		printf("학번: %d\n", s.id.stu_number);
		printf("이름: %s\n", s.name);
		break;
	case REG_NUMBER:
		printf("주민등록번호: %s\n", s.id.reg_number);
		printf("이름: %s\n", s.name);
		break;
	default:
		printf("타입 오류\n");
		break;
	}
}

//11장 62
typedef struct point
{
	int x;
	int y;
} POINT;

POINT translate(POINT p, POINT delta);

int main(void)
{
	//11장 41 - lab: 벡터 연산
	struct vector a = { 2.0, 3.0 };
	struct vector b = { 5.0, 6.0 };
	struct vector sum;

	sum = get_vector_sum(a, b);
	printf("벡터의 합은 (%f, %f)입니다.\n\n", sum.x, sum.y);
	
	//11장 46 - 공용체 타입 필드
	struct student s1, s2;
	s1.type = STU_NUMBER;
	s1.id.stu_number = 20190001;
	strcpy_s(s1.name, "홍길동");

	s2.type = REG_NUMBER;
	strcpy_s(s2.id.reg_number, "860101-1056076");
	strcpy_s(s2.name, "김철수\n");

	print(s1);
	print(s2);

	//11장 55 - 열거형

	//11장 62 - typedef
	POINT p = { 2,3 };
	POINT delta = { 10,10 };
	POINT result;

	result = translate(p, delta);
	printf("새로운 점의 좌표는 (%d, %d)입니다.\n\n", result.x, result.y);
	
	//11장 67 - mini project: 평점 높은 학생 찾기
	
	return 0;

}

struct vector get_vector_sum(struct vector a, struct vector b)
{
	struct vector result;

	result.x = a.x + b.x;
	result.y = a.y + b.y;

	return result;
}

POINT translate(POINT p, POINT delta)
{
	point new_p;
	new_p.x = p.x + delta.x;
	new_p.y = p.y + delta.y;

	return new_p;
}

*/