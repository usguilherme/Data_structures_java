import java.util.ArrayList;
import java.util.List;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

    protected T data;
    protected RecursiveSingleLinkedListImpl<T> next;

    public RecursiveSingleLinkedListImpl() {
        // Construtor padrão
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public RecursiveSingleLinkedListImpl<T> getNext() {
        return next;
    }

    public void setNext(RecursiveSingleLinkedListImpl<T> next) {
        this.next = next;
    }

    /* ====================== NÍVEL FÁCIL ====================== */

    @Override
    public boolean isEmpty() {
        return this.data == null; //Apenas verificando sé meu data do meu nó atual é vázio
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        } else {
            return 1 + next.size(); //Depois soma os retornos
        }
    }

    @Override
    public boolean contains(T element) {
        if (this.isEmpty() || element == null) { //Se minha lista é vázia, ou meu elemento é nulo, não encontro nada
            return false;
        }
        if (this.data.equals(element)) { //se minha data do meu nó atual é igual ao meu elemento, retorno verdadeiro
            return true;
        }
        return this.next.contains(element); //Chamada recursiva para o next
    }

    @Override
    public T search(T element) {
        if (this.isEmpty() || element == null) { //Caso base, se minha lista é vázia, ou meu elemento é nulo, não procuro nada
            return null;
        }
        if (this.data.equals(element)) { //Se eu encontrar uma data do meu nó atual, retorno a data
            return this.data;
        }
        return this.next.search(element); //Chamada recursiva para o next
    }

    @Override
    public T searchPosition(int position) {
        if (this.isEmpty() || position < 0) { //Se minha lista é vázia ou minha posição é menor que 0, não tem como eu fazer nada
            return null;
        }
        if (position == 0) {
            return this.data;
        } else {
            return this.next.searchPosition(position - 1); //Vou removendo os meus elementos, até chegar em 0, quando chegar em 0, significa que eu fiz n diminuiçoes, onde N é igual a position
        }

    }

    @Override
    public T[] toArray() {
        List<T> listAux = new ArrayList<>();
        toArray(listAux);
        return (T[]) listAux.toArray();
    }

    private void toArray(List<T> listAux) {
        if (!isEmpty()) {
            listAux.add(this.data);
            this.next.toArray(listAux);
        }
    }

    /* ====================== NÍVEL MÉDIO ====================== */

    @Override
    public void insertFirst(T element) {
        // TODO: Insere um elemento no início da lista
        throw new UnsupportedOperationException("Unimplemented method 'insertFirst'");
    }

    @Override
    public void insertLast(T element) {
        // TODO: Insere um elemento no final da lista
        throw new UnsupportedOperationException("Unimplemented method 'insertLast'");
    }

    @Override
    public void removeFirst() {
        // TODO: Remove o primeiro elemento da lista
        throw new UnsupportedOperationException("Unimplemented method 'removeFirst'");
    }

    @Override
    public void removeLast() {
        // TODO: Remove o último elemento da lista
        throw new UnsupportedOperationException("Unimplemented method 'removeLast'");
    }

    /* ====================== NÍVEL DIFÍCIL ====================== */

    @Override
    public void insertPosition(int position, T element) {
        // TODO: Insere um elemento em uma posição específica
        throw new UnsupportedOperationException("Unimplemented method 'insertPosition'");
    }

    @Override
    public void removePosition(int position) {
        // TODO: Remove o elemento na posição fornecida
        throw new UnsupportedOperationException("Unimplemented method 'removePosition'");
    }

    @Override
    public void removeValue(T element) {
        // TODO: Remove a primeira ocorrência do elemento fornecido
        throw new UnsupportedOperationException("Unimplemented method 'removeValue'");
    }

    @Override
    public boolean isPalindrome() {
        // TODO: Verifica se a lista forma um palíndromo
        throw new UnsupportedOperationException("Unimplemented method 'isPalindrome'");
    }

}
