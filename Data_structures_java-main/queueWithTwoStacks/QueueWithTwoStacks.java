import java.util.Stack;

public class QueueWithTwoStacks<T> {
    private Stack<T> inputStack; //Pilha de entrada
    private Stack<T> outputStack; //Pilha de saída
    private int capacity;
    
    public QueueWithTwoStacks(int capacity) {
        this.inputStack = new Stack<T>();
        this.outputStack = new Stack<T>();
        this.capacity = capacity;
    }

    public void enqueue(T element) {
        if (isFull()) {
            throw new IllegalArgumentException("Queue is full");
        }
        inputStack.push(element);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        if (outputStack.isEmpty()) { //Se minha pilha de saída estiver vázia, tenho que inverter a ordem
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.pop();
    }

    public boolean contains(T element) {
    if (isEmpty()) {
        throw new IllegalArgumentException("Queue is empty");
    }
    for (int i = 0; i < inputStack.size(); i++) {
         if (inputStack.get(i).equals(element)) {
            return true;
        }
    }

    for (int j = 0; j < outputStack.size(); j++) {
        if (outputStack.get(j).equals(element)) {
            return true;
        }
    }

        return false;
    }
    
    public boolean isFull() {
        return inputStack.size() + outputStack.size() == capacity;
    }

    public boolean isEmpty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
    
    public int size() {
        return inputStack.size() + outputStack.size();
    }
}