#include <stdio.h>

int main() {
  int height = 10; // Change this value to adjust the height of the tree

  printf("   *\n");
  printf("  * *\n");
  printf(" *   *\n");
  printf("*      *\n");

  for (int i = 0; i < height - 3; i++) {
    printf("***");
    for (int j = 0; j < i; j++) {
      printf("  ");
    }
    printf("*\n");
  }

  printf("*********");

  return 0;
}
