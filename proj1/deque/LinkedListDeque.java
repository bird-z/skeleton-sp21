package deque;

import java.util.Iterator;
import java.util.Objects;

public class LinkedListDeque<T> {
    private  class Note{
       private Note first=null;
       private Note last=null;
       private T item;
       public Note(){

       }
       public Note(T item){
           this.item=item;
       }
    }

    private int size = 0;
    private final Note head =new Note();
    private final Note tail =new Note();

    public LinkedListDeque(){
//        head.first=null;
        head.last=tail;

//        tail.last=null;
        tail.first=head;
        size = 0;
    }
    public LinkedListDeque(T v){
        Note newNote  = new Note(v);

//        head.first=null;
        head.last=newNote;
        newNote.first=head;
        newNote.last=tail;
        tail.first=newNote;
//        tail.last=null;

        size = 1;
    }
    /**add note back of the  first
     * size add one*/
    public void addFirst(T item){
        Note NI=new Note(item);
        NI.first=head;
        NI.last=head.last;
        head.last.first=NI;
        head.last=NI;

        size += 1;
    }
    /**add note front of the tail
     * size add one */
    public void addLast(T item){
        Note NI= new Note(item);
        NI.first=tail.first;
        NI.last=tail;
        tail.first.last=NI;
        tail.first=NI;
        size += 1;
    }
    /**Return true if deque is empty*/
    public boolean isEmpty(){
        if(size==0) return true;
        else return false;
    }
    /**Return size of deque*/
    public int size(){
        return size;
    }
    /**Removes the item of note back of the head
     * size minus one */
    public T removeFirst(){
        if(size==0) return null;
        T temp = head.last.item;
        head.last.last.first=head;
        head.last=head.last.last;
        size--;
        return temp;

    }

    /**Removes the item of note  front of the tail
     * size minus one*/

    public T removeLast(){
        if(size==0) return  null;
        T temp=tail.first.item;
        tail.first.first.last=tail;
        tail.first=tail.first.first;
        size--;
        return temp;
    }
    public T get(int index){
        if(index>=size) return null;

        Note no = head.last;
        for (int i = 0; i < index; i++) {
            no=no.last;
        }
        return no.item;
    }
    public Iterator<T> iterator(){
        return new Iterator<T>() {
            int currentIndex=0;
            Note no=head;
            @Override
            public boolean hasNext() {
                return currentIndex<size;
            }

            @Override
            public T next() {
                no=no.last;
                if(hasNext()){
                    currentIndex++;
                    return no.item;
                }
                else{
                    return null;
                }
            }
        };

    }

    public void printDeque(){
        Iterator<?> thisIterator = this.iterator();
        while (thisIterator.hasNext()){
            System.out.print(thisIterator.next()+" ");
        }
        System.out.println();
    }
    public boolean equals(Object o){
        if( ! (o instanceof LinkedListDeque<?>)){
            return false;
        }


        if(((LinkedListDeque<?>) o).size() != size){
            return false;
        }

        Iterator<?> oIterator = ((LinkedListDeque<?>) o).iterator();
        Iterator<?> thisIterator = this.iterator();
        while (oIterator.hasNext()){
            if(oIterator.next()!=thisIterator.next()){
                return false;
            }
        }
        return true;
    }

}
