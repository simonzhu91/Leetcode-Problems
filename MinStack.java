class MinStack {
    Stack<Integer> stk = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    
    public void push(int x) {
        stk.push(x);
        if(min.isEmpty() || x <= min.peek())
            min.push(x);
    }

    public void pop() {
        int val = stk.pop();
        if(min.peek() == val)
            min.pop();
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
