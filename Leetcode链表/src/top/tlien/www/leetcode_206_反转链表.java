package top.tlien.www;
// https://leetcode-cn.com/problems/reverse-linked-list/
public class leetcode_206_反转链表 {
	// 3->4->2->null ----> null->2->4->3
	
	// 三个位置，pre，curr，next，每次缓存next的位置，curr 指向 pre,然后 curr、pre均后移一位
	class Solution1{
		public ListNode reverseList(ListNode head) {
			ListNode pre = null;
			ListNode curr = head;
			while (curr != null) {
				ListNode next = curr.next;
				curr.next = pre;
				pre = curr;
				curr = next;
			}
			return pre;
		}
	}
	class Solution2{
		// 先处理除了头结点之外的节点，最后在处理头结点
		public ListNode reverseList(ListNode head) {
	        if (head == null || head.next == null){
	            return head;
	        }
	        ListNode temp = reverseList(head.next);
	        head.next.next = head;
	        head.next = null;
	        return temp;
	    }
	}
	class Solution3 {
		// 局部翻转，暂时没能理解
	    public ListNode reverseList(ListNode head) {
	        if (head == null) { return null; }
	        ListNode curr = head;
			while(head.next != null) {
				ListNode temp = head.next.next;
				head.next.next = curr;
				curr = head.next;
				head.next = temp;
			}
			return curr;
	    }
	}
}
