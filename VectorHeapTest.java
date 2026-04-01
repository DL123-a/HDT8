public class VectorHeapTest {
    public static void main(String[] args) {

        VectorHeap<Integer> heap = new VectorHeap<>();

        heap.add(5);
        heap.add(2);
        heap.add(8);
        heap.add(1);

        System.out.println("Debe salir 1: " + heap.remove());
        System.out.println("Debe salir 2: " + heap.remove());
        System.out.println("Debe salir 5: " + heap.remove());
        System.out.println("Debe salir 8: " + heap.remove());
    }
}