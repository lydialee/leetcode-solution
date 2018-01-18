// next() and hasNext() should run in O(1) time and uses O(h) memory

/* 1. recursively，turn BST into a right-line tree
   这种方法把 BST 变成只有 right 指针的一棵直线树。
   这样一来每个节点就是该位置的最小值，它的 right 节点就是下一个最小值。
   next() and hasNext(): O(1) time, O(1) space
   inorder(): O(n) time, O(h) space. 当是平衡二叉树时 h = logn. 因为 f(root.left) 是 f(root) 的一半。每次减小一半的问题是 logn。
 */
public class BSTIterator {
    private TreeNode prev; // 只在 inorder 函数中被使用。
    private TreeNode head;
    
    public BSTIterator(TreeNode root) {
        inorder(root);        
    }
    
    private void inorder(TreeNode node){
        if (node == null) return;
        
        inorder(node.left); // 先全部执行完，才会走到下一行。保证了【左中右】的顺序。
        if (prev == null) {
            head = node;
        } else {
            prev.right = node;
        }
        prev = node;
        inorder(node.right);
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
// O(1) time, O(h) space
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