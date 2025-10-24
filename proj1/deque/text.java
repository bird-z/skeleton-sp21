package deque;

import java.util.Iterator;

public class text {
    public static void main(String[] args) {
//        LinkedListDeque<Integer> intList = new LinkedListDeque<>();
//        System.out.println(intList.getSize());
//        System.out.println(intList.isEmpty());
//        intList.addFirst(5);
//        intList.addFirst(10);
//        intList.addLast(15);
//        intList.addLast(9);
//        intList.addLast(6);
//        intList.addLast(3);
//        System.out.println(intList.getSize());
//        System.out.println(intList.isEmpty());
//        for (int i = 0; i < 6; i++) {
//            System.out.println(intList.removeFirst());
//        }
//        System.out.println(intList.getSize());
//        System.out.println(intList.removeFirst());
//        Iterator<Integer> t=  intList.iterator();
//        LinkedListDeque<Integer> n=new LinkedListDeque<>();
//        Iterator<Integer> nn=n.iterator();
//        Iterator<Integer> tt= intList.iterator();
//        while(t.hasNext()){
//            n.addLast(t.next());
//        }
//        while(tt.hasNext()){
//            System.out.println(tt.next());
//        }
//        while (nn.hasNext()){
//            System.out.println(nn.next());
//        }

//        System.out.println(intList.equals(n));
//        System.out.println((-2+5)%5);
        ArrayDeque<Integer> arr=new ArrayDeque<>();
        arr.addFirst(1);
        arr.addFirst(2);
        arr.addFirst(3);
        arr.addFirst(4);
        arr.addFirst(5);
        arr.addFirst(6);
        arr.addFirst(7);
        arr.addFirst(8);
        arr.addList(20);
        arr.addList(30);
        System.out.println(arr.getSize());
        System.out.println(arr.getMaxSize());
        for (int l = 0; l < 10; l++) {
            System.out.println(arr.reFirst());
            System.out.println(arr.getSize());
            System.out.println(arr.getMaxSize());
            System.out.println("##############");
        }
//        for (int i = 0; i < 6; i++) {
//            System.out.println("%%");
//            System.out.println(arr.reFirst());
//        }
//        System.out.println("####################");
//        for (int i = 0; i < 6; i++) {
//            System.out.println(arr.getLast());
//        System.out.println(arr.getFirst());
//        }
//        System.out.println(arr.reFirst());
//        System.out.println(arr.getLast());
    }
}
