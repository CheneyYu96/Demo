package tree;

import java.util.*;

/**
 * Created by yuminchen on 16/4/20.
 */
public class Main {

    int sum;

    BinaryTree rootTree;

    boolean hasPath = false;

    /**
     * read what inputs from console
     * build the basic tree
     */
    public void readInput(){
        Scanner cin = new Scanner(System.in);
        if (cin.hasNext()){
           sum = cin.nextInt();
        }

        if(cin.hasNext()) {
            String values = cin.next();
            String[] spl = values.split(",");
            int[] value = new int[spl.length];
            for(int i =0;i<spl.length;i++){
                value[i] = Integer.parseInt(spl[i]);
            }

            BinaryTree nodes[] = new BinaryTree[value.length];
            for(int i = 0 ;i < value.length;i++){
                nodes[i] = new BinaryTree(value[i]);
            }
            for(int i = 0;i<value.length/2;i++){
                nodes[i].leftTree = nodes[2*i+1];
                if(nodes.length>=2*i+3)
                    nodes[i].rightTree = nodes[2*i+2];
            }

            rootTree = nodes[0];

        }

    }

    public void searchTree(BinaryTree tree,int rootValue,String path){
        int tmpSum = rootValue +tree.root;
        if(path==null){
            path = tree.root+",";
        }
        if(tmpSum>sum){
            return;
        }
        else if(tmpSum==sum){
            if(!tree.hasLeft()&&!tree.hasRight()){
                hasPath = true;
                path = path+tree.root;
                System.out.println(path);
            }
            else
                return;
        }
        else {
            path = path+tree.root+",";
            if (tree.hasLeft()) {
                searchTree(tree.leftTree, tmpSum, path);
            }

            if (tree.hasRight()) {
                searchTree(tree.rightTree, tmpSum,path);
            }
        }

    }

    class BinaryTree{
        int root;
        BinaryTree leftTree;
        BinaryTree rightTree;

        public BinaryTree() {
        }

        public BinaryTree(int root, BinaryTree leftTree, BinaryTree rightTree) {
            this.root = root;
            this.leftTree = leftTree;
            this.rightTree = rightTree;
        }

        public BinaryTree(int root) {
            this.root = root;

        }

        public void setLeftTree(BinaryTree leftTree) {
            this.leftTree = leftTree;
        }

        public void setRightTree(BinaryTree rightTree) {
            this.rightTree = rightTree;
        }

        public boolean hasLeft(){
            return leftTree!=null;
        }

        public boolean hasRight(){
            return rightTree!=null;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.readInput();
        main.searchTree(main.rootTree,0,"");
        if(!main.hasPath){
            System.out.println("error");
        }
    }
}
