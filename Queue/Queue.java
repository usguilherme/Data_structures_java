public class Queue<T> {
    private T[] array;
    private int size;
    private int capacity;
    
    public Queue(int capacity) {
        array = (T[]) new Object[size]; //Criei meu array
        this.capacity = capacity; //Tamanho definidio no ínicio
        this.size = 0;; //Tamanho atual de elementos do array
    }

    public void enqueue(T element) {
        if (QueueisFull()) {
            throw new IllegalArgumentException("Queue is full");
        }
        size++;
        array[size] = element;

    }

    public T dequeue() {
        if (QueueisEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }

        T element = array[0];
        shiftLeft();
        size--;
        return element;
    }

    public void shiftLeft() {
        for (int i = 0; i < capacity - 1; i++) {
            array[i] = array[i + 1];
        }
        array[capacity - 1] = null;
    }

    public T peek() {
        if (QueueisEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }

        return array[0];
    }


    public boolean QueueisFull() {
        return capacity == size;
    }

    public boolean QueueisEmpty() {
        return size == 0;
    }
}
