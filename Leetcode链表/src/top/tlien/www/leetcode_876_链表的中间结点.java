package top.tlien.www;
// https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
public class leetcode_876_链表的中间结点 {
	public ListNode middleNode(ListNode head) {
        if (head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next;
    }
}
