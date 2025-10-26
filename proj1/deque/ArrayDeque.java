package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements deque<T>{
    protected T[]  arr= (T[]) new Object[8];
    private int  size ,maxSize;
    private int first ,last;

    public ArrayDeque() {
        size =0;
        maxSize=8;
        first=maxSize/2;
        last=maxSize/2+1;
    }

    /**add T before of first*/
    public void addFirst(T item){
        if(size+2>maxSize){
            addSize();
        }
        arr[(first+maxSize)%maxSize]=item;
        first--;
        size++;
    }

    /**add T back of list*/
    public void addLast(T item){
        if(size+2>maxSize){
            addSize();
        }
        arr[(last)%maxSize]=item;
        last++;
        size++;
    }

    /**reFirst*/
    public T removeFirst(){
        if(size==0) return  null;
        if(size>20&&size<maxSize/4){
            minesSize();
        }
        first++;
        size--;
        T temp = arr[(first+maxSize)%maxSize];
        return temp;
    }

    /**reLast*/

    public T removeLast(){
        if(size()==0){
            return null;
        }
        if(size>20&&size<maxSize/4){
            minesSize();
        }
        last--;
        size--;
        T temp=arr[last%maxSize];
        return temp;
    }

    /**get first*/
    public T getFirst(){
        if(size>0)
            return arr[(first+1)%maxSize];
        else return null;
    }

    /**get last*/
    public T getLast(){
        if(size>0){
            return arr[(last-1)%maxSize];
        }
        else return null;
    }

    /**resize */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];

        for(int i=maxSize/2,j=capacity/2;i>=first;i--,j--){
            a[(j+capacity)%capacity]=arr[(i+maxSize)%maxSize];
        }
        for (int i = maxSize/2+1,j=capacity/2+1 ;i <=last; i++,j++) {
            a[j%capacity]=arr[(i)%maxSize];
        }
        arr=a;
        first=capacity/2-maxSize/2+first;
        last=capacity/2+last-maxSize/2;
        maxSize=capacity;
    }

    /**add max size of arr*/
    private void addSize(){
        resize(maxSize*10);
    }

    /**mines max size of arr*/
    private void minesSize(){
        resize(maxSize/2);
    }

    /**get size of arr*/
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size()==0)
        return true;
        else  return false;
    }

    /**get maxsize of arr*/
    public int getMaxSize(){
        return maxSize;
    }
    /**get iterator of arr*/
    public Iterator<T> iterator(){
        return new Iterator<T>() {
            int step=0;
            @Override
            public boolean hasNext() {
                return step<size;
            }

            @Override
            public T next() {
                step+=1;
                return arr[(first+step+maxSize)%maxSize];
            }
        };
    }

    @Override
    public T get(int index) {
        Iterator<?> thisIt=this.iterator();
        int step=0;
        while (thisIt.hasNext()){
            T temp= (T) thisIt.next();
            if(step==index) return  temp;
            step++;
        }
        return null;
    }

    @Override
    public void printDeque() {
        Iterator<?> thisTt = this.iterator();
        while (thisTt.hasNext()){
            System.out.println(thisTt.next()+" ");
        }
    }
}
