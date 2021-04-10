package course.task;

import java.util.Arrays;


/**
 * Обертка над статическим массивом
 */
public class StaticArray implements Array {

    protected int[] array;

    public StaticArray(int[] a) {
        this.array = new int[a.length];
        System.arraycopy(a, 0, this.array, 0, a.length);
    }

    @Override
    public int size() {
        // TODO: вернуть длину массива
        return array.length;
    }

    @Override
    public boolean contains(int value) {
        // TODO: проверить, что элемент есть в массиве
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value)
                return true;
        }
        return false;
    }

    @Override
    public int get(int index) {
        // TODO: получить элемент по индексу
        return array[index];
    }

    @Override
    public int set(int index, int value) {
        // TODO: присвоить значение по индексу. Вернуть значение элемента, которое заменили
        int valueBefore = array[index];
        array[index] = value;
        return valueBefore;
    }

    @Override
    public int indexOf(int value) {
        // TODO: получить индекс первого подходящего элемента
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value)
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int value) {
        // TODO: получить индекс последнего подходящего элемента
        int lastIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value)
                lastIndex = i;
        }
        return lastIndex;
    }

    @Override
    public void reverse() {
        // TODO: перевернуть массив
        int tempValue;
        for (int i = 0; i < array.length / 2; i++) {
            tempValue = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tempValue;
        }
    }

    @Override
    public Array subArray(int fromIndex, int toIndex) {
        // TODO: вернуть подмассив, начиная с индекса fromIndex включительно и заканчивая индексом toIndex невкоючительно
        int newArrayLength = toIndex - fromIndex;
        int[] arrayFromTo = new int[newArrayLength];
        for (int i = fromIndex, j = 0; i < toIndex; i++, j++) {
            arrayFromTo[j] = array[i];
        }
        this.array = arrayFromTo;
        return this;
    }

    @Override
    public void sort() {
        bubbleSort();
    }

    @Override
    public void sort(ArraySort sort) {
        switch (sort) {
            case BUBBLE:
                bubbleSort();
                break;
            case INSERTION:
                insertionSort();
                break;
            case SELECTION:
                selectionSort();
                break;
            case MERGE:
                mergeSort();
                break;
            case QUICK:
                quickSort();
                break;
            default:
                sort();
        }
    }

    @Override
    public String toString() {
        // TODO: вернуть массив в виде строки. Например, [3, 4, 6, -2]
        String str = "";

        for (int i = 0; i < array.length; i++) {
            str += array[i];
        }

        return str;
    }

    private void bubbleSort() {
        // TODO: сортировка пузырьком (по возрастанию)
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private void insertionSort() {
        //TODO*: сортировка вставками (по возрастанию)
        for (int l = 0; l < array.length; l++) {
            int value = array[l];
            int i = l - 1;
            for (; i >= 0; i--) {
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }
            array[i + 1] = value;
        }
    }

    private void selectionSort() {
        //TODO*: сортировка выбором (по возрастанию)
        for (int left = 0; left < array.length; left++) {
            int minInd = left;
            for (int i = left; i < array.length; i++) {
                if (array[i] < array[minInd]) {
                    minInd = i;
                }
            }
            int temp = array[minInd];
            array[minInd] = array[left];
            array[left] = temp;
        }
    }

    private void mergeSort() {
        //TODO**: сортировка слиянием (по возрастанию)
        array = mergeSort(array, 0, array.length - 1);

    }

    private int[] mergeSort(int[] a, int lo, int hi) {

        if (hi <= lo)
            return a;
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid + 1, hi);

        int[] buf = Arrays.copyOf(a, a.length);

        for (int k = lo; k <= hi; k++) {
            buf[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {

            if (i > mid) {
                a[k] = buf[j];
                j++;
            } else if (j > hi) {
                a[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                a[k] = buf[j];
                j++;
            } else {
                a[k] = buf[i];
                i++;
            }
        }
        return a;
    }

    private void quickSort() {
        //TODO**: быстрая сортировка (по возрастанию)
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int low, int high) {
        int midIndex = low + (high - low) / 2;
        int midElement = array[midIndex];

        int i = low, j = high;
        while (i <= j) {
            while (array[i] < midElement) {
                i++;
            }

            while (array[j] > midElement) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    public boolean isAscSorted() {
        // TODO: проверить, что массив отсортирован по возрастанию
        for (int j = 0; j < array.length - 1; j++) {
            if (array[j] > array[j + 1]) {
                return false;
            }
        }
        return true;
    }

    public int[] getArray() {
        return array;
    }
}
