public class Stack {
    private int top;
    private int size;
    private char array[];

    public Stack(int size) {
        top = -1;
        this.size = size;
        array = new char[this.size];
    }

    // 스택에 가득찬 상태인지 확인
    public boolean isFull() {
        return top == size - 1;
    }

    // 스택이 비어있는 상태인지 확인
    public boolean isEmpty() {
        return top == -1;
    }

    // 스택에 원소 추가
    public void push(char element) {
        if(isFull()) {
            System.out.println("Stack is full");
        }

        if(!isFull()) {
            array[++top] = element;
            System.out.println("Inserted element : " + element);
        }
    }

    // 맨 위에 있는 원소 제거
    public char pop() {
        if(isEmpty()) {
             System.out.println("Stack is empty");
             return 0;
        }

        System.out.println("Deleted element : " + array[top]);
        return array[top--];
    }

    // 스택의 최상위 원소 추출
    public char peek() {
        if(isEmpty()) {
            System.out.println("Stack is empty");
            return 0;
        }

        System.out.println("The top element is " + array[top]);
        return array[top];
    }

    // 스택 초기화
    public void clear() {
        if(isEmpty()) {
            System.out.println("Stack is already empty");
        }

        if(!isEmpty()) {
            top = -1;
            array = new char[size];
        }
    }

    // 스택 사이즈
    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        
        stack.push('A');
        stack.push('B');

        // 스택 현재 사이즈 2
        System.out.println("Stack size is " + stack.size());

        // B 원소 삭제
        stack.pop();

        // A 원소 확인
        stack.peek();

        // 스택 초기화
        stack.clear();

        // 스택 사이즈 0
        System.out.println("Stack size is " + stack.size());
    }
}
