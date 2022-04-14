#include<stdio.h>
int main(void)
{
	int grade, n;
	float sum, average;
	grade = 0;
	n = 0;

	printf("종료 시 음수 입력\n");
	while (grade >= 0)
	{
		printf("점수를 입력하시오: ");
		scanf_s("%d", &grade);
		sum += grade;
		n++;
	}
	sum = sum - grade;
	n--;
	average = sum / n;

	printf("평균: %f점", average);

	return 0;
}