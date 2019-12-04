import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class StackTrain<T> implements Collection {

    private Object[] elementData;
    private int size;

    public StackTrain() {
    }

    public int size() {
        if (elementData == null) throw new NullPointerException("Stack is null");
        return size;
    }

    public boolean isEmpty() {
        if (elementData == null) throw new NullPointerException("Stack is null");
        return size == 0;
    }

    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(o)) return true;
        }
        return false;
    }

    public Iterator iterator() {
        return null;
    }

    public Object[] toArray() {
        return elementData;
    }

    public boolean add(Object o) {
        if (size == 0) {
            elementData = new Object[10];
            elementData[size] = o;
            size++;
            return true;
        }
        if (size < elementData.length - 1) {
            elementData[size] = o;
            size++;
            return true;
        } else {
            elementData = Arrays.copyOf(elementData, size * 2);
            elementData[size] = o;
            size++;
            return true;
        }
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean remove() {
        if(size == 0) return false;
        elementData[size - 1] = null;
        size--;
        return true;
    }

    public Object get() {
        if(size == 0) throw new NullPointerException("Stack is null");
        return elementData[size - 1];
    }

    public boolean addAll(Collection c) {
        return false;
    }

    public void clear() {

    }

    public boolean retainAll(Collection c) {
        return false;
    }

    public boolean removeAll(Collection c) {
        return false;
    }

    public boolean containsAll(Collection c) {
        return false;
    }

    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
