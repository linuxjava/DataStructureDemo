package DataStructure.stackqueue;

public class LinkQueue {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(20);
        queue.enqueue(40);

        queue.printAll();

        queue.enqueue(60);
        queue.enqueue(80);

        queue.printAll();

        queue.dequeue();
        queue.dequeue();

        queue.printAll();
    }

    static class Queue{
        LinkList linkList;

        public Queue() {
            this.linkList = new LinkList();
        }

        public void enqueue(int value){
            linkList.insertLast(value);
        }

        public int dequeue(){
            return linkList.removeFrist();
        }

        void printAll(){
            linkList.printAll();
        }
    }

    static class LinkList {
        Link frist;
        Link last;

        void insertLast(int value) {
            if (frist == null) {
                frist = last = new Link(value);
            } else {
                Link link = new Link(value);
                last.next = link;
                last = link;
            }
        }

        int removeFrist() {
            int tmp = frist.data;
            if (frist.next == null) {
                last = null;
            }
            frist = frist.next;

            return tmp;
        }

        void printAll(){
            Link tmp = frist;
            while (tmp != null){
                System.out.println(tmp.data);
                tmp = tmp.next;
            }
        }
    }

    static class Link {
        int data;
        Link next;

        public Link(int date) {
            this.data = date;
        }
    }
}
