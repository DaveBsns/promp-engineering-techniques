def bubble_sort(array):
    is_sorted = False
    n = len(array)

    while not is_sorted:
        is_sorted = True

        for i in range(n - 1):
            if array[i] > array[i + 1]:
                array[i], array[i + 1] = array[i + 1], array[i]
                is_sorted = False

    return array

unsorted_list = [5, 2, 4, 1, 3]
sorted_list = bubble_sort(unsorted_list)
print(sorted_list)
