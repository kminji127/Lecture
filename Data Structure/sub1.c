#include <stdio.h>
#include <stdlib.h>


int move[4][2] = {
	{-1,0},
    {0,1},
    {1,0},
    {0,-1}
};

typedef struct
{
	int i, j, dir;
}element;

element stack[81];
int top = -1;
element current = { 1,1 };

void push(element* stack, element item) {
	if (top >= 81 - 1) {
		printf("Stack이 꽉 찼습니다.\n");
		return;
	}
	stack[++top] = item;
}

element pop(element* stack) {
	if (top == -1) {
		printf("Stack이 공백입니다.\n");
		exit(1);
	}
	else
		return stack[top--];
}

int isEmpty(element* stack) {
	if (top == -1)
		return 1;
	else
		return 0;
}

void mazePath();

void main()
{
	mazePath();
}

void mazePath() {
	int maze[11][11] = {
		{1,1,1,1,1,1,1,1,1,1,1},
	    {1,0,0,1,1,1,1,1,1,1,1},
	    {1,1,0,1,1,0,0,0,1,1,1},
	    {1,1,0,0,0,0,1,0,1,1,1},
	    {1,1,1,1,0,1,1,0,1,1,1},
	    {1,0,0,0,0,0,1,0,1,1,1},
	    {1,1,1,0,1,1,1,1,1,1,1},
	    {1,1,1,0,0,0,0,0,1,1,1},
	    {1,1,1,1,1,0,1,0,0,0,1},
	    {1,1,1,1,1,0,1,1,1,0,1},
	    {1,1,1,1,1,1,1,1,1,1,1},
	};

	int mark[11][11] = { 0 };

	int i, j, next_i, next_j, dir;

	element item = { 1,1,1 };
	push(stack, item);

	while (!isEmpty(stack)) {
		item = pop(stack);
		i = item.i;
		j = item.j;
		dir = item.dir;
		while (dir <= 3) {
			next_i = i + move[dir][0];
			next_j = j + move[dir][1];
			if (next_i == 9 && next_j == 9) {
				printf("이동 경로\n");
				printf("<%d, %d, %d>\n", next_i, next_j, dir);
				for (int a = top; a >= 0; a--) {
					printf("<%d, %d, %d>\n", stack[a].i, stack[a].j, stack[a].dir);
				}
				return;
			}
			if (maze[next_i][next_j] == 0 && mark[next_i][next_j] == 0) {
				mark[next_i][next_j] = 1;
				item.i = next_i;
				item.j = next_j;
				item.dir = dir;
				push(stack, item);
				i = next_i;
				j = next_j;
				dir = 0;
			}
			else dir += 1;
		}
	}
	printf("경로가 없습니다\n");
}