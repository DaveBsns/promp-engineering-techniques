"""
This program implements Bubble Sort and sorts a sequence of numbers entered by the user.

**Input Handling:**

1. Prompt the user to enter a sequence of numbers (0-9) without separators.
2. Validate the input to ensure it consists of only digits (0-9).
3. Convert the user input string into a list of integers using list comprehension.

**Bubble Sort:**

1. Declare a function `bubble_sort()` that takes a list of integers as input.
2. Initialize a flag `is_sorted` to indicate whether the list is sorted.
3. Implement a nested loop:
    - Outer loop iterates through the list, comparing adjacent elements.
    - If two adjacent elements are in the wrong order, swap their positions.
    - Update the `is_sorted` flag to `False` if any swaps were made.
4. Stop iterating when the `is_sorted` flag remains `True` after an entire pass.
5. Return the sorted list.

**Output Handling:**

1. Call the `bubble_sort()` function to sort the user-entered list of numbers.
2. Print the sorted list as a comma-separated sequence of numbers using `join()`.
"""

def bubble_sort(numbers):
    """
    Sorts a list of integers using the Bubble Sort algorithm.

    Args:
        numbers (list): The list of integers to be sorted.

    Returns:
        list: The sorted list of integers.
    """

    is_sorted = False  # Boolean flag to indicate whether the list is sorted

    while not is_sorted:
        is_sorted = True  # Assume the list is sorted initially

        # Compare adjacent elements and swap if they are in the wrong order
        for i in range(len(numbers) - 1):
            if numbers[i] > numbers[i + 1]:
                is_sorted = False  # Sorting is not complete

                # Swap the elements
                numbers[i], numbers[i + 1] = numbers[i + 1], numbers[i]

    return numbers  # Return the sorted list

# User input section
user_input = input("Please enter a sequence of numbers (0-9) without separators: ")

# Input validation
if not user_input.isdigit():
    print("Invalid input. Please enter only numbers (0-9).")
    exit()

# Convert user input to list of integers
numbers = [int(digit) for digit in user_input]

# Sort the list using Bubble Sort
sorted_numbers = bubble_sort(numbers)

# Print the sorted list
print("The sorted list is:", ",".join(map(str, sorted_numbers)))
