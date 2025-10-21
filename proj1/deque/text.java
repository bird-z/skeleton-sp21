package deque;

public class text {
    public static void main(String[] args) {
        LinkedListDeque<Integer> intList =new LinkedListDeque<>();
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
        for (int i = 0; i < 6; i++) {
            System.out.println(intList.removeFirst());
        }
        System.out.println(intList.getSize());
        System.out.println(intList.removeFirst());
    }
}
