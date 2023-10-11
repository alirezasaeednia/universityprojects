public class main {
    public static void main(String[] args) {
        MyCircularQueue circ = new MyCircularQueue(3);
        boolean isInserted = circ.enQueue(7);
        boolean isInserted2 = circ.enQueue(7);
        boolean isInserted3 = circ.enQueue(7);
        int front = circ.Front();
        int last = circ.Rear();
        boolean isEmpty = circ.isEmpty();
        boolean isFull = circ.isFull();
        System.out.println(circ.front);
        System.out.println(circ.end);
        System.out.println(last);
        System.out.println(front);
    }
}
