def bubble_sort(numbers):
    is_sorted = False
    while not is_sorted:
        is_sorted = True
        for i in range(len(numbers) - 1):
            if numbers[i] > numbers[i + 1]:
                numbers[i], numbers[i + 1] = numbers[i + 1], numbers[i]
                is_sorted = False
    return numbers

# Get user input
user_input = input("Enter a sequence of numbers: ")

# Convert user input to a list of numbers
numbers = []
for number in user_input:
    if number.isdigit():
        number = int(number)
        if 0 <= number <= 9:
            numbers.append(number)

# Sort the numbers using bubble sort
sorted_numbers = bubble_sort(numbers)

# Print the sorted numbers
print("Sorted numbers:", ','.join(map(str, sorted_numbers)))
