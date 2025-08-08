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
        if (element == null) {
            throw new IllegalArgumentException("Elemento não pode ser nulo");
        }
        if (isEmpty()) {
            this.data = element;
            this.next = new RecursiveSingleLinkedListImpl<>();
        } else {
            RecursiveSingleLinkedListImpl<T> newNode = new RecursiveSingleLinkedListImpl<>();
            newNode.data = this.data; //Criando um novo node com as variaveis atuais
            newNode.next = this.next; //Criando um novo node com as variaveis atuais

            this.data = element;
            this.next = newNode; //coloquei meu node que era o atual, como o segundo primeiro da lista e etc...
        }

    }

    @Override
    public void insertLast(T element) {
        if (element == null) {
            throw new IllegalArgumentException("O argumento não pode ser nulo");
        }
        if (isEmpty()) { //como está vázia, logo deve também inserir no ínicio, pois o inicio e o fim são as mesmas coisas
            this.data = element;
            this.next = new RecursiveSingleLinkedListImpl<>();
        } else { //Minha lista não é vázia
            this.next.insertLast(element); //Chamando minha função recursiva novamente, até eu chegar no último elemento e depois adiciona-lo
        }
    }

    @Override
    public void removeFirst() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Não é possível remover algo, em uma linkedlist vázia");
        }
        this.data = this.next.data;
        this.next = this.next.next;

    }

    @Override
    public void removeLast() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("LinkedList vázia");
        }
        if (this.next.isEmpty()) {
            this.data = null;
            this.next = null;
        } else {
            this.next.removeLast();
        }
    }

    /* ====================== NÍVEL DIFÍCIL ====================== */

   @Override
    public void insertPosition(int position, T element) {
        if (element == null) {
            throw new IllegalArgumentException("Não é possivel inserir um elemento nulo");
        }
        if (position < 0) {
            throw new IllegalArgumentException("Posição inválida");
        }
    
        if (position == 0) {
            if (this.isEmpty()) {
                // Lista vazia, insere direto
                this.data = element;
                this.next = new RecursiveSingleLinkedListImpl<>();
            } else {
                // Lista não vazia, cria nó novo empurrando dados atuais para frente
                RecursiveSingleLinkedListImpl<T> newNode = new RecursiveSingleLinkedListImpl<>();
                newNode.data = this.data;
                newNode.next = this.next;
            
                this.data = element;
                this.next = newNode;
            }
        } else {   
            if (this.isEmpty()) { //Pois eu tenho que chegar na posição correta e garantir que até lá nao é vazio
                throw new IndexOutOfBoundsException("Posição maior que o tamanho da lista");
            }
            this.next.insertPosition(position -1, element);
        }
    }

    @Override
    public void removePosition(int position) {
        if (this.isEmpty() || position < 0) {
            throw new IllegalArgumentException("Não é possível remover um elemento de uma lista vázia ou de uma posição inválida");
        }
        if (position == 0) {
            if (this.next != null) {
                this.data = this.next.data;
                this.next = this.next.next;
            } else {
                this.data = null;
                this.next = null;
            }
        } else {
            this.next.removePosition(position - 1);
        }
        
    }

    @Override
    public void removeValue(T element) {
        if (this.isEmpty()) { //Se minha lista for vázia, não tenho que fazer nada
            return;
        }
        if (this.data.equals(element)) {  //Encontrei uma data de um determinado nó, igual a element
            if (this.next != null) {
                this.data = this.next.data; //Substituindo o valor da esquerda com o da direita
                this.next = this.next.next; //Substituindo o valor da esquerda com o da direita
            } else {
                this.data = null; //Como é o último elemento, eu só faço remover 
                this.next = null; //Como é o último elemento, eu só faço remover 
            }
        } else {
            if (this.next != null) //não é o último da lista
            this.next.removeValue(element);
        }

    }

    @Override
    public boolean isPalindrome() {
        // TODO: Verifica se a lista forma um palíndromo
        throw new UnsupportedOperationException("Unimplemented method 'isPalindrome'");
    }

}
