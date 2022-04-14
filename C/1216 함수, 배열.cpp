#include <stdio.h>

void swap(int* px, int* py);

int main(void)
{
	//swap()ÇÔ¼ö #2
	int a = 100, b = 200;
	printf("a = %d b = %d\n", a, b);
	swap(&a, &b);
	printf("a = %d b = %d\n\n", a, b);

	return 0;
}

void swap(int* px, int* py)
{
	int tmp;
	tmp = *px;
	*px = *py;
	*py = tmp;
}
