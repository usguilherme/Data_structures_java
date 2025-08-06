public class Stack<T> {
    private T[] array;
    private int head;
    private int capacity;
    private int size;
    
    public Stack(int capacity) {
        this.array = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.head = -1;
        this.size = 0;
    }

    public void push(T element) {
        if (isFull()) {
            throw new IllegalArgumentException("Stack is full");
        }
        head++;
        size++;
        array[head] = element;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Stack is empty");
        }
        T element = array[head];
        array[head] = null;
        head--;
        size--;
        return element;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Stack is empty");
        }
        
        return array[head];
    }

    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return head + 1 == capacity;
    }



    
}
