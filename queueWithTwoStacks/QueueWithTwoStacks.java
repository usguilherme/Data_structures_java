  public class QueueWithTwoStacks<T> {
    private Stack<T> inputStack; //Pilha de entrada
    private Stack<T> outputStack; //Pilha de saída
    private int capacity;
    
    public QueueWithTwoStacks(int capacity) {
        this.inputStack = new Stack<T>(capacity);
        this.outputStack = new Stack<T>(capacity);
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
        if (outputStack.stackIsEmpty()) { //Se minha pilha de saída estiver vázia, tenho que inverter a ordem
            while (!inputStack.stackIsEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.pop();
    }

    public boolean contains(T element) {
        // Verificar na inputStack sem destruir a pilha
        Stack<T> tempStack = new Stack<T>(capacity);
        boolean found = false;
        
        // Verifica inputStack
        while (!inputStack.stackIsEmpty()) {
            T current = inputStack.pop();
            tempStack.push(current);
            if (current != null && current.equals(element)) {
                found = true;
            }
        }
        
        // Restaura inputStack
        while (!tempStack.stackIsEmpty()) {
            inputStack.push(tempStack.pop());
        }
        
        // Se não encontrou, verifica outputStack
        if (!found) {
            while (!outputStack.stackIsEmpty()) {
                T current = outputStack.pop();
                tempStack.push(current);
                if (current != null && current.equals(element)) {
                    found = true;
                }
            }
            
            // Restaura outputStack
            while (!tempStack.stackIsEmpty()) {
                outputStack.push(tempStack.pop());
            }
        }
        
        return found;
    }

    public boolean isFull() {
        return inputStack.size() + outputStack.size() == capacity;
    }

    public boolean isEmpty() {
        return inputStack.stackIsEmpty() && outputStack.stackIsEmpty();
    }
    
    public int size() {
        return inputStack.size() + outputStack.size();
    }
}