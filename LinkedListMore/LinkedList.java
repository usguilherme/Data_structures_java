public interface LinkedList<T> {

    public boolean isEmpty();
    public int size();
    public T search(T element);
    public T searchPosition(int position);
    public void insertFirst(T element);
    public void insertLast(T element);
    public void insertPosition(int position, T element);    
    public void removeFirst();
    public void removeLast();
    public void removeValue(T element);
    public void removePosition(int position);
    public T[] toArray();
    public boolean contains(T element);
    public boolean isPalindrome();

}
