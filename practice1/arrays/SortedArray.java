package course.task;

import java.util.Arrays;

/**
 * Сортированный статический массив (по возрастанию).
 * <p>
 * Любая операция должна гарантировать, что массив, по ее окончании, отстортирован
 */
public class SortedArray extends StaticArray {

    public SortedArray(int[] array) {
        super(array);
        if (!isAscSorted()) {
            sort();
        }
    }

    @Override
    public boolean contains(int value) {
        return binarySearch(value, 0, array.length) != -1;
    }

    @Override
    public int set(int index, int value) {
        // TODO: присовить значение по индексу
        array[index] = value;
        return 0;
    }

    @Override
    public int indexOf(int value) {
        return binarySearch(value, 0, array.length - 1);
    }

    @Override
    public int lastIndexOf(int value) {
        // TODO: получить индекс последнего подходящего элемента
        int lastIndex = -1;
        for (int i = 0; i < array.length; i++)
            lastIndex = binarySearch(value, i, array.length - 1);
        return lastIndex;
    }

    @Override
    public void sort() {
    }

//    @Override
//    public void sort(ArraySort sort) {}

    private int binarySearch(int value, int left, int right) {
        // TODO: реализовать бинарный поиск
        int first = 0;
        int last = array.length - 1;
        int position;

        position = (first + last) / 2;

        while ((array[position] != value) && (first <= last)) {
            if (array[position] > value) {
                last = position - 1;
            } else {
                first = position + 1;
            }
            position = (first + last) / 2;
        }
        return position;
    }

    public SortedArray merge(SortedArray other) {
        // TODO: произвести слиянеие двух сортированных массивов
        int[] c = new int[array.length + other.size()];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            c[i] = array[i];
            count++;
        }
        for (int j = 0; j < other.size(); j++) {
            c[count++] = other.get(j);
        }
        for (int i = 0; i < c.length; i++)
            System.out.print(c[i] + " ");
        return this;
    }


    public SortedArray mergeAll(SortedArray... others) {
        // TODO: произвести слиянеие N + 1 сортированных массивов
        int allLenth = 0;
        for (int i = 0; i < others.length; i++) {
            allLenth += others[i].size();
        }
        int[] c = new int[allLenth];
        int cout = 0;
        for (int i = 0; i < others.length; i++) {
            for (int j = 0; j < others[i].size(); j++) {
                c[cout + j] = others[i].get(j);
            }
            cout+=others[i].size();
        }
        array = c;
        return this;
    }
}
