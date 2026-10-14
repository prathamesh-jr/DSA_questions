class CustomStack {
    private final int[] stack;
    private final int[] inc;
    private final int maxSize;
    private int top;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.inc = new int[maxSize];
        this.top = 0; // Number of elements currently in the stack
    }

    public void push(int x) {
        if (top < maxSize) {
            stack[top] = x;
            inc[top] = 0; // Reset lazy buffer for this slot
            top++;
        }
    }

    public int pop() {
        if (top == 0) {
            return -1;
        }

        top--;
        int idx = top;
        int result = stack[idx] + inc[idx];

        // Propagate lazy increment to the element below
        if (idx > 0) {
            inc[idx - 1] += inc[idx];
        }
        inc[idx] = 0;

        return result;
    }

    public void increment(int k, int val) {
        // Find the topmost index among the bottom k elements
        int idx = Math.min(k, top) - 1;
        if (idx >= 0) {
            inc[idx] += val;
        }
    }
}