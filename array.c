#include <stdio.h>

int arr[100];
int n = 0;

void insert() {
    int pos, value;
    printf("Enter position: ");
    scanf("%d", &pos);
    printf("Enter value: ");
    scanf("%d", &value);

    if (pos < 1 || pos > n + 1) {
        printf("Invalid position\n");
        return;
    }

    for (int i = n; i >= pos; i--) {
        arr[i] = arr[i - 1];
    }

    arr[pos - 1] = value;
    n++;

    printf("Element inserted successfully\n");
}

void delete() {
    int pos;
    printf("Enter position to delete: ");
    scanf("%d", &pos);

    if (pos < 1 || pos > n) {
        printf("Invalid position\n");
        return;
    }

    for (int i = pos - 1; i < n - 1; i++) {
        arr[i] = arr[i + 1];
    }

    n--;
    printf("Element deleted successfully\n");
}

void display() {
    if (n == 0) {
        printf("Array is empty\n");
        return;
    }

    printf("Array elements: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

void search() {
    int key, found = 0;
    printf("Enter element to search: ");
    scanf("%d", &key);

    for (int i = 0; i < n; i++) {
        if (arr[i] == key) {
            printf("Element found at position %d\n", i + 1);
            found = 1;
            break;
        }
    }

    if (!found)
        printf("Element not found\n");
}

void sort() {
    int temp;
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (arr[i] > arr[j]) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
    printf("Array sorted successfully\n");
}

int main() {
    int choice;

    while (1) {
        printf("\n--- Array Operations Menu ---\n");
        printf("1. Insert\n");
        printf("2. Delete\n");
        printf("3. Display\n");
        printf("4. Search\n");
        printf("5. Sort\n");
        printf("6. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
        case 1: insert(); break;
        case 2: delete(); break;
        case 3: display(); break;
        case 4: search(); break;
        case 5: sort(); break;
        case 6: return 0;
        default: printf("Invalid choice\n");
        }
    }
}
