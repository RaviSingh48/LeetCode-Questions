/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // If the list is empty or contains only one node, return the head as no swapping is needed
        if (head == null || head.next == null) return head;

        // The new head of the list should be the second node after swapping
        ListNode newHead = head.next;
        
        // Pointers for swapping pairs
        ListNode temp1 = head;       // Points to the first node of the pair
        ListNode temp2 = head.next;  // Points to the second node of the pair
        ListNode prev = null;        // Keeps track of the previous swapped node
        
        // Traverse the list while there are pairs available to swap
        while (temp1 != null && temp2 != null) {
            // Swapping logic:
            temp1.next = temp2.next;  // First node now points to the node after the pair
            temp2.next = temp1;       // Second node now points to the first node, completing the swap
            
            // Connect the previously swapped pair to the current swapped pair
            if (prev != null) {
                prev.next = temp2;  
            }

            // Move `prev` to the last swapped node (i.e., temp1)
            prev = temp1;

            // Move `temp1` to the next pair
            temp1 = temp1.next; 
            
            // Ensure `temp2` moves to the next pair's second node (if available)
            if (temp1 != null) temp2 = temp1.next;
        }

        return newHead; // Return the new head of the swapped list
    }
}