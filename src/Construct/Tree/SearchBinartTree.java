package Construct.Tree;

public class SearchBinartTree {
    public static void main(String[] args) {
        SearchBinartTree sb = new SearchBinartTree();
        int[] arr = new int[]{11, 1, 3, 15, 30, 28, 32, 88, 45, 34, 2, 17};
        for (int a : arr) {
            sb.put(a);
        }
        //sb.delete(45);
        sb.midOrder(sb.root);
        //System.out.println(sb.search(1));
    }

    private TreeNode root;

    private SearchBinartTree() {

    }


    private void midOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        midOrder(node.leftChild);
        System.out.println(node.getData());
        midOrder((node.rightChild));
    }

    private boolean delete(int data) {
        TreeNode node = root;
        TreeNode parent = root;
        boolean isLeftChild = true;
        while (data != node.getData()) {
            parent = node;
            if (data > node.getData()) {
                node = node.rightChild;
                isLeftChild = false;
            } else {
                node = node.leftChild;
                isLeftChild = true;
            }
            if (node == null) {
                return false;
            }
        }
        if (node.rightChild == null && node.leftChild == null) {
            if (node == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (node.rightChild == null) {
            if (node == root) {
                node.leftChild = root;
            } else if (isLeftChild) {
                parent.leftChild = node.leftChild;
            } else {
                parent.rightChild = node.leftChild;
            }
        } else if (node.leftChild == null) {
            if (node == root) {
                node.rightChild = root;
            } else if (isLeftChild) {
                parent.leftChild = node.rightChild;
            } else {
                parent.rightChild = node.rightChild;
            }
        } else {
            if (node == root) {
                root = getSuccessor(node);
            } else if (isLeftChild) {
                node.leftChild = getSuccessor(node);
            } else {
                node.rightChild = getSuccessor(node);
            }
            getSuccessor(node).leftChild = node.leftChild;
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode delNode) {
        TreeNode successor = delNode;
        TreeNode parentSuccessor = delNode;
        TreeNode node = delNode.rightChild;
        while (node != null) {
            parentSuccessor = successor;
            successor = node;
            node = node.leftChild;
        }
        if (successor != delNode.rightChild) {
            parentSuccessor.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    private TreeNode put(int data) {
        TreeNode node = null;
        TreeNode parent = null;
        if (root == null) {
            node = new TreeNode(data, 0);
            root = node;
            return node;
        }
        node = root;
        while (node != null) {
            parent = node;
            if (data < node.getData()) {
                node = node.leftChild;
            }else {
                node  = node.rightChild;
            }
        }
        node = new TreeNode(data,0);
        if (data > parent.getData()) {
            parent.rightChild = node;
        }else {
            parent.leftChild = node;
        }
        node.parent = parent;
        return node;
    }

    private boolean search(int data) {
        TreeNode node = root;
        while (node.getData() != data) {
            if (data < node.getData()) {
                node = node.leftChild;
            } else {
                node = node.rightChild;
            }
            if (node == null) {
                return false;
            }
        }
        return true;
    }

    class TreeNode {
        private int data;
        private int key;
        private TreeNode rightChild;
        private TreeNode leftChild;
        private TreeNode parent;

        public TreeNode(int data, int key) {
            this.data = data;
            this.key = key;
            this.rightChild = null;
            this.leftChild = null;
            this.parent = null;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public void setRightChild(TreeNode rightChild) {
            this.rightChild = rightChild;
        }

        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode getParent() {
            return parent;
        }

        public int getData() {
            return data;
        }

        public int getKey() {
            return key;
        }

        public TreeNode getRightChild() {
            return rightChild;
        }

        public TreeNode getLeftChild() {
            return leftChild;
        }
    }
}

/*package Construct.Tree;

        import java.util.ArrayList;

public class SearchBinartTree {
    public static void main(String[] args){
        SearchBinartTree binaryTree = new SearchBinartTree();
        int[] intArray = new int[]{50,30,20,44,88,33,87,16,7,77};
        for(int i : intArray){
            binaryTree.put(i);
        }
        binaryTree.midOrder(binaryTree.root );
    }
    private TreeNode root;

    public SearchBinartTree(){

    }


    public void midOrder(TreeNode node) {
        if (node == null) {
            return ;
        }else{
            midOrder(node.leftChild);
            System.out.println(node.getData());
            midOrder((node.rightChild));
        }
    }

    public TreeNode put(int data){
        TreeNode node = null;
        TreeNode parent = null;
        if(root == null){
            node = new TreeNode(0,data);
            root = node;
            return node;
        }
        node = root;
        while (node != null) {
            parent = node;
            if (data > node.getData()) {
                node = node.rightChild;
            }else{
                node = node.leftChild;
            }
        }
        node = new TreeNode(0,data);
        if(data > parent.getData()) {
            parent.rightChild = node;
        }else {
            parent.leftChild = node;
        }
        node.parent = parent;
        return node;
    }

    class TreeNode {
        private int data;
        private int  key;
        private TreeNode leftChild;
        private TreeNode rightChild;
        private TreeNode parent;

        public TreeNode(int key, int data) {
            this.key = key;
            this.data = data;
            leftChild = null;
            rightChild = null;
            this.parent = null;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(TreeNode rightChild) {
            this.rightChild = rightChild;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
        }

        public int getData() {
            return data;
        }

        public int getKey() {
            return key;
        }

        public TreeNode getLeftChild() {
            return leftChild;
        }

        public TreeNode getRightChild() {
            return rightChild;
        }

        public TreeNode getParent() {
            return parent;
        }
    }
}

private boolean delete(int data) {
        TreeNode node = root;
        TreeNode parent = root;
        boolean isLeftchild = true;
        while (node.getData() != data) {
            parent = node;
            if (data < node.getData()) {
                node = node.leftChild;
                isLeftchild = true;
            } else {
                node = node.rightChild;
                isLeftchild = false;
            }
            if (node == null) {
                return false;
            }
        }

        if (node.leftChild == null && node.rightChild == null) {
            if (node == root) {
                root = null;
            } else if (isLeftchild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (node.rightChild == null) {
            if (node == root) {
                root = node.leftChild;
            } else if (isLeftchild) {
                parent.leftChild = node.leftChild;
            } else {
                parent.rightChild = node.leftChild;
            }
        } else if (node.leftChild == null) {
            if (node == root) {
                root = node.rightChild;
            } else if (isLeftchild) {
                parent.leftChild = node.rightChild;
            } else {
                parent.rightChild = node.rightChild;
            }
        }else {
            if (node == root) {
                root = getSuccessor(node);
            }else if (isLeftchild) {
                parent.leftChild = getSuccessor(node);
            }else {
                parent.rightChild = getSuccessor(node);
            }
            getSuccessor(node).leftChild = node.leftChild;
        }
        return true;

    }

    public TreeNode getSuccessor(TreeNode deleNode){
        TreeNode successor = deleNode;
        TreeNode parentSuccessor = deleNode;
        TreeNode node = deleNode.rightChild;
        while (node != null) {
            parentSuccessor = successor;
            successor = node;
            node = node.leftChild;
        }
        if (successor != deleNode.rightChild){
            parentSuccessor.leftChild = successor.rightChild;
            successor.rightChild = deleNode.rightChild;
        }
        return successor;
    }


*/
