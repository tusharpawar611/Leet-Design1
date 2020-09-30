class MinStack {

    Stack<Integer> st = new Stack<Integer>();
    int minVal = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if (x >= minVal) {
            st.push(x);
        } else {
            st.push(2 * x - minVal);
            minVal = x;
        }
    }

    public void pop() {
        int t = st.pop();

        if (t < minVal) {
            minVal = 2 * minVal - t;
        }

    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */