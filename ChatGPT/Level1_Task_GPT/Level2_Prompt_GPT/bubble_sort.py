def bubble_sort(arr):
    """
    Bubble sort algorithm to sort a list of numbers in ascending order.

    Parameters:
    - arr (list): List of integers to be sorted.

    Returns:
    - list: Sorted list in ascending order.
    """
    n = len(arr)

    # Traverse through all array elements
    for i in range(n):
        # Last i elements are already sorted, so we don't need to check them
        for j in range(0, n-i-1):
            # Swap if the element found is greater than the next element
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]

    return arr


def main():
    # Get user input as a single string
    user_input = input("Enter a sequence of numbers (0-9) without separators: ")

    # Convert the input string into a list of integers
    numbers = [int(char) for char in user_input]

    # Check if all input numbers are within the range 0-9
    if all(0 <= num <= 9 for num in numbers):
        # Sort the list using the bubble_sort function
        sorted_numbers = bubble_sort(numbers)

        # Convert the sorted list into a comma-separated string
        sorted_string = ', '.join(map(str, sorted_numbers))

        # Output the sorted sequence
        print(f"Sorted Sequence: {sorted_string}")
    else:
        print("Please enter valid numbers between 0 and 9.")


# Run the program
if __name__ == "__main__":
    main()
