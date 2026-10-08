class MinStack {

    Stack<Integer> st=new Stack<>();
    Stack<Integer> minst=new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int value) {
        st.push(value);
        if(minst.isEmpty() || minst.peek()>=value)
        {
            minst.push(value);
        }
        else
        {
            minst.push(minst.peek());
        }
    }
    
    public void pop() {
        st.pop();
        minst.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minst.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */