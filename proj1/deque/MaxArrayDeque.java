package deque;

import java.util.Comparator;
import java.util.Iterator;

public class MaxArrayDeque<T> extends ArrayDeque{
    private  final Comparator<T> deComparator;
    public MaxArrayDeque(Comparator<T> c){
        this.deComparator=c;
    }

    public T max(){
        return max(this.deComparator);
    }
    public T max(Comparator<T> o){
        if(this.size()==0){
            return null;
        }
        T x= null;
        Iterator<T> thisIter=this.iterator();
        while (thisIter.hasNext()){
            T current=thisIter.next();
            if(deComparator.compare(current,x)>0)
            {
                x=current;
            }
        }
        return x;
    }
}
