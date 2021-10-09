package top.tlien.www;


public class leetcode_203_移除链表元素 {
	/// 递归法
	public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
        	return head;
        }
        head.next = removeElements(head.next,val);
        return head.val == val ? head.next : head;
    }
	/// 递归法
	public ListNode removeElements1(ListNode head, int val) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode temp = preHead;
        while(temp.next != null) {
        	if (temp.next.val == val) {
        		temp.next = temp.next.next;
        	}else {
        		temp = temp.next;
        	}
        }
        return preHead.next;
        		
    }	
}
