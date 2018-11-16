package DataStructure.stackqueue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue queue = new Queue(2);

        boolean ret = queue.enqueue(10);
        System.out.println("enqueue 10 " + ret);
        ret = queue.enqueue(11);
        System.out.println("enqueue 11 " + ret);
        ret = queue.enqueue(12);
        System.out.println("enqueue 12 " + ret);

        System.out.println("dequeue " + queue.dequeue());
        System.out.println("dequeue " + queue.dequeue());
        System.out.println("dequeue " + queue.dequeue());
    }

    static class Queue {
        private int[] data;
        private int front, rear;
        private int lenght;

        //数组中仅仅存储数组大小-1个元素，保证rear转一圈之后不会和head相等。也就是队列满的时候。rear+1=head，中间刚好空一个元素
        public Queue(int cap) {
            lenght = cap + 1;
            data = new int[lenght];
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public boolean isFull() {
            return (rear + 1) % lenght == front;
        }

        public boolean enqueue(int value) {
            if (isFull()) {
                return false;
            }

            data[rear] = value;
            rear = (rear + 1) % lenght;
            return true;
        }

        public int dequeue() {
            if (isEmpty()) {
                return -10000;
            }

            int obj = data[front];

            front = (front + 1) % lenght;
            return obj;
        }
    }
}
