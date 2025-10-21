package deque;

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
    private Note head =new Note();
    private Note tail =new Note();

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
    public int getSize(){
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

    public T removeTail(){
        if(size==0) return  null;
        T temp=tail.last.item;
        tail.first.first.last=tail;
        tail.first=tail.first.first;
        size--;
        return temp;
    }
}
