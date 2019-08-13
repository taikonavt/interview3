import java.util.Iterator;

public class VectorList<E> implements Iterable<E> {
    private Node<E> node = null;
    private int counter = 0;

    public VectorList(){
        node = new Node<>();
    }

    public int size(){
        return  counter;
    }

    public void add(E element){
        if (counter == 0){    // Первый узел надо обработать отдельно, иначе элемент в нем будет балластом
            node.set(element);
        }
        else{
            node.add(element);
        }
        counter++;              // Увеличим счетчик элементов
    }
    @Override
    public VectorIterator<E> iterator() {
        return new VectorIterator(node);
    }
    // Узел с элементом сделан внутренним, чтобы не показывать его снаружи
    private class Node<E>{
        private E element;
        private Node<E> next = null;
        private Node<E> previous = null;

        Node(){}
        Node(E element, Node previous){
            set(element);
            this.previous = previous;
        }
        void set(E element){
            this.element = element;
        }
        void add(E element){
            if (isNext()){        // Если существует следующий узел, передадим ему эстафету
                next.add(element);
            }
            else{                  // Если нет – создадим следующий узел
                next = new Node<>(element, this);
            }
        }
        E get(){
            return element;
        }
        boolean isNext(){
            return next != null;
        }

        public boolean isPrevious() {
            return previous != null;
        }
    }
    // Итератор
    public class VectorIterator<E> implements Iterator<E> {
        private Node<E> current;
        // Первый узел надо обработать отдельно
        private boolean isFirst = true;
        VectorIterator(Node<E> node){
            current = node;
        }
        @Override
        public boolean hasNext() {
// Отдельно обработать один элемент (так как у него нет next)
            if (counter == 1 && isFirst) return true;
            return current.isNext();
        }
        @Override
        public E next() {
            if (isFirst) isFirst = false;
            else current = current.next;
            return current.get();
        }

        public boolean hasPrevious(){
            return current.isPrevious();
        }

        public E previous(){
            current = current.previous;
            if (!current.isPrevious()){
                isFirst = true;
            }
            return current.get();
        }

        @Override
        public void remove() {

        }
    }
}