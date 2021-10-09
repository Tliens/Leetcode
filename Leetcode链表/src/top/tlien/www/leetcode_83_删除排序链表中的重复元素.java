package top.tlien.www;

public class leetcode_83_删除排序链表中的重复元素 {
	// 递归法
    public ListNode deleteDuplicates(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	head.next = deleteDuplicates(head.next);
    	return head.val == head.next.val ? head.next : head;
    }
    // 迭代法
    public ListNode deleteDuplicates1(ListNode head) {
    	ListNode preHead = new ListNode(0);
    	preHead.next = head;
    	ListNode temp = head;
    	while (temp.next != null) {
    		if (temp.next.val == temp.val) {
    			temp.next = temp.next.next;
    		}else {
    			temp = temp.next;
    		}
    	}
    	return preHead.next;
    }    
}
