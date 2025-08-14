package problems;

import adt.linkedList.RecursiveSingleLinkedListImpl;
import adt.linkedList.LinkedList;

public class RecursiveSingleLinkedListMethodsImpl<T> implements LinkedList<T> {

    private RecursiveSingleLinkedListImpl<T> node;

    public RecursiveSingleLinkedListMethodsImpl() {
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
            RecursiveSingleLinkedListMethodsImpl<T> nextList = new RecursiveSingleLinkedListMethodsImpl<>();
            nextList.node = node.getNext();
            return 1 + nextList.size(); //conta o nó com data diferente de vázio
        }
    }

    @Override
    public boolean contains(T element) {
        if (node.isEmpty() || element == null) {
            throw new IllegalArgumentException("Erro");
        }
        if (node.getData().equals(element)) {
            return true;
        } else if (!node.getNext().isEmpty()) {
            RecursiveSingleLinkedListMethodsImpl<T> nextList = new RecursiveSingleLinkedListMethodsImpl<>();
            nextList.node = node.getNext();
            return nextList.contains(element); //Chamada recursiva
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
        } else if (!node.getNext().isEmpty()) {
            RecursiveSingleLinkedListMethodsImpl<T> nextList = new RecursiveSingleLinkedListMethodsImpl<>();
            nextList.node = node.getNext();
            return nextList.search(element); //Chamada recursiva
        }
        return null; 
    }

    @Override
    public T searchPosition(int position) { 
        if (node.isEmpty() || position < 0) {
            throw new IllegalArgumentException("Erro");
        }
        if(position == 0) { //Achei a posição
            return node.getData();
        } else if (!node.getNext().isEmpty()) { //Erro do null
            RecursiveSingleLinkedListMethodsImpl<T> nextList = new RecursiveSingleLinkedListMethodsImpl<>();
            nextList.node = node.getNext();
            return nextList.searchPosition(position - 1); //Reduzo a posição
        } 
        return null;
    }

    @Override
    public void insertFirst(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Erro");
        }
        if (node.isEmpty()) {
            node.setData(element);
            node.setNext(new RecursiveSingleLinkedListImpl<>());
        } else {
            RecursiveSingleLinkedListImpl<T> newNode = new RecursiveSingleLinkedListImpl<>();
            newNode.setData(node.getData());
            newNode.setNext(node.getNext());
            node.setData(element);
            node.setNext(newNode);
        }
    }

    @Override
    public void insertLast(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Erro, elemento nulo");
        }
        if (node.isEmpty()) { // Lista vazia
            node.setData(element);
            node.setNext(new RecursiveSingleLinkedListImpl<>());
        } else if (node.getNext().isEmpty()) { // Último elemento
            RecursiveSingleLinkedListImpl<T> newNode = new RecursiveSingleLinkedListImpl<>();
            newNode.setData(element);
            newNode.setNext(new RecursiveSingleLinkedListImpl<>());
            node.setNext(newNode);
        } else { // Recursão
            RecursiveSingleLinkedListMethodsImpl<T> nextList = new RecursiveSingleLinkedListMethodsImpl<>();
            nextList.node = node.getNext();
            nextList.insertLast(element);
            node.setNext(nextList.node); // atualiza o next depois da recursão
        }        
    }

    @Override
    public void insertPosition(int position, T element) {
        if (position < 0 || element == null) {
            throw new IllegalArgumentException("ERRO");
        }
        if (position == 0) {
            if (node.isEmpty()) { //último elemento
                node.setData(element);
                node.setNext(new RecursiveSingleLinkedListImpl<>());
            } else {
                RecursiveSingleLinkedListImpl<T> newNode = new RecursiveSingleLinkedListImpl<>();
                newNode.setData(node.getData());
                newNode.setNext(node.getNext());
                node.setData(element);
                node.setNext(newNode);
            } 
        } else { // Recursão
            RecursiveSingleLinkedListMethodsImpl<T> nextList = new RecursiveSingleLinkedListMethodsImpl<>();
            nextList.node = node.getNext();
            nextList.insertPosition(position - 1, element);
            node.setNext(nextList.node);
        }
    }

    @Override
    public void removeFirst() {
        if (node.isEmpty()) {
            throw new IllegalArgumentException("ERRO, NÃO É POSSÍVEL REMOVER ALGO DE UMA LINKEDLIST VÁZIA");
        }
        node.setData(node.getNext().getData());
        node.setNext(node.getNext().getNext());
    }

    @Override
    public void removeLast() {
        if (node.isEmpty()) {
            throw new IllegalArgumentException("ERRO, NÃO É PÓSSIVEL REMOVER ALGO DE UMA LINKEDLIST VÁZIA");
        }
        if (node.getNext().isEmpty()) { // Último elemento
            node.setData(null);
        } else { // Recursão
            RecursiveSingleLinkedListMethodsImpl<T> nextList = new RecursiveSingleLinkedListMethodsImpl<>();
            nextList.node = node.getNext();
            nextList.removeLast();
            node.setNext(nextList.node);
        }
    }

    @Override
    public void removePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("Erro, posição menor que zero");
        }
        if (node.isEmpty()) {
            throw new IllegalArgumentException("Erro, lista vázia");
        }
        if (position == 0) { // Remover cabeça
            node.setData(node.getNext().getData());
            node.setNext(node.getNext().getNext());
        } else { // Recursão
            RecursiveSingleLinkedListMethodsImpl<T> nextList = new RecursiveSingleLinkedListMethodsImpl<>();
            nextList.node = node.getNext();
            nextList.removePosition(position - 1);
            node.setNext(nextList.node);
        }
    }

    @Override
    public void removeValue(T element) {
        if (element == null) {
            throw new IllegalArgumentException("ERRO, ELEMENTO NULO");
        }
        if (node.isEmpty()) { //Lista ou elemento vázio
            return;
        }
        if (node.getData().equals(element)) { //Achei
            node.setData(node.getNext().getData());
            node.setNext(node.getNext().getNext());
        } else { //Chamada recursiva
            RecursiveSingleLinkedListMethodsImpl<T> nextList = new RecursiveSingleLinkedListMethodsImpl<>();
            nextList.node = node.getNext();
            nextList.removeValue(element);
            node.setNext(nextList.node);
        }
    }

    @Override
    public T findMiddle() {
        if (node.isEmpty()) {
            return null;
        }
        return findMiddleEx(node,node);
    }

    public T findMiddleEx(RecursiveSingleLinkedListImpl<T> slow, RecursiveSingleLinkedListImpl<T> fast) {
        if (fast.isEmpty() || fast.getNext().isEmpty()) { //Se chegar no último elemento ou elemento for vázio
            return slow.getData(); //Retorno o do meio
        }
        return findMiddleEx(slow.getNext(), fast.getNext().getNext()); //Slow aumenta um, fast aumenta dois
    }

    @Override
    public void reverse() {
        if (!node.isEmpty()) {
            // Chamada recursiva direta, sem método auxiliar
            node = reverse(node);
        }
    }

    private RecursiveSingleLinkedListImpl<T> reverse(RecursiveSingleLinkedListImpl<T> current) {
        if (current.isEmpty() || current.getNext().isEmpty()) {
            return current; // nó único ou final
        }
        RecursiveSingleLinkedListImpl<T> newHead = reverse(current.getNext());
        current.getNext().setNext(current); //Proximo do meu próximo, vai ser meu atual
        current.setNext(new RecursiveSingleLinkedListImpl<>());
        return newHead;
    }

    @Override
    public T[] toArray() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public T removeMiddle() {
        if (node.isEmpty()) {
            return null;
        }
        return removeMiddleAux(node,node);
    }

    private T removeMiddleAux(RecursiveSingleLinkedListImpl<T> slow, RecursiveSingleLinkedListImpl<T> fast) {
        if (fast.isEmpty() || fast.getNext().isEmpty()) {  //Caso de parada, se for o último elemento ou já for vázio
            T result = slow.getData(); //Varíavel de controle

            if (slow.getNext() == null) { //Sendo o último da linkedlist, só faço atribuir o data como null
                slow.setNext(null);
            } else { //não sendo o último da linkedlist, atribuo o meu nó atual como os valores do seu sucessor
                slow.setData(slow.getNext().getData());
                slow.setNext(slow.getNext().getNext());
            }
            return result;
        }

        return removeMiddleAux(slow.getNext(), fast.getNext().getNext()); //Chamada recursiva
    }

    public boolean isPalindrome() {
        return isPalindromeAux(node, size()) != null;
    }

    private RecursiveSingleLinkedListImpl<T> isPalindromeAux(RecursiveSingleLinkedListImpl<T> array, int length) {
        if (array.isEmpty() || length == 0) { //Caso base, saída
            return array;
        }
        if (length == 1) { //Apenas retorno o elemento do proximo
            return array.getNext();
        }
        
        RecursiveSingleLinkedListImpl<T> comparador = isPalindromeAux(array.getNext(), length - 2); //Criar a variavel para eu comparar, verificando os elementos
        if (comparador == null) {
            return null;
        }

        if (!array.getData().equals(comparador.getData())) { //se não for igual
            return null;
        }

        return comparador.getNext(); //chamada recursiva

    }
}
