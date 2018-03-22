package ua.training;

import java.util.StringJoiner;

public class MyArrayList<N> {
    private final static int DEFAULT_MIN_CAPACITY = 10;
    private int size = 0;
    private N values[];

    public MyArrayList() {
        initValues(DEFAULT_MIN_CAPACITY);
    }

    public MyArrayList(int capacity) {
        initValues(capacity);
    }

    private void initValues(int capacity) {
        values = (N[]) new Object[capacity];
    }

    public void resize(int max) {
        if (max > size) {
            N[] tmp = (N[]) new Object[max];
            for (int i = 0; i < size; i++) {
                tmp[i] = values[i];
            }
            values = tmp;
        }
    }

    public int size() {
        return this.size;
    }

    public void add(N n) {
        if (size == values.length) {
            resize((int) (size * 1.5 + 1));
        }
        values[size++] = n;
    }

    public N get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("" + index);
        }
        return values[index];
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            sj.add(values[i].toString());
        }
        return sj.toString();
    }

    public int getCapacity() {
        return values.length;
    }

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        System.out.println(list.getCapacity());
    }
}
