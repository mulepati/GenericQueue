import java.util.Arrays;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;


public class Queue<E> {
    private int top = -1;
    private E[] elements = (E[]) new Object[10];



    public void add(E value) {
        if(top >= elements.length - 1) {
            expandSize();
        }
        elements[++top] = value;
    }

    public E peek() {
        if(top < 0) {
            throw new NoSuchElementException();
        }

        return elements[0];
    }

    public E remove() {
        if(top < 0) {
            throw new NoSuchElementException();
        }
        E store = elements[0];
        remove(0);
        return store;

    }

    public void removeDuplicates() {
        if(top < 0) {
            throw new NoSuchElementException();
        }
        Set<E> sets = new HashSet<>();
        for (int i = 0; i <= top; i++) {
            if(!sets.contains(elements[i])) {
                sets.add(elements[i]);
            } else{
                remove(i);
            }
        }
    }

    public void removeAll(E value) {
        if(top < 0) {
            throw new NoSuchElementException();
        }
        int numSwaps = 0;
        for (int y = 0; y < top; y++) {
            if(elements[y - numSwaps].equals(value)) {
                remove(y - numSwaps);
                numSwaps++;
            }
        }

    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Queue<?> && ((Queue<?>) obj).size() == this.size()) {
            for (int i = 0; i <= top; i++) {
                if (!((Queue<?>) obj).get(i).equals(this.get(i))) {
                    return false;
                }
            }

            return true;
        }

        return false;

    }

    public E get(int index) {
        if (top < index) {
            throw new NoSuchElementException();
        }

        return elements[index];
    }

    public int size() {
        return top + 1;
    }
    private void expandSize() {
        int increasedSize = elements.length * 2;
        elements = Arrays.copyOf(elements, increasedSize);
    }

    private void remove(int index) {
        if(top < 0) {
            throw new NoSuchElementException();
        }
        for (int i = index; i < elements.length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        top--;
    }
}
