public class RecursiveSingleLinkedListMethods<T> implements LinkedList<T> {

    // Supondo que você tenha um atributo para composição (pode ser modificado depois)
    private RecursiveSingleLinkedListImpl<T> node;

    public RecursiveSingleLinkedListMethods() {
        this.node = new RecursiveSingleLinkedListImpl<>();
    }

    @Override
    public boolean isEmpty() { //Verificando sé é vázio
        return node == null || node.getData() == null;
    }

    @Override
    public int size() {
        if (this.node.isEmpty()) { //Se meu atual nó for vázio
            return 0;
        } else {
            return 1 + this.node.getNext().size(); //Chamo a função size nele
        }
    }

    @Override
    public boolean contains(T element) {
        if (element == null || this.node.isEmpty()) {
            throw new IllegalArgumentException("Não é possivel analisar se um elemento está em uma linkedlist vázia, ou em um elemento nulo");
        }
        if (this.node.getData().equals(element)) { //Encontrei o elemento especifico
            return true;
        } else if (this.node.getNext() != null) { //evitar o NullPointerException
            return node.getNext().contains(element); //Chamo a função recursiva para o próximo nó
        } else {
            return false;
        }
    }

    @Override
    public T search(T element) {
        if (element == null || this.node.isEmpty()) {
            throw new IllegalArgumentException("Não é possível analisar se um elemento está em uma linked lista vázia, ou se o elemento é nulo");
        }
        if (this.node.getData().equals(element)) { //Achei o elemento
            return this.node.getData();
        } else if (this.node.getNext() != null) {
            return this.node.getNext().search(element); //Chamada recursiva
        } else {
            return null;
        }
    }
    @Override
    public T searchPosition(int position) {
        if (position < 0 || this.node.isEmpty()) {
            throw new IllegalArgumentException("Não é possível verificar se há algum elemento em uma posição, se a posição é negativo ou sé a linkedlist é vázia");
        }
        if (position == 0) {
            return this.node.getData();
        } else {
            return this.node.getNext().searchPosition(position - 1); //Chamada recursiva
        }
    }

    @Override
    public T[] toArray() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void insertFirst(T element) {
        throw new UnsupportedOperationException("Not implemented yet");
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
