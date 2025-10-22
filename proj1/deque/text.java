package deque;

import java.util.Iterator;

public class text {
    public static void main(String[] args) {
        LinkedListDeque<Integer> intList = new LinkedListDeque<>();
        System.out.println(intList.getSize());
        System.out.println(intList.isEmpty());
        intList.addFirst(5);
        intList.addFirst(10);
        intList.addLast(15);
        intList.addLast(9);
        intList.addLast(6);
        intList.addLast(3);
        System.out.println(intList.getSize());
        System.out.println(intList.isEmpty());
//        for (int i = 0; i < 6; i++) {
//            System.out.println(intList.removeFirst());
//        }
//        System.out.println(intList.getSize());
//        System.out.println(intList.removeFirst());
        Iterator<Integer> t=  intList.iterator();
        LinkedListDeque<Integer> n=new LinkedListDeque<>();
        Iterator<Integer> nn=n.iterator();
        Iterator<Integer> tt= intList.iterator();
        while(t.hasNext()){
            n.addLast(t.next());
        }
        while(tt.hasNext()){
            System.out.println(tt.next());
        }
        while (nn.hasNext()){
            System.out.println(nn.next());
        }

        System.out.println(intList.equals(n));
    }
}
