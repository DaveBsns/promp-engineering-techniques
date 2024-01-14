def bubble_sort(numbers):
    is_sorted = False
    while not is_sorted:
        is_sorted = True
        for i in range(len(numbers) - 1):
            if numbers[i] > numbers[i + 1]:
                numbers[i], numbers[i + 1] = numbers[i + 1], numbers[i]
                is_sorted = False
    return numbers

# Prompt the user for input
user_input = input("Enter a sequence of numbers (0-9) without separators: ")

# Convert user input into a list of integers
numbers = list(map(int, user_input))

# Sort the list using bubble sort
sorted_numbers = bubble_sort(numbers)

# Print the sorted list in a comma-separated format
print("Sorted sequence:", ",".join(str(number) for number in sorted_numbers))
