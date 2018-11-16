package DataStructure.stackqueue;

/**
 * 使用单链表实现栈
 */
public class LinkStack {

    public static void main(String[] args){
        Stack stack = new Stack();
        stack.push(20);
        stack.push(40);

        stack.printAll();

        stack.push(60);
        stack.push(80);

        stack.printAll();

        stack.pop();
        stack.pop();

        stack.printAll();
    }

    static class Stack{
        LinkList linkList;

        public Stack() {
            this.linkList = new LinkList();
        }

        public void push(int value){
            linkList.insertFrist(value);
        }

        public int pop(){
            return linkList.removeFrist().data;
        }

        void printAll(){
            linkList.printAll();
        }
    }


    static class LinkList{
        private Link frist;

        void insertFrist(int value){
            Link node = new Link(value);
            node.next = frist;
            frist = node;
        }

        Link removeFrist(){
            if(frist == null){
                return null;
            }

            Link tmp = frist;
            frist = tmp.next;
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

    static class Link{
        int data;
        Link next;

        public Link(int date) {
            this.data = date;
        }
    }
}
