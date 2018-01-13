// next() and hasNext() should run in O(1) time and uses O(h) memory

// 1. recursively
public class BSTIterator {
    private TreeNode prev;
    private TreeNode head;
    
    public BSTIterator(TreeNode root) {
        inorder(root);        
    }
    
    private void inorder(TreeNode t){
        if(t == null)
            return;
        inorder(t.left);
        if(prev == null)
            head = t;
        else
            prev.right = t;
        prev = t;
        inorder(t.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return head != null;
    }

    /** @return the next smallest number */
    public int next() {
        int val = head.val;
        head = head.right;
        return val;
    }
}

// using stack
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>(); // 只需要实例化一个 stack，每次实例化 BSTIterator 的时候重复使用之。
    public BSTIterator(TreeNode root) {
        inorder(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        inorder(cur.right);
        return cur.val;
    }
    
    private void push(TreeNode root) {
        while (root != null) {
            stack.inorder(root);
            root = root.left;
        }
    }
}