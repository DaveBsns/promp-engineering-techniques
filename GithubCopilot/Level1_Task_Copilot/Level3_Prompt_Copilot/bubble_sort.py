"""
Program to sort a sequence of numbers using the Bubble Sort algorithm.

To run the program:
1. Ensure that Python is installed on your system.
2. Run the program in a terminal using the command 'python bubble_sort.py'.
3. When prompted, enter a sequence of numbers without separators.
4. The program will output the sorted sequence of numbers, separated by commas.
"""

import sys

def bubble_sort(arr):
    """
    Sorts a list of integers in ascending order using the Bubble Sort algorithm.
    """
    n = len(arr)
    for i in range(n):
        for j in range(0, n-i-1):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
    return arr

# Prompt the user to enter a sequence of numbers without separators
user_input = input("Enter a sequence of numbers without separators: ")

# Convert the user input string into a list of integers
numbers = [int(num) for num in user_input]

# Sort the list of numbers using the Bubble Sort algorithm
sorted_numbers = bubble_sort(numbers)

# Convert the sorted list to a comma-separated sequence of numbers
output = ', '.join(map(str, sorted_numbers))

# Print the sorted, comma-separated sequence of numbers
print("Sorted sequence: ", output)