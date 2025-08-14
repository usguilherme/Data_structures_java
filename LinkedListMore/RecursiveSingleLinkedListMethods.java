    public class RecursiveSingleLinkedListMethods<T> implements LinkedList<T> {

        private RecursiveSingleLinkedListImpl<T> node;

        public RecursiveSingleLinkedListMethods() {
            this.node = new RecursiveSingleLinkedListImpl<>();
        }

        @Override
        public boolean isEmpty() {
            return node == null || node.getData() == null; //Verificando se é vázio
        }

        @Override //Certo
        public int size() {
            if (node.isEmpty()) { //não conta o vázio
                return 0;
            } else {
                return 1 + node.getNext().size(); //conta o nó com data diferente de vázio
            }
        }

        @Override //Certo
        public boolean contains(T element) {
            if (node.isEmpty() || element == null) {
                throw new IllegalArgumentException("Erro");
            }
            if (node.getData().equals(element)) {
                return true;

            } else if (!node.getNext().isEmpty()) {
                return node.getNext().contains(element); //Chamada recursiva
            }
            return false; 
        }

        @Override //Certo
        public T search(T element) {
            if (node.isEmpty() || element == null) {
                throw new IllegalArgumentException("Erro");
            }
            if (node.getData().equals(element)) {
                return node.getData();
                
            } else if (!node.getNext().isEmpty()) {
                return node.getNext().search(element); //Chamada recursiva
            }
            return null; 
        }

        @Override //CERTO
        public T searchPosition(int position) { //3
            if (node.isEmpty() || position < 0) {
                throw new IllegalArgumentException("Erro");
            }

            if(position == 0) { //Achei a posição
                return node.getData();

            } else if (!node.getNext().isEmpty()){ //Erro do null
                return node.getNext().searchPosition(position - 1); //Reduço a posição
            } 
            return null;
        }

        //@Override
        //public T[] toArray() {
        //}


        @Override //CERTO
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
            if (element == null) {
                throw new IllegalArgumentException("Erro, elemento nulo");
            }
            if (node.isEmpty()) {
                node.setData(element);
                node.setNext(new RecursiveSingleLinkedListImpl<>());
            } else {
                node.getNext().insertLast(element);
            }        

        }

        @Override //Certo, para remover um primeiro elemento, basta atribuir o valor do nó atual como o valor do proximo nó dele
        public void removeFirst() {
            if (node.isEmpty()) {
                throw new IllegalArgumentException("ERRO, NÃO É POSSÍVEL REMOVER ALGO DE UMA LINKEDLIST VÁZIA");
            }
            node.setData(node.getNext().getData());
            node.setNext(node.getNext().getNext());
        }

        @Override //Certo
        public void removeLast() {
            if (node.isEmpty()) {
                throw new IllegalArgumentException("ERRO, NÃO É PÓSSIVEL REMOVER ALGO DE UMA LINKEDLIST VÁZIA");
            }

            if (node.getNext().isEmpty()) {
                node.setData(null); //coloco apenas o data como null, deixo o next normal
            } else {
                node.getNext().removeLast(); //Recursao
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
                    RecursiveSingleLinkedListImpl newNode = new RecursiveSingleLinkedListImpl<>();
                    newNode.setData(node.getData());
                    newNode.setNext(node.getNext());

                    node.setData(element);
                    node.setNext(newNode);
                } 
            } else {
                node.getNext().insertPosition(position - 1, element);
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
            if (position == 0) {
                node.setData(node.getNext().getData());
                node.setNext(node.getNext().getNext());

            } else {
                node.getNext().removePosition(position - 1);
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
                node.getNext().removeValue(element);
            }
        }

        @Override
        public boolean isPalindrome() {
            throw new UnsupportedOperationException("Not implemented yet");
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
    }
