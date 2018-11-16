package DataStructure.stackqueue;

/**
 * 数组实现栈
 */
public class StackDemo {
    public static void main(String[] args) {
        Stack stack = new Stack(16);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        while (!stack.isEmpth()){
            System.out.println(stack.pop());
        }
    }

    static class Stack {
        int[] stackArray;
        int top = -1;

        private Stack() {

        }

        public Stack(int cap) {
            if (cap < 0) {
                cap = 16;
            }
            stackArray = new int[cap];
        }

        public boolean isEmpth() {
            return top == -1;
        }

        public boolean isFull() {
            return top >= stackArray.length - 1;
        }

        public boolean push(int value) {
            if (isFull()) {
                return false;
            }

            stackArray[++top] = value;

            return true;
        }

        public int pop() {
            if (isEmpth()) {
                return -10000;
            }

            return stackArray[top--];
        }

        public int peek(){
            if (isEmpth()) {
                return -10000;
            }

            return stackArray[top];
        }
    }
}
