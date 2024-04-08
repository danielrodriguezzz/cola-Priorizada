
public class PriorityQueue<E extends Comparable<E>> {

    private E[] heap;
    private int size;
    private int capacity;

    public PriorityQueue() {
        this(10); // Tamaño predeterminado del arreglo
    }

    public PriorityQueue(int initialCapacity) {
        this.heap = (E[]) new Comparable[initialCapacity];
        this.size = 0;
        this.capacity = initialCapacity;
    }

    public PriorityQueue(E[] data) {
        this.heap = (E[]) new Comparable[data.length + 1];
        this.capacity = data.length + 1;
        this.size = data.length;

        // Copiar elementos del arreglo proporcionado al arreglo heap
        System.arraycopy(data, 0, this.heap, 1, data.length);

        // Construir el heap
        for (int i = size / 2; i >= 1; i--) {
            sink(i);
        }
    }

    public void insert(E element) {
        if (size + 1 == capacity) {
            resize(capacity * 2);
        }
        heap[++size] = element;
        swim(size);
    }

    public E deleteMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        E max = heap[1];
        exch(1, size--);
        heap[size + 1] = null; // Eliminar la referencia para evitar el garbage collection
        sink(1);
        if (size > 0 && size == (capacity - 1) / 4) {
            resize(capacity / 2);
        }
        return max;
    }

    public E deleteMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        E min = heap[1];
        exch(1, size--);
        heap[size + 1] = null; // Eliminar la referencia para evitar el garbage collection
        sink(1);
        if (size > 0 && size == (capacity - 1) / 4) {
            resize(capacity / 2);
        }
        return min;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private void resize(int newCapacity) {
        E[] newHeap = (E[]) new Comparable[newCapacity];
        System.arraycopy(heap, 1, newHeap, 1, size);
        heap = newHeap;
        capacity = newCapacity;
    }

    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    private void exch(int i, int j) {
        E temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
public String mostrar(E[] heap) {
    StringBuilder sb = new StringBuilder();
    for (E elemento : heap) {
        sb.append(elemento).append(" ");
    }
    return sb.toString();
}



}
