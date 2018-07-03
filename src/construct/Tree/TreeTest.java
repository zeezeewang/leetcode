package construct.Tree;

import java.util.ArrayList;

public class TreeTest {

    private TreeNode root = null;

    private TreeTest(){

        root = new TreeNode( "50",1);
    }

    private void preOrder(TreeNode node) {
        if (node != null) {
            System.out.println(node.getData());
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    private void creatTreePre(ArrayList<String> data) {

        creatTree(data.size(), data);
    }

    private TreeNode creatTree(int size, ArrayList<String> data) {
        if (data.size() == 0) {
            return null;
        }
        TreeNode node;
        String d = data.get(0);
        int index = size - data.size();
        if (d.equals("#")) {
            node = null;
            data.remove(0);
            return null;
        }
        node = new TreeNode(d, index);
        if (index == 0) {
            node = root;
        }
        data.remove(0);
        node.leftChild = creatTree(size, data);
        node.rightChild = creatTree(size, data);
        return node;
    }

    /*private String addSum(TreeNode node){
        TreeNode current = root;
        TreeNode parentCurrent = root;
        String sum;
        if (root == null){
            return null;
        }
        while (current != null) {
            parentCurrent = current;

        }
    }*/

    public class TreeNode {
        private String data;
        private int index;
        private TreeNode leftChild;
        private TreeNode rightChild;

        private TreeNode(String data, int index) {
            this.data = data;
            this.index = index;
            this.leftChild = null;
            this.rightChild = null;
        }

        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(TreeNode rightChild) {
            this.rightChild = rightChild;
        }

        public void setData(String data) {
            this.data = data;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public TreeNode getLeftChild() {
            return leftChild;
        }

        public TreeNode getRightChild() {
            return rightChild;
        }

        public String getData() {
            return data;
        }

        public int getIndex() {
            return index;
        }
    }

    public static void main(String[] args) {
        TreeTest treeTest = new TreeTest();
        String[] arr = new String[]{"50","48","38","#","60","71","2"};
        ArrayList<String> arrayList = new ArrayList<>();
        for (String a : arr) {
            arrayList.add(a);
        }
        treeTest.creatTreePre(arrayList);
        treeTest.preOrder(treeTest.root);

    }
}
