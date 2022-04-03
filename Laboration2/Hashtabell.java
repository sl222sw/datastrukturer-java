package Laboration2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Hashtabell<E extends Comparable> implements Iterable<E> {

    private LinkedList<E>[] hashtabell;
    private int size = 12;
    private int antalElement = 0;

    public Hashtabell(){
        hashtabell = new LinkedList[size];
    }

    private int hash(E e){
        int h = e.hashCode();
        if(h < 0){
            h = -h;
        }
        return h % size;
    }

    private void rehash(){
        LinkedList<E> gamlaVarden = new LinkedList<>();

        for(int i = 0; i < size; i++){
            if(hashtabell[i] != null){
                for (E e: hashtabell[i]){
                    gamlaVarden.add(e);
                }
            }
        }

        size = size * 2;
        antalElement = 0;
        hashtabell = new LinkedList[size];

        for(E e: gamlaVarden){
            this.add(e);
        }
    }

    public boolean contains(E e){
        int pos = hash(e);

        if(hashtabell[pos] != null){
            return hashtabell[pos].contains(e);
        }
        return false;
    }

    public void add(E e){
        int hink = hash(e);

        if(contains(e)){
            return;
        }

        if((double)antalElement / (double)size > 0.75){
            rehash();
        }
        if(hashtabell[hink] == null){
            hashtabell[hink] = new LinkedList<>();
        }
        hashtabell[hink].add(e);

        antalElement++;
    }

    public boolean remove(E e){
        if (!contains(e)){
            return false;
        }

        int pos = hash(e);

        if(hashtabell[pos] != null){
            boolean res = hashtabell[pos].remove(e);
            if(hashtabell[pos].isEmpty()){
                hashtabell[pos] = null;
            }
            antalElement--;
            return res;
        }
        return false;
    }

    public E max() {
        E max = null;

        for (int i = 0; i < hashtabell.length; i++) {
            if (hashtabell[i] != null) {
                // tilldelar max det sista "värdet" från hinken i hashtabellen
                max = hashtabell[i].element();
            }
        }
        for (int i = 0; i < hashtabell.length; i++) {
            if (hashtabell[i] != null) {
                for (E e : hashtabell[i]) { // för varje element i hinken
                    // om max är mindre än elementet i hinken, tilldela e till max
                    if (max.compareTo(e) < 0) {
                        max = e;
                    }
                }
            }
        }
        //Anropar toString(), toString() returnerar namnet
        return max;
    }

    public E min() {
        E min = null;    // tilldelar maxvärdet till null

        for (int i = 0; i < hashtabell.length; i++) {
            if (hashtabell[i] != null) {
                min = hashtabell[i].element();              // stegar igenom alla värden
            }
        }
        for (int i = 0; i < hashtabell.length; i++) {
            if (hashtabell[i] != null) {
                for (E e : hashtabell[i]) {  // för varje element i hinken
                    // om min är större än elementet i hinken, tilldela e till min
                    if (min.compareTo(e) > 0) {
                        min = e;
                    }
                }
            }
        }
        //Anropar toString(), toString() returnerar namnet
        return min;
    }

    public void visaHashtabell(){
        for(int i = 0; i < size; i++){
            System.out.println("[" + i + "]: ");
            if(hashtabell[i] == null){
                System.out.println("null");
            }
            else{
                for(E e: hashtabell[i]){
                    System.out.println(e + " -> ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new HashIterator();
    }
    private class HashIterator implements Iterator<E>{
        private ArrayList<E> lista = new ArrayList<>();
        private int nuvarande = 0;

        public HashIterator(){
            for(int i = 0; i < size; i++){
                if(hashtabell[i] != null){
                    for(E e: hashtabell[i])
                        lista.add(e);
                }
            }
        }

        public boolean hasNext(){
            if(nuvarande < lista.size()){
                return true;
            }
            else return false;
        }

        @Override
        public E next(){
            return lista.get(nuvarande++);
        }
    }
}




