#include <stdio.h>

void printSpaces(int spaces) {
    for (int i = 0; i < spaces; ++i) {
        printf(" ");
    }
}

void printStars(int stars) {
    for (int i = 0; i < stars; ++i) {
        printf("*");
    }
}

void printTree(int height) {
    for (int i = 1; i <= height; ++i) {
        printSpaces(height - i);
        printStars(2 * i - 1);
        printf("\n");
    }

    // Print the tree trunk
    printSpaces(height - 1);
    printf("| |\n");
    printSpaces(height - 1);
    printf("|_|\n");
}

int main() {
    int treeHeight;

    // Get the height of the tree from the user
    printf("Enter the height of the Christmas tree: ");
    scanf("%d", &treeHeight);

    // Ensure the height is at least 2
    if (treeHeight < 2) {
        printf("Height must be 2 or greater.\n");
        return 1;  // Exit with an error code
    }

    // Print the Christmas tree
    printTree(treeHeight);

    return 0;  // Exit successfully
}
