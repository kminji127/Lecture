#include<stdio.h>

int main(void)
{
	int x = 20, y = 10;
	int sum, dif, mul, div;

	sum = x + y;
	dif = x - y;
	mul = x * y;
	div = x / y;

	printf("두 수의 합: %d\n두 수의 차: %d\n두 수의 곱: %d\n두 수의 몫: %d\n", sum, dif, mul, div);

	return 0;
}