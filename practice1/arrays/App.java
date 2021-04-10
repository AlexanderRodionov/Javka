package course.task;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 7, 8, 5, -7, -9, 6};

        var staticArray = new StaticArray(a);

        var dynamicArray = new DynamicArray(a);

        for (int i = 0; i < dynamicArray.size(); i++) {
            System.out.print(dynamicArray.array[i] + " ");
        }


        staticArray.reverse();
        //staticArray.subArray(3,7);

        //System.out.println(staticArray.toString());

        var sortedArray = new SortedArray(a);

        //dynamicArray.add(333);
        //dynamicArray.add(2, -555);
        int[] b = new int[]{3, 5, -9};

        var bArr = new DynamicArray(b);

        System.out.println("After: ");
        for (int i = 0; i < dynamicArray.size() + 1; i++) {
            //System.out.print(dynamicArray.array[i] + " ");
        }

        //BUBBLE, INSERTION, SELECTION, MERGE, QUICK

        sortedArray.sort(ArraySort.MERGE);
        //sortedArray.array[3] = -80;
        for (int i = 0; i < sortedArray.size(); i++) {
            System.out.print(sortedArray.array[i] + " ");
        }

        System.out.println("SORT??? " + sortedArray.isAscSorted());

        //var dynamicArray = new DynamicArray();
        //dynamicArray.add(5);
        //dynamicArray.add(10);
    }
}
