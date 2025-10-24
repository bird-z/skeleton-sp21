package deque;

public class ArrayDeque<T> {
    private T[]  arr= (T[]) new Object[8];
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
    public void addList(T item){
        if(size+2>maxSize){
            addSize();
        }
        arr[(last)%maxSize]=item;
        last++;
        size++;
    }

    /**reFirst*/
    public T reFirst(){
        if(size>20&&size<maxSize/4){
            minesSize();
        }
        first++;
        size--;
        T temp = arr[(first+maxSize)%maxSize];
        return temp;
    }

    /**reLast*/
    public T reLast(){
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

    /**get maxsize of arr*/
    public int getMaxSize(){
        return maxSize;
    }
}
