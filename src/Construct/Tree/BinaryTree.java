package Construct.Tree;

import java.util.Stack;

public class BinaryTree {

    private TreeNode root;

    private BinaryTree() {
        root = new TreeNode(1, 1);
    }

    private void createBinaryTree() {
        TreeNode nodeB = new TreeNode(2, 2);
        TreeNode nodeC = new TreeNode(3, 3);
        TreeNode nodeD = new TreeNode(4, 4);
        TreeNode nodeE = new TreeNode(5, 5);
        root.leftChild = nodeB;
        root.rightChild = nodeC;
        nodeB.leftChild = nodeD;
        nodeB.rightChild = nodeE;
    }

    //private static int max = Integer.MIN_VALUE;

    /*private int maxSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxSum(node.leftChild);
        int right = maxSum(node.rightChild);
        //max = Math.max(max, left + right + node.getData());
        return Math.max(left, right) + node.getData();
    }*/

    private int maxSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        TreeNode current = root;
        int sum = 0;
        while (node != null) {
                sum = root.getData();
             if (current.leftChild.getData() > current.rightChild.getData()) {
                sum = sum + current.leftChild.getData();
                node = node.leftChild;
            } else {
                sum = sum + current.rightChild.getData();
                node = node.rightChild;
            }
            if (node.rightChild == null && node.leftChild == null) {
                break;
            }
        }
        return sum;
    }

   /* public void createBinaryTreePre(ArrayList<String> data) {
        createBinaryTree(data.size(),data);
    }

    public TreeNode createBinaryTree(int size, ArrayList<String> data){
        if (data.size() == 0){
            return null;
        }
        String d = data.get(0);
        TreeNode node;
        int index = size - data.size();
        if (d.equals("#")) {
            node = null;
            data.remove(0);
            return null;
        }
        node = new TreeNode(index,d);
        if (index == 0) {
            node = root;
        }
        data.remove(0);
        node.leftChild = createBinaryTree(size,data);
        node.rightChild = createBinaryTree(size,data);
        return node;
    }*/


    private void levelOrder(TreeNode node, int level) {
        if (node == null || level < 1) {
            return;
        }

        if (level == 1) {
            System.out.print(node.getData() + "  ");
            return;
        }

        levelOrder(node.leftChild, level - 1);

        levelOrder(node.rightChild, level - 1);
    }


    private int getSize(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + getSize(node.leftChild) + getSize(node.rightChild);
        }
    }

    private void postOrder(TreeNode node) {
        if (node != null) {

            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.println(node.getData());
        }
    }


    private void midOrder(TreeNode node) {
        if (node != null) {
            midOrder(node.leftChild);
            System.out.println(node.getData());
            midOrder(node.rightChild);
        }
    }

    private void preOrde(TreeNode node) {
        if (node != null) {
            System.out.println(node.getData());
            preOrde(node.leftChild);
            preOrde(node.rightChild);
        }
    }

    public void stackOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        final Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (stack.size() > 0) {
            TreeNode n = stack.pop();
            System.out.println(n.getData());

            if (n.rightChild != null) {
                stack.push(n.rightChild);
            }

            if (n.leftChild != null) {
                stack.push(n.leftChild);
            }
        }
    }

    public void prevStack(TreeNode node) {
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode node1 = root;
        while (node1 != null || stack.size() > 0) {
            if (node1 != null) {
                System.out.println(node1.getData());
                stack.push(node1);
                node1 = node1.leftChild;
            } else {
                node1 = stack.pop();
                node1 = node1.rightChild;
            }
        }
    }

    public void midStack(TreeNode node) {
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode node1 = root;
        while (node1 != null || stack.size() > 0) {
            if (node1 != null) {
                stack.push(node1);
                node1 = node1.leftChild;
            } else {
                node1 = stack.pop();
                System.out.println(node1.getData());
                node1 = node1.rightChild;
            }
        }
    }

    public void lastStack(TreeNode node) {
        final Stack<TreeNode> stack = new Stack<>();
        final Stack<TreeNode> output = new Stack<>();
        TreeNode node1 = root;
        while (node1 != null || stack.size() > 0) {
            if (node1 != null) {
                output.push(node1);
                stack.push(node1);
                node1 = node1.rightChild;
            } else {
                node1 = stack.pop();
                node1 = node1.leftChild;
            }
        }
        while (output.size() > 0) {
            System.out.println(output.pop().getData());
        }
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int i = getHeight(node.leftChild);
            int j = getHeight(node.rightChild);
            return (i < j) ? j + 1 : i + 1;
        }
    }

    public class TreeNode {
        private int index;
        private int data;
        private TreeNode leftChild;
        private TreeNode rightChild;

        private TreeNode(int index, int data) {
            this.index = index;
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getIndex() {
            return index;
        }

        private int getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        BinaryTree binarytree = new BinaryTree();
        binarytree.createBinaryTree();
        //int height = binarytree.getHeight(binarytree.root);
        //System.out.println(height);
        //int size = binarytree.getSize(binarytree.root);
        //System.out.println(size);
        binarytree.preOrde(binarytree.root);
        //binarytree.midOrder(binarytree.root);
        //binarytree.postOrder(binarytree.root);
        //binarytree.stackOrder(binarytree.root);
        //binarytree.prevStack(binarytree.root);
        //binarytree.midStack(binarytree.root);
        //binarytree.lastStack(binarytree.root);
        //binarytree.levelOrder(binarytree.root,1);

        /*ArrayList<String> data = new ArrayList<>();
        String[] dataArray = new String[]{"A","B","D","#","#","E","#","#","C","#","F","#","#"};
        for (String d : dataArray) {
            data.add(d);
        }
        binarytree.createBinaryTreePre(data);
        binarytree.preOrde(binarytree.root);*/

        System.out.println("---------------------------------");


        System.out.println(binarytree.maxSum(binarytree.root));


    }
}
