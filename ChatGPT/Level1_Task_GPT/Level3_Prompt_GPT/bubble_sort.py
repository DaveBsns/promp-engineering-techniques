# Step 1: Prompt the user to input a sequence of numbers without separators.
user_input = input("Enter a sequence of numbers (0-9) without separators: ")

# Step 2: Convert the input string into a list of integers using list comprehension.
numbers = [int(char) for char in user_input]

# Step 3: Implement the Bubble Sort algorithm to sort the list of numbers.
def bubble_sort(arr):
    n = len(arr)
    for i in range(n):
        for j in range(0, n-i-1):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]

# Step 4: Call the bubble_sort function to sort the list.
bubble_sort(numbers)

# Step 5: Convert the sorted list to a comma-separated string for output.
sorted_sequence = ",".join(map(str, numbers))

# Step 6: Print the sorted and comma-separated sequence of numbers.
print("Sorted Sequence:", sorted_sequence)
