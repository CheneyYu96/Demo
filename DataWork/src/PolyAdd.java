
/**
 * @author ymc
 * @version 创建时间：2015年10月30日 下午11:52:44
 *
 */
public class PolyAdd {

	ListNode[] note1 = new ListNode[10];
	ListNode[] note2 = new ListNode[10];
	LinkedList list1 = new LinkedList();
	LinkedList list2 = new LinkedList();
	public PolyAdd(){
		getValue();
	}

	public void getValue() {
		note1[0] = new ListNode(25, 13);
		note1[1] = new ListNode(13, 10);
		note1[2] = new ListNode(4.5, 5);
		note1[3] = new ListNode(2, 1);
		note2[0] = new ListNode(3, 10);
		note2[1] = new ListNode(3.2, 5);
		note2[2] = new ListNode(5, 3);
		note2[3] = new ListNode(4, 2);
		list1.add(note1[0]);
		list1.add(note1[1]);
		list1.add(note1[2]);
		list1.add(note1[3]);
		list2.add(note2[0]);
		list2.add(note2[1]);
		list2.add(note2[2]);
		list2.add(note2[3]);
		
	}

	public LinkedList execute() {
		LinkedList result = new LinkedList();
		while (!list1.isPassEnd() || !list2.isPassEnd()) {
			
			if (list1.isPassEnd() && list2.current != null) {
				while (!list2.isPassEnd()) {
					result.add(list2.current);
					list2.next();
				}
			} else if (list2.isPassEnd() && list1.current != null) {
				while (!list1.isPassEnd()) {
					result.add(list1.current);
					list1.next();
				}
			} else if(list1.current != null&&list2.current != null){
				
				if (list1.current.exp > list2.current.exp) {
					result.add(list1.current);
					list1.next();
				} else if (list1.current.exp < list2.current.exp) {
					result.add(list2.current);
					list2.next();
				} else {
					list1.current.coef=list1.current.coef + list2.current.coef;
					result.add(list1.current);
					list1.next();
					list2.next();
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		PolyAdd polyAdd=new PolyAdd();
		LinkedList result=polyAdd.execute();
		while(!result.isPassEnd()){
			System.out.println(result.current.coef+"x^"+result.current.exp);
			result.next();
		}
		
	}

}
