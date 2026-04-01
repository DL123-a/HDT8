import java.util.ArrayList;

/**
 * Implementación de una cola con prioridad usando un heap (min-heap).
 * 
 * @param <E> Tipo de dato que debe implementar Comparable
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {

    private ArrayList<E> data;

    /**
     * Constructor del heap.
     */
    public VectorHeap() {
        data = new ArrayList<>();
    }

    /**
     * Agrega un elemento al heap.
     * 
     * @param value elemento a agregar
     */
    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    /**
     * Remueve y retorna el elemento con mayor prioridad (mínimo).
     * 
     * @return elemento con mayor prioridad o null si está vacío
     */
    @Override
    public E remove() {
        if (isEmpty()) return null;

        E min = data.get(0);
        E last = data.remove(data.size() - 1);

        if (!data.isEmpty()) {
            data.set(0, last);
            percolateDown(0);
        }

        return min;
    }

    /**
     * Retorna el elemento con mayor prioridad sin eliminarlo.
     * 
     * @return elemento mínimo o null si está vacío
     */
    @Override
    public E peek() {
        if (isEmpty()) return null;
        return data.get(0);
    }

    /**
     * Retorna la cantidad de elementos en el heap.
     * 
     * @return tamaño del heap
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     * Indica si el heap está vacío.
     * 
     * @return true si está vacío, false en caso contrario
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Ajusta el heap hacia arriba (heapify-up).
     * 
     * @param index posición del elemento
     */
    private void percolateUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;

            if (data.get(index).compareTo(data.get(parent)) >= 0) break;

            swap(index, parent);
            index = parent;
        }
    }

    /**
     * Ajusta el heap hacia abajo (heapify-down).
     * 
     * @param index posición del elemento
     */
    private void percolateDown(int index) {
        int left, right, smallest;

        while (true) {
            left = 2 * index + 1;
            right = 2 * index + 2;
            smallest = index;

            if (left < data.size() &&
                data.get(left).compareTo(data.get(smallest)) < 0) {
                smallest = left;
            }

            if (right < data.size() &&
                data.get(right).compareTo(data.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest == index) break;

            swap(index, smallest);
            index = smallest;
        }
    }

    /**
     * Intercambia dos elementos del heap.
     * 
     * @param i índice 1
     * @param j índice 2
     */
    private void swap(int i, int j) {
        E temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }
}