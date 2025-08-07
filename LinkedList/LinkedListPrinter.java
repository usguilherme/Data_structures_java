public class LinkedListPrinter<T> {

    // Método para imprimir a lista ligada de forma recursiva
    public void printListRecursively(ListNode<T> head) {
        if (head == null) return; //Caso base, lista acabou
        System.out.println(head.data); //Printar meu valor atual (data)
        printListRecursively(head.next); //Chamar minha função novamente, só que para o próximo
    }

    // Método para imprimir a lista ligada de trás para frente (recursivamente)
    public void printListReverseRecursively(ListNode<T> head) {
        if (head == null) return; //Caso base, lista acabou
        printListReverseRecursively(head.next); //Chamada recursiva para ir pro final da lista, parando no caso brase
        System.out.println(head.data); //Printando data de trás pra frente
    }

    // Verifica se a lista contém o elemento passado, retorna true se encontrar, false caso contrário
    public boolean containsElement(ListNode<T> head, T element) {
        if (head == null) return false; //Caso base, lista acabou
        
        if (head.data.equals(null)) { //Apenas tratando caso o usuario coloque null
            if (element.equals(null)) {
                return true;
            }
        }
        else if (head.data.equals(element)) { //Encontrou o elemento
            return true;
        }
        return containsElement(head.next, element); //Chamando função recursiva novamamente
    }

    // Insere um novo nó com o valor 'element' no final da lista ligada
    public ListNode<T> insertAtEnd(ListNode<T> head, T element) {
        if (head == null) { //Estou no último elemento ou minha lista está vázia
            return new ListNode<>(element); //Crio um novo nó, com a data(element), e com o next null
        }
        head.next = insertAtEnd(head.next, element); //chamando minha função recursiva, até chegar no final da lista e adicionar um nó novo, com o element e o next null
        return head; //Mantendo o head da lista, pois eu apenas inseri um elemento, e não coloquei um head novo.




    
}


}
