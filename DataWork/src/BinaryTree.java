/** 
 * @author ymc 
 * @version 创建时间：2015年12月6日 下午4:55:31 
 *
 */
public class BinaryTree {
	
	BinaryNode root;
	
	
	public BinaryTree(BinaryNode root) {
		this.root = root;
	}
	

	/**
	 * 后序
	 */
	public void postOrder(BinaryNode node) {
//		System.out.println(node.left);
		if(node.hasLeft())
			postOrder(node.left);
		
		if(node.hasRight())
			postOrder(node.right);
		System.out.print(node.value.toString()+",");
			
	}
	/**
	 * 中序
	 */
	public void inOrder(BinaryNode node) {
		if(node.hasLeft())
			inOrder(node.left);
		
		System.out.print(node.value.toString()+",");
		
		if(node.hasRight())
			inOrder(node.right);
		
	}
	/**
	 * 前序
	 */
	public void preOrder(BinaryNode node) {
		System.out.print(node.value.toString()+",");
		
		if(node.hasLeft())
			preOrder(node.left);
		
		if(node.hasRight())
			preOrder(node.right);
	}
	
	public static void main(String[] args) {
		
		int size = 11;
		BinaryNode nodes[] = new BinaryNode[size];
		int a[] = {2,3,6,8,7,15,21,11,9,31,10};
		for(int i = 0 ;i < size;i++){
			nodes[i] = new BinaryNode(a[i]);
		}
		for(int i = 0;i<size/2;i++){
			nodes[i].left = nodes[2*i+1];
			if(nodes.length>=2*i+3)
				nodes[i].right = nodes[2*i+2];
		}
		
		BinaryTree tree = new BinaryTree(nodes[0]);
		System.out.println("post order:");
		tree.postOrder(tree.root);
		System.out.println();
		System.out.println("----------------");
		System.out.println("in order:");
		tree.inOrder(tree.root);
		System.out.println();
		System.out.println("----------------");
		System.out.println("pre order:");
		tree.preOrder(tree.root);
		System.out.println();
		System.out.println("----------------");
	}

	
}

class BinaryNode{
	Object value;
	
	BinaryNode left;
	
	BinaryNode right;
	
	public BinaryNode() {
		left = null;
		right = null;
		
	}
	public BinaryNode(Object value) {
		this();
		this.value = value; 
			
	}
	
	public BinaryNode(Object value , BinaryNode left , BinaryNode right){
		this(value);
		this.left = left;
		this.right = right;
	}
	public boolean hasRight() {
		return right!=null;
	}
	public boolean hasLeft() {
		return left!=null;
	}
} 
