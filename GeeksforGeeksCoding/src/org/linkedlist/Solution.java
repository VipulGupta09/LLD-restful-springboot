package org.linkedlist;

import java.util.ArrayList;
import java.util.Stack;

class LinkedList {
	int val;
	LinkedList next;

	public LinkedList(int val, LinkedList next) {
		this.val = val;
		this.next = next;
	}
}

public class Solution {

	public static void main(String[] args) {
		LinkedList node = new LinkedList(7, null);

		node.next = new LinkedList(58, null);
		node.next.next = new LinkedList(36, null);
		
		node.next.next.next = new LinkedList(34, null);
		node.next.next.next.next = new LinkedList(16, null);
		node.next.next.next.next.next = node.next;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		//node.next.next.next = new LinkedList(15, null);
		//node.next.next.next.next = new LinkedList(30, null);
		//node.next.next.next.next.next = new LinkedList(6, null);

		LinkedList node2 = new LinkedList(10, null);
		node2.next = node.next.next.next;

		// findMiddleElement(node);
		// reverseLinkedList(node);
		// counterClockwiseRotate(node, 7);
		// reverseLinkedListInChunks(node, 3);
		//intersectionPoint(node, node2);
		//removeLoop(node);
		
		LinkedList list1 = new LinkedList(5, null);
		list1.next = new LinkedList(10, null);
		list1.next.next = new LinkedList(15, null);
		list1.next.next.next = new LinkedList(40, null);
		
		LinkedList list2 = new LinkedList(2, null);
		list2.next = new LinkedList(3, null);
		list2.next.next = new LinkedList(20, null);
		list2.next.next.next = new LinkedList(20, null);
		list2.next.next.next.next = new LinkedList(3, null);
		list2.next.next.next.next.next = new LinkedList(2, null);
		
		//merge2SortedLinkedList(list1, list2);
		
		checkLinkedListIsPallindrome(list2);
		

	}

	public static void findMiddleElement(LinkedList root) {
		LinkedList slow = root;
		LinkedList fast = root;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println(slow.val);
	}

	// 1 2 3 4 5
	public static void reverseLinkedList(LinkedList root) {
		LinkedList prev = null;
		LinkedList curr = root;

		while (curr != null) {
			LinkedList temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		System.out.println(prev.val);

	}

	public static void counterClockwiseRotate(LinkedList root, int k) {

		LinkedList curr = root;
		int size = 0;
		while (curr != null) {
			curr = curr.next;
			size++;
		}
		int rotation = k % size;

		if (rotation < 1) {
			System.out.println("No rotation required");
			return;
		}

		LinkedList fast = root;

		while (rotation > 1) {
			fast = fast.next;
			rotation--;
		}
		curr = root;

		LinkedList temp = fast.next;
		fast.next = null;

		LinkedList newHead = temp;

		while (temp.next != null)
			temp = temp.next;

		temp.next = root;

		System.out.println(newHead.val);

	}

	public static void reverseLinkedListInChunks(LinkedList root, int k) {
		Stack<LinkedList> stack = new Stack<LinkedList>();
		LinkedList prev = null;
		LinkedList curr = root;

		while (curr != null) {
			int count = 0;
			while (curr != null && count < k) {
				stack.push(curr);
				curr = curr.next;
				count++;
			}

			while (!stack.isEmpty()) {
				if (prev == null) {
					prev = stack.peek();
					root = prev;
					stack.pop();
				} else {
					prev.next = stack.peek();
					prev = prev.next;
					stack.pop();
				}
			}
		}
		prev.next = null;

		System.out.println(root);
	}

	public static int intersectionPoint(LinkedList l1, LinkedList l2) {

		LinkedList list1 = l1;
		LinkedList list2 = l2;

		int len1 = 1;
		int len2 = 1;
		while (list1 != null) {
			list1 = list1.next;
			len1++;
			// System.out.print(len1);
		}
		while (list2 != null) {
			list2 = list2.next;
			len2++;
			// System.out.print(len2);
		}
		list1 = l1;
		list2 = l2;
		int diff = 0;
		if (len1 > len2) {
			diff = len1 - len2;
			while (diff > 0) {
				list1 = list1.next;
				diff--;
			}
		} else {
			diff = len2 - len1;
			while (diff > 0) {
				list2 = list2.next;
				diff--;
			}
		}

		while (list1 != null && list2 != null) {
			if (list1 == list2) {
				return list1.val;
			}
			list1 = list1.next;
			list2 = list2.next;
		}
		return -1;

	}
	
	public static boolean detectLoop(LinkedList head){
		LinkedList slow = head;
		LinkedList fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
	
	public static void removeLoop(LinkedList head){
		LinkedList slow = head;
		LinkedList fast = head;
		head = slow;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow.next == fast.next){
                slow.next = null;
                fast.next = null;
            }
        }
    }
	
	public static void merge2SortedLinkedList(LinkedList head1, LinkedList head2) {
		LinkedList prev = null;
		while(head1!=null && head2!=null) {
			if(head1.val<=head2.val) {
				LinkedList temp = head1.next;
				head1.next = prev;
				prev = head1;
				head1 = temp;
			}
			else {
				LinkedList temp = head2.next;
				head2.next = prev;
				prev = head2;
				head2 = temp;
			}
		}
		while(head1!=null) {
			LinkedList temp = head1.next;
			head1.next = prev;
			prev = head1;
			head1 = temp;
		}
		while(head2!=null) {
			LinkedList temp = head2.next;
			head2.next = prev;
			prev = head2;
			head2 = temp;
		}
		System.out.println(prev);
				
	}
	
	public static void checkLinkedListIsPallindrome(LinkedList list) {
		LinkedList slow = list;
		LinkedList fast = list;
		
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if(fast!=null)
		slow= slow.next;
		
		LinkedList prev = null;
		while(slow!=null) {
			LinkedList next = slow.next;
			slow.next = prev;
			prev = slow;
			slow = next;
		}
		
		while(prev!=null) {
			if(prev.val!=list.val)
				System.out.println("Not Pallindrome");
			prev = prev.next;
			list = list.next;
		}
		System.out.println("Pallindrome");
	}

}
