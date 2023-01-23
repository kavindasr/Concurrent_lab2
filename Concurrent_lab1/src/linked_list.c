#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<time.h>

void Insert(int val);
void Delete(int val);
bool Member(int val);
void FreeList(node head);
int* generateRand(int n);

struct node
{
    /* data */
    int val;
    struct node* next;
};

struct node* head = NULL;


void Insert(int val) {
    struct node *temp, *ptr;
    temp=(struct node *)malloc(sizeof(struct node));

    temp->val = val;
    temp->next = NULL;

    if(head == NULL) {
        head = temp;
        printf("Inserted %d to header\n", val);
        return;
    }
    ptr = head;
    while(ptr->next != NULL) {
        ptr = ptr->next;
    }

    ptr->next = temp;
    printf("Inserted %d\n", val);
    return;
}

void Delete(int val) {
    struct node *ptr, *ptrPrev;
    if(head == NULL) {
        printf("List is empty\n");
        return;
    }
    
    ptr = head;
    if(head->val == val) {
        head = ptr->next;
    }
    ptrPrev = ptr;
    ptr = ptr->next;
    while(ptr != NULL) {
        if(ptr->val == val) {
            ptrPrev->next = ptr->next;
            free(ptr);
            printf("Member %d is deleted\n", val);
            return;
        }
        ptrPrev = ptr;
        ptr = ptr->next;
    }
    printf("Val %d not found\n", val);
    return;
}

bool Member(int val) {
    struct node* ptr;
    ptr = head;

    while(ptr != NULL) {
        if(ptr->val == val) {
            printf("Member %d found\n", val);
            return true;
        }
        ptr = ptr->next;
    }
    printf("Member %d not found\n", val);
    return false;
}

void FreeList() {
    struct node *temp;
    while (head != NULL) {
        temp = head;
        head = head->next;
        free(temp);
    }
}

int main() {
    int* arr = generateRand(10000);
    for(int i=0; i<10; i++) {
        printf("%d\n",arr[i]);
    }
    // Insert(3);
    // Insert(5);
    // Insert(7);
    // Member(8);
    // Insert(9);
    // Delete(9);
    // Delete(8);
    return 0;
}