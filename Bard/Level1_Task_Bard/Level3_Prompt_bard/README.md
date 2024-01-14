## Documentation Bubble Sort algorithm - Level 3 Prompt - Bard

**Setting up and Starting the Program:**

1. **Download or Install Python:** Ensure you have Python installed on your system. If not, download and install the latest version of Python from https://www.python.org/downloads/: https://www.python.org/downloads/.
2. **Save the Code:** Save the provided Python code (bubble_sort.py) in a suitable location on your computer.
3. **Open a Command Prompt:** Open the Command Prompt (Windows) or Terminal (macOS/Linux).
4. **Navigate to Code Directory:** Navigate to the directory where you saved the Python code (bubble_sort.py) using the `cd` command.
5. **Run the Program:** Execute the Python code using the `python bubble_sort.py` command.

**Program Documentation:**

**Functionality:**

This program takes a sequence of numbers (0-9) as input from the user and sorts the sequence using the Bubble Sort algorithm. It converts the input string into a list of integers, sorts the list, and outputs the sorted sequence in a comma-separated format.

**Controlling and Setting Up:**

1. **Input:** Enter the sequence of numbers (0-9) without any separators when prompted by the program.
2. **Output:** The sorted sequence of numbers will be displayed in a comma-separated format.

**Example Usage:**

`Enter a sequence of numbers: 12345
Sorted sequence: 1,2,3,4,5`

This example demonstrates how the program takes the input "12345" and sorts it to produce the output "1,2,3,4,5".

**Code Explanation**

The `bubble_sort` function implements the Bubble Sort algorithm. It takes a list of integers as input and returns the sorted list. The function iterates over the list, comparing adjacent elements and swapping them if they are in the wrong order. This process is repeated until the entire list is sorted.

The main part of the program prompts the user to enter a sequence of numbers and converts it to a list of integers using a list comprehension. The list comprehension iterates over each character in the input string and converts it to an integer.

The `sorted_numbers` variable holds the sorted list after it has been passed through the `bubble_sort` function. The `sorted_string` variable is then created by converting the sorted list of integers to a comma-separated sequence using `map()` and `str()` functions.

Finally, the program prints the sorted sequence of numbers to the console.