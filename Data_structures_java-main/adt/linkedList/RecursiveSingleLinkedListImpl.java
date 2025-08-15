package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> {
    protected T data;
    protected RecursiveSingleLinkedListImpl<T> next;

    public RecursiveSingleLinkedListImpl() {
        // nó NIL inicial
    }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
    public RecursiveSingleLinkedListImpl<T> getNext() { return next; }
    public void setNext(RecursiveSingleLinkedListImpl<T> next) { this.next = next; }

    public boolean isEmpty() {
        return data == null;
    }

}
