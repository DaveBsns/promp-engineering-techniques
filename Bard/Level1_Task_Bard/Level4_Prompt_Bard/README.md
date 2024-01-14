## Documentation Bubble Sort algorithm - Level 4 Prompt - Bard

**Prerequisites:**

1. **Python Installation:** Ensure you have Python installed on your system. You can download and install the latest version of Python from the official website: https://www.python.org/downloads/.
2. **Text Editor:** A text editor is required for editing the Python file. Popular options include Notepad++, Visual Studio Code, and Sublime Text.

**Steps to Set Up and Run the Program:**

1. **Download the Python File:** Download the Python file named `bubble_sort.py` from the provided link.
2. **Open the Python File:** Open the downloaded `bubble_sort.py` file in a text editor.
3. **Save the File:** Save the file in a convenient location on your system.
4. **Open a Terminal Window:** Open a terminal window or command prompt.
5. **Navigate to the File Directory:** Navigate to the directory containing the `bubble_sort.py` file using the `cd` command.
6. **Run the Program:** Execute the following command in the terminal window:

**Bash**

```
python bubble_sort.py

```

The program will prompt you to enter a sequence of numbers without separators. Enter the desired sequence and press Enter. The program will then sort the list and display the sorted sequence as a comma-separated list.

**Purpose:**

This program implements the Bubble Sort algorithm to sort a sequence of numbers entered by the user.

**How to Use:**

1. Open the Python file (`bubble_sort.py`) in a text editor.
2. Save the file.
3. Open a terminal window and navigate to the directory containing the Python file.
4. Run the program using the following command:

**Bash**

```
python bubble_sort.py

```

**Setup:**

The program does not require any additional setup or installation. Python and the standard library are sufficient to run the program.

**Functionality and Purpose of Each Section:**

- **Input Handling:**
    - `promptUserInput()`: Prompts the user to enter a sequence of numbers.
    - `validateInput()`: Validates the input to ensure it consists of only digits (0-9).
    - `convertInputToList()`: Converts the user input string into a list of integers.
- **Bubble Sort:**
    - `bubbleSort()`: Implements the Bubble Sort algorithm to sort the list of numbers.
    - `swapElements()`: Swaps two elements in the list based on their order.
- **Output Handling:**
    - `printSortedList()`: Prints the sorted list as a comma-separated sequence of numbers.