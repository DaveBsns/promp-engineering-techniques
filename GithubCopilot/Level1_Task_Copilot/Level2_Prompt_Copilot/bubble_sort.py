# This function sorts a list of numbers using the bubble sort algorithm
def bubble_sort(numbers):
    # Get the total number of numbers
    n = len(numbers)
    
    # Traverse through all numbers
    for i in range(n):
        # Last i numbers are already in place, so we skip them
        for j in range(0, n-i-1):
            # Traverse the list from 0 to n-i-1
            # Swap if the number found is greater than the next number
            if numbers[j] > numbers[j+1]:
                numbers[j], numbers[j+1] = numbers[j+1], numbers[j]
    
    # Return the sorted list of numbers
    return numbers

# Ask the user for a sequence of numbers
user_input = input("Enter a sequence of numbers between 0 and 9 without any separators: ")

# Convert the input string into a list of integers
numbers = [int(num) for num in user_input]

# Sort the numbers
sorted_numbers = bubble_sort(numbers)

# Print the sorted numbers, separated by commas
print(", ".join(map(str, sorted_numbers)))