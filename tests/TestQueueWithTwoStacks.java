public class TestQueueWithTwoStacks {
    public static void main(String[] args) {
        System.out.println("=== Testando QueueWithTwoStacks usando Stack e Queue importadas ===");
        
        QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>(5);
        
        // Teste enqueue
        System.out.println("Enfileirando: 1, 2, 3");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        System.out.println("Size: " + queue.size()); // Deve ser 3
        System.out.println("Is empty: " + queue.isEmpty()); // Deve ser false
        
        // Teste contains
        System.out.println("Contains 2: " + queue.contains(2)); // Deve ser true
        System.out.println("Contains 5: " + queue.contains(5)); // Deve ser false
        
        // Teste dequeue
        System.out.println("Desenfileirando: " + queue.dequeue()); // Deve ser 1 (FIFO)
        System.out.println("Desenfileirando: " + queue.dequeue()); // Deve ser 2
        
        // Adiciona mais elementos
        System.out.println("Enfileirando: 4, 5");
        queue.enqueue(4);
        queue.enqueue(5);
        
        System.out.println("Size após adicionar: " + queue.size()); // Deve ser 3
        
        // Continua desenfileirando
        System.out.println("Desenfileirando: " + queue.dequeue()); // Deve ser 3
        System.out.println("Desenfileirando: " + queue.dequeue()); // Deve ser 4
        System.out.println("Desenfileirando: " + queue.dequeue()); // Deve ser 5
        
        System.out.println("Is empty após desenfileirar tudo: " + queue.isEmpty()); // Deve ser true
        
        // Teste de capacidade máxima
        System.out.println("\nTeste de capacidade máxima:");
        QueueWithTwoStacks<String> stringQueue = new QueueWithTwoStacks<>(3);
        
        stringQueue.enqueue("A");
        stringQueue.enqueue("B");
        stringQueue.enqueue("C");
        
        System.out.println("Queue cheia: " + stringQueue.isFull()); // Deve ser true
        
        try {
            stringQueue.enqueue("D"); // Deve lançar exceção
        } catch (IllegalArgumentException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }
        
        System.out.println("Desenfileirando string: " + stringQueue.dequeue()); // Deve ser "A"
    }
}
