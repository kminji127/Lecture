#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
	int data;
	struct Node* link;
}Node;

void push(struct Node **head_ref, int new_data) {
	struct Node* new_node = (struct Node*)malloc(sizeof(struct Node));
	new_node->data = new_data;
	new_node->link = (*head_ref);
	(*head_ref) = new_node;
}

Node *search(Node* head, int searchnum) {
	Node* p;
	p = head;

	while (p != NULL) {
		if (p->data == searchnum)
			return p;
		p = p->link;
	}
	return p;
}

int main()
{
	struct Node* head = NULL;

	push(&head, 99);
	push(&head, 96);
	push(&head, 80);
	push(&head, 75);
	push(&head, 73);
	push(&head, 71);
	push(&head, 70);
	push(&head, 69);
	push(&head, 67);
	push(&head, 66);
	push(&head, 59);
	push(&head, 56);
	push(&head, 55);
	push(&head, 51);
	push(&head, 49);
	push(&head, 48);
	push(&head, 43);
	push(&head, 42);
	push(&head, 26);
	push(&head, 24);
	push(&head, 15);
	push(&head, 14);
	push(&head, 12);
	push(&head, 11);
	push(&head, 8);
	push(&head, 7);
	push(&head, 6);
	push(&head, 5);
	push(&head, 3);
	push(&head, 1);
	
	int searchnum, index;
	for (int i = 0; i < 5; i++) {
		printf("찾으시는 숫자를 입력하세요 : ");
		scanf_s("%d", &searchnum);
		index = search(head, searchnum);
		printf("찾으시는 숫자의 index 값 : %d\n\n", index);
	}	
	return 0;
}