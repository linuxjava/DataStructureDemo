package DataStructure.link;

/**
 * 单链表逆序
 */
public class LinkDemo {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.insertFrist(10);
        linkList.insertFrist(20);
        linkList.insertFrist(30);
        linkList.insertFrist(40);
        linkList.insertFrist(50);
        linkList.insertFrist(60);

        linkList.printAll();
        linkList.reverse();
        linkList.printAll();
    }

    static class LinkList {
        private Link frist;

        void insertFrist(int value) {
            Link node = new Link(value);
            node.next = frist;
            frist = node;
        }

        Link removeFrist() {
            if (frist == null) {
                return null;
            }

            Link tmp = frist;
            frist = tmp.next;
            return tmp;
        }

        void reverse() {
            Link prev = null, next = null;
            while (frist != null) {
                next = frist.next;
                frist.next = prev;
                prev = frist;
                frist = next;
            }

            frist = prev;
            next = null;
            prev = null;
        }

        void printAll() {
            Link tmp = frist;
            while (tmp != null) {
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
