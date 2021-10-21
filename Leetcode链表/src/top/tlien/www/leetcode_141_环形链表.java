package top.tlien.www;
// https://leetcode-cn.com/problems/linked-list-cycle/
public class leetcode_141_环形链表 {
	public class Solution {
		// 快慢指针
	    public boolean hasCycle(ListNode head) {
	        if (head == null || head.next == null) {
	            return false;
	        }
	        ListNode slow = head;
	        ListNode fast = head.next;
	        while (slow != fast) {
	            if (fast == null || fast.next == null) {
	                return false;
	            }
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        return true;
	    }
	}
}
