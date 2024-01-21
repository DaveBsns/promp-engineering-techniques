def bubble_sort(arr):
     """
     Sorts a list of integers in ascending order using the bubble sort algorithm.

     Parameters:
     arr (list): The list of integers to be sorted.

     Returns:
     list: The sorted list of integers.
     """
     n = len(arr)
     for i in range(n):
          for j in range(0, n-i-1):
                if arr[j] > arr[j+1]:
                     arr[j], arr[j+1] = arr[j+1], arr[j]
     return arr

def program_setup_instructions():
     """
     Provides instructions on setting up and running the program.

     Returns:
     str: The program setup instructions.
     """
     instructions = """
     Program Setup Instructions:
     
     1. Install Python:
         - Visit the official Python website at https://www.python.org/downloads/.
         - Download the latest version of Python for your operating system.
         - Run the installer and follow the installation instructions.
     
     2. Install any necessary dependencies:
         - This program does not require any additional dependencies.
     
     3. Save the bubble_sort.py file:
         - Create a new directory on your computer to store the program files.
         - Save the bubble_sort.py file in the directory.
     
     4. Run the program:
         - Open a terminal or command prompt.
         - Navigate to the directory where the bubble_sort.py file is saved.
         - Run the following command: python bubble_sort.py
         - The program will prompt you to enter a list of integers to be sorted.
         - Enter the integers separated by spaces and press Enter.
         - The program will display the sorted list of integers.
     
     That's it! You have successfully set up and run the program.
     """
     return instructions

# User input handling
user_input = input("Enter a sequence of numbers (0-9) without separators: ")
arr = [int(char) for char in user_input]

# Example usage:
bubble_sort(arr)

print("Sorted array:", ', '.join(map(str, arr)))
