package Laboration2;

import java.util.Iterator;

// "E" ärver från comparable, skriver över equals() i mayagudar
public class Kedja<E extends Comparable<E>> extends Mayagudar implements Iterable<E>{

    private Node<E> head, tail;
    private int size = 0;

    public Kedja() {
    }

    // Om det finns element i listan returnera head som är första objektet i listan
    public E getFirst() {
        if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }

    // newNode ska läggas in på första index, sätter head till newNode och nuvarande head till nästa index
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;

        if(tail==null){
            tail = head;
        }
    }

    //  newNode ska läggas in på sista index, sätter tail till newNode och nuvarande tail till nästa index
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Lägger till element i ordning (lexikografiskt enligt namn)
    public void addInOrder(E e) {

        // Om det inte finns någon nod, lägg till på första position
        if (tail == null) {
            addFirst(e);
        }
        // Om elementet är "mindre" än det första elementet, lägg till på första position
        else if (e.compareTo(head.element) < 0) {
            addFirst(e);
        }
        // Om elementet är "större eller lika med" det första, stega igenom tills det inte längre är sant
        else {
            Node<E> nuvarande = head;
            try {
                while (e.compareTo(nuvarande.next.element) >= 0) {
                    nuvarande = nuvarande.next;
                }
                Node nyNod = new Node<>(e);
                nyNod.element = e;
                nyNod.next = nuvarande.next;
                nuvarande.next = nyNod;
                size++;
            } catch (NullPointerException fel){
                addLast(e);
            }
        }
    }

    // Ta bort första elementet
    public void removeFirst() {
        head = head.next;
        size--;
        if (head == null) {
            tail = null;
        }

    }

    public int size() {
        return size;
    }

    public void removeLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }  else if (size == 1) {
            head = tail = null;
            size = 0;
        } else {
            Node<E> current = head;
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            tail = current;
            tail.next = null;
            size--;
        }
    }

    // Ta bort element på specificerat index
    public void removeAt(int index) {
        // Om index finns i listan
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }  else {
            if (index == 0) {
                removeFirst();
            } else {
                Node previous = head;
                for (int i = 1; i < index; i++) {
                    previous = previous.next;
                }
                Node current = previous.next;
                previous.next = current.next;
                size--;
            }
        }
    }

    public void addAt(int index, E e) {
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            size++;
        }
    }

    public boolean contains(E e) {
        Node<E> search = head;

        while (search != null) {
            if (search.element.equals(e)) {
                return true;
            }
            search = search.next;
        }
        return false;
    }

    public E getAt(int index) {
        Node<E> current = head;

        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E>{
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            E element = current.element;
            current = current.next;
            return element;
        }
    }

}
