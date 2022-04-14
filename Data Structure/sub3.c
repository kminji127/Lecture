#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct node
{
	int num;
	struct node* link;
};

void create(struct node** head);
int left(struct node**, int k);

int main()
{
	struct node* head = NULL;
	int left_people;
	create(&head);
	srand(time(NULL));
	int token = rand() % 13 + 1;
	left_people = left(&head, token);

	printf("남은 사람 : %d\n", left_people);
	free(head);

	return 0;
}

void create(struct node** head)
{
	struct node* temp;
	struct node* rear = NULL;
	int a;

	for (int j = 0; j < 13; j++)
	{
		printf("숫자를 입력하세요 : ");
		scanf_s("%d", &a);
		temp = (struct node*)malloc(sizeof(struct node));
		temp->num = a;
		temp->link = NULL;
		if (*head == NULL)
			* head = temp;
		else
			rear->link = temp;
		rear = temp;
	}
	rear->link = *head;
}

int left(struct node** head, int k)
{
	struct node *p, *q;
	int i;

	q = *head;
	p = *head;

	while (p->link != p)
	{
		for (i = 0; i < k - 1; i++)
		{
			q = p;
			p = p->link;
		}
		q->link = p->link;
		printf("빠진 사람 : %d\n", p->num);
		free(p);
		p = q->link;
	}
	*head = p;

	return (p->num);
}