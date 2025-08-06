import stack.Stack;   // importa a pilha
import queue.Queue;

public class QueueWithTwoStacks<T> {
    private T[] inputStack; //Pilha de entrada
    private T[] outputStack; //Pilha de saída
    
    public QueueWithTwoStacks(int capacity) {
        this.inputStack = (T[]) new Object[capacity];
        this.outputStack = (T[]) new Object[capacity]
        this.capacity = capacity
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
        if (outputStack.QueueisEmpty()) { //Se minha pilha de saída estiver vázia, tenho que inverter a ordem
            outputStack.push(inputStack.pop());
        }
        return outputStack.pop();
    }

    public boolean isFull() {
        return inputStack.size() + outputStack.size() == capacity
    }

    public boolean isEmpty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    
    


}
