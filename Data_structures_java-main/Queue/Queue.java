public class Queue<T> {
    private T[] array;
    private int size;
    private int capacity;
    
    @SuppressWarnings("unchecked")
    public Queue(int capacity) {
        array = (T[]) new Object[capacity]; //Criei meu array
        this.capacity = capacity; //Tamanho definidio no ínicio
        this.size = 0; //Tamanho atual de elementos do array
    }

    public void enqueue(T element) {
        if (queueIsFull()) {
            throw new IllegalArgumentException("Queue is full");
        }
        array[size] = element;
        size++;
    }

    public T dequeue() {
        if (queueIsEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }

        T element = array[0];
        shiftLeft();
        size--;
        return element;
    }

    public void shiftLeft() {
        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        if (size > 0) {
            array[size - 1] = null;
        }
    }

    public T peek() {
        if (queueIsEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }

        return array[0];
    }

    public boolean queueIsFull() {
        return capacity == size;
    }

    public boolean queueIsEmpty() {
        return size == 0;
    }

    public int size() { // Método adicional que pode ser útil
        return size;
    }
    
}