package course.task;

/**
 * Динамический массив
 */
public class DynamicArray extends StaticArray implements Dynamic {

    private static final int DEFAULT_CAPACITY = 10;
    private static final float GROW_FACTOR = 1.5f;

    /**
     * текущая длина массива
     */
    private int size;

    public DynamicArray() {
        super(new int[DEFAULT_CAPACITY]);
        size = 0;
    }

    public DynamicArray(int[] array) {
        super(array);
        size = array.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int value) {
        // TODO: добавить элемент в конец массива

        int newArrayLength = array.length + 1;
        int[] arrayPlusOne = new int[newArrayLength];
        for (int i = 0; i < array.length; i++) {
            arrayPlusOne[i] = array[i];
        }
        arrayPlusOne[array.length] = value;

        array = arrayPlusOne;
    }

    @Override
    public void add(int index, int value) {
        // TODO: добавить элемент в указанный индекс (остальные сдвинуть вправо)
        int newArrayLength = array.length + 1;
        int[] arrayPlusOne = new int[newArrayLength];
        for (int i = 0, j = 0; i < array.length + 1; i++, j++) {
            if (i == index) {
                arrayPlusOne[i] = value;
                i++;
            }
            arrayPlusOne[i] = array[j];
        }
        array = arrayPlusOne;

    }

    @Override
    public void addAll(Array array) {
        // TODO: конкатенация с переданным массивом
        int[] concatArray = new int[this.array.length + array.size()];
        int count = 0;
        for (int i = 0; i < this.array.length; i++) {
            concatArray[i] = this.array[i];
            count++;
        }
        for (int j = 0; j < array.size(); j++) {
            concatArray[j + count] = array.get(j);
        }
        this.array = concatArray;
    }

    @Override
    public boolean remove(int value) {
        // TODO: удалить элемент из массива
        int[] lessArray = new int[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++, j++) {
            if (array[i] == value) {
                i++;
            }
            lessArray[j] = array[i];
        }
        array = lessArray;
        return false;
    }

    @Override
    public boolean removeAll(int[] values) {
        // TODO: удалить все указанные элементы из массива
        int[] lessArray = new int[array.length - values.length];
        for (int i = 0, j = 0; i < array.length; i++, j++) {
            for (int k = 0; k < values.length; k++) {
                if (array[i] == values[k]) {
                    i++;
                }
                lessArray[j] = array[i];
            }
        }
        array = lessArray;
        return false;
    }

    @Override
    public int removeOf(int index) {
        // TODO: удалить элемент по индексу
        int[] lessArray = new int[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++, j++) {
            if (i == index) {
                i++;
            }
            lessArray[j] = array[i];
        }
        array = lessArray;
        return 0;
    }
}
