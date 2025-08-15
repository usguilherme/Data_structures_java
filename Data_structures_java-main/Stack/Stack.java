public class Stack<T> {
    private T[] array;
    private int head;
    private int capacity;
    private int size;
    
    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        this.array = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.head = -1;
        this.size = 0;
    }

    public void push(T element) {
        if (isFull()) { // CORRIGIDO: nome padronizado
            throw new IllegalArgumentException("Stack is full");
        }
        head++;
        size++;
        array[head] = element;
    }

    public T pop() {
        if (isEmpty()) { // CORRIGIDO: nome padronizado
            throw new IllegalArgumentException("Stack is empty");
        }
        T element = array[head];
        array[head] = null;
        head--;
        size--;
        return element;
    }

    public T peek() {
        if (isEmpty()) { // CORRIGIDO: nome padronizado
            throw new IllegalArgumentException("Stack is empty");
        }
        
        return array[head];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() { // CORRIGIDO: nome padronizado
        return head == -1;
    }

    public boolean isFull() { // CORRIGIDO: nome padronizado
        return head + 1 == capacity;
    }

    // Retorna o elemento no índice passado
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }
        return array[index];
    }
}
