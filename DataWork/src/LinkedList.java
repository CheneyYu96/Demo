/**
 * @author ymc
 * @version 创建时间：2015年10月31日 上午10:33:10
 *
 */
public class LinkedList {
	ListNode header=null;
	ListNode last=null;
	ListNode current=null;
	public LinkedList(){
		
	}
	
	public LinkedList(ListNode ln){
		header=ln;
		current=header;
		last=header;
	}
	public void add(ListNode ln){
		if(header!=null){
			last.next=ln;
			last=last.next;
		}
		else{
			header=ln;
			current=header;
			last=header;
		}
	}
	public ListNode next(){
		current=current.next;
		return current;	
	}
	public boolean isEnd(){
		return current==last;
	}
	public boolean isPassEnd(){
		return current==null;
	}
}

class ListNode {
	public ListNode() {
		
	}
	public ListNode(double coef, int exp) {
		this(coef,exp, null);
	}

	public ListNode(double coef, int exp, ListNode n) {
		this.coef=coef;
		this.exp=exp;
		next = n;
	}

	public double coef;
	public int exp;
	public ListNode next;
}
