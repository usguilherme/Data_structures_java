public class RecursiveSingleLinkedListMethods<T> implements LinkedList<T> {

    private RecursiveSingleLinkedListImpl<T> node;

    public RecursiveSingleLinkedListMethods() {
        this.node = new RecursiveSingleLinkedListImpl<>();
    }

    @Override
    public boolean isEmpty() {
        return node == null || node.getData() == null; //Verificando se é vázio
    }

    @Override
    public int size() {
        if (node.isEmpty()) { //não conta o vázio
            return 0;
        } else {
            return 1 + node.getNext().size(); //conta o nó com data diferente de vázio
        }
    }

    @Override
    public boolean contains(T element) {
        if (node.isEmpty() || element == null) {
            throw new IllegalArgumentException("Erro");
        }
        if (node.getData().equals(element)) {
            return true;

        } else if (node.getNext() != null) {
            return node.getNext().contains(element); //Chamada recursiva
        }
        return false; 
    }

    @Override
    public T search(T element) {
        if (node.isEmpty() || element == null) {
            throw new IllegalArgumentException("Erro");
        }
        if (node.getData().equals(element)) {
            return node.getData();
            
        } else if (node.getNext() != null) {
            return node.getNext().search(element); //Chamada recursiva
        }
        return null; 
    }

    @Override
    public T searchPosition(int position) { //3
        if (node.isEmpty() || position < 0) {
            throw new IllegalArgumentException("Erro");
        }

        if(position == 0) { //Achei a posição
            return node.getData();
        } else {
            return node.getNext().searchPosition(position - 1); //Reduço a posição
        }
    }

    @Override
    public T[] toArray() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void insertFirst(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Erro");
        }
        if (node.isEmpty()) {
            node.setData(element);
            node.setNext( new RecursiveSingleLinkedListImpl<>());
        } else {
            RecursiveSingleLinkedListImpl newNode = new RecursiveSingleLinkedListImpl<>();
            newNode.setData(node.getData());
            newNode.setNext(node.getNext());
            
            node.setData(element);
            node.setNext(newNode);
        }
    }

    @Override
    public void insertLast(T element) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void removeFirst() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void removeLast() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void insertPosition(int position, T element) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void removePosition(int position) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void removeValue(T element) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public boolean isPalindrome() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
