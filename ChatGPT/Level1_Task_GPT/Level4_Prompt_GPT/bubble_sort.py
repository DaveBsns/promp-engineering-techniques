def get_user_input():
    """
    Prompt the user to enter a sequence of digits without spaces or commas,
    and convert the input string into a list of integers.

    Returns:
    - num_list: List of integers entered by the user.
    """
    while True:
        try:
            # Prompt the user for input
            user_input = input("Enter a sequence of digits (0-9) without spaces or commas: ")
            
            # Use list comprehension to convert each character to an integer
            num_list = [int(char) for char in user_input]
            
            return num_list
        except ValueError:
            # Handle invalid input (non-digit characters)
            print("Invalid input. Please enter only digits (0-9).")

# Example usage:
if __name__ == "__main__":
    # Get user input
    numbers = get_user_input()
    
    # Sorting the list using Bubble Sort algorithm
    # Note: This part can be replaced with any other sorting algorithm if needed
    n = len(numbers)
    for i in range(n):
        for j in range(0, n-i-1):
            if numbers[j] > numbers[j+1]:
                numbers[j], numbers[j+1] = numbers[j+1], numbers[j]

    # Displaying the sorted list in the desired format
    sorted_str = ', '.join(map(str, numbers))
    print("Sorted list:", sorted_str)
