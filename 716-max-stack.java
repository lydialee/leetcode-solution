/* 1 Double Linked List + TreeMap
     Double Linked List  all numbers
     TreeMap             max values
     time:  push O(lgn) pop O(lgn)  top O(1)  peekMax  O( 1 )  popMax O(lgn)
     space: O(n)
     (TreeMap: a map that keeps keys in order. so add, delete is lgn time.)
 */
class MaxStack {
    TreeMap<Integer, List<Node>> map; // <value, node>. may have duplicates
    DoubleLinkedList list; // record in order

    public MaxStack() {
        map = new TreeMap();
        list = new DoubleLinkedList();
    }

    // put in list and map at the same time O(lgn)
    public void push(int x) {
        Node node = list.add(x);
        map.putIfAbsent(x, new ArrayList<Node>());
        map.get(x).add(node);
    }

    // O(logn)
    public int pop() {
        int val = list.pop();
        List<Node> nodes = map.get(val);
        
        nodes.remove(nodes.size() - 1); // delete the last one
        if (nodes.isEmpty()) map.remove(val);
        
        return val;
    }

    // O(1)
    public int top() {
        return list.peek();
    }

    // O(1)
    public int peekMax() {
        return map.lastKey();
    }

    // O(lgn)
    public int popMax() {
        int max = peekMax();
        List<Node> nodes = map.get(max);
        Node node = nodes.remove(nodes.size() - 1);
        
        list.unlink(node);
        if (nodes.isEmpty()) map.remove(max);
        
        return max;
    }
}

class DoubleLinkedList {
    Node head, tail;

    public DoubleLinkedList() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public Node add(int val) {
        Node x = new Node(val);
        x.next = tail;
        x.prev = tail.prev;
        tail.prev = tail.prev.next = x;
        return x;
    }

    public int pop() {
        return unlink(tail.prev).val;
    }

    public int peek() {
        return tail.prev.val;
    }

    public Node unlink(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }
}

class Node {
    int val;
    Node prev, next;
    public Node(int v) {val = v;}
}




/* 1 two arrays
     values     all numbers
     maxValues  max values
     time:  push O(1) pop O(1) top O(1)  peekMax  O( 1 )  popMax O(n)
     space: O(1)
 */
class MaxStack {
    private int[] values = new int[10010];
    private int[] maxValues = new int[10010];
    private int top = 0; // record stack top. top = 0: 0 element. top = n, n elements.

    public MaxStack() {
    }

    public void push(int x) {
        values[top] = x;
        maxValues[top] = x;
        if (top > 0) {
            maxValues[top] = Math.max(maxValues[top - 1] , maxValues[top]);
        }
        top++;
    }

    public int pop() {
        top--;
        return values[top];
    }

    public int top() {
        return values[top - 1];
    }

    public int peekMax() {
        return maxValues[top - 1];
    }

    public int popMax() {
        // top++ after push. So top - 1 is the biggest key. top is the array length.
        int maxIdx = top - 1 , max = maxValues[top - 1];
        
        // find the index of max value in values
        while (values[maxIdx] != max) {
            maxIdx--;
        }
        
        // cover max value with the value after, and decrease top. - pop
        for (int i = maxIdx + 1; i < top; i++) {
            // update values[i - 1]
            values[i - 1] = values[i];
            
            // update maxValues[i - 1]
            if (i > 1) {
                maxValues[i - 1] = Math.max(values[i - 1] , maxValues[i - 2]);
            // if i = 1, values[i] is the only one element 
            } else {
                maxValues[i - 1] = values[i];
            }
        }
        top--;
        return max;
    }
}

/* 2 two stacks
     stack     all numbers
     maxStack  max values
     time:  push O(1)     pop O(1)， top O(1)   peekMax  O( 1 )  popMax O(n)
     space: O(n)
 */
class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }
    
    public void push(int x) {
        int currMax = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
        if (x > currMax) {
            currMax = x;
        }
        stack.push(x);
        maxStack.push(currMax);
    }
    
    public int pop() {
        maxStack.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        int max = maxStack.peek();
        Stack<Integer> temp = new Stack<>();
        while (stack.peek() != max) {
            temp.push(stack.pop());
            maxStack.pop();
        }
        stack.pop();
        maxStack.pop();
        while (!temp.isEmpty()) {
            this.push(temp.pop());
        }
        return max;
    }
}

/*
    3 stack + pq
    stack: all numbers
    pq: max value
    time:  push O(logn)  pop O(logn) top O(1) peekMax  O(1) popMax  O(n)
    space: O(n)
 */
class MaxStack {
    Stack<Integer> stack;
    PriorityQueue<Integer> pq;
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<Integer>();
        pq = new PriorityQueue<Integer>((a, b) -> b - a);
    }

    public void push(int x) {
        stack.push(x);
        pq.offer(x);
    }

    public int pop() {
        int pop = stack.pop();
        pq.remove(pop);
        return pop;
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return pq.peek();
    }

    public int popMax() {
        int max = pq.poll();
        Stack<Integer> temp = new Stack<Integer>();
        while (!stack.isEmpty()) {
            if (stack.peek() != max) {
                temp.push(stack.pop());
            } else {
                stack.pop();
                break;
            }
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        return max;
    }
}