package adt.linkedList;

public interface LinkedList<T> {
    boolean isEmpty();
    int size();
    T search(T element);
    T searchPosition(int position);
    void insertFirst(T element);
    void insertLast(T element);
    void insertPosition(int position, T element);
    void removeFirst();
    void removeLast();
    void removeValue(T element);
    void removePosition(int position);
    T[] toArray();
    boolean contains(T element);
    boolean isPalindrome();
    T findMiddle();
    void reverse();
}
