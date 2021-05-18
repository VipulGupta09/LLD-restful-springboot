package org.linkedlist;

import java.util.ArrayList;
import java.util.Collections;

class List{
	int data;
	List next;
	List bottom;
	
	public List(int data) {
		this.data = data;
		this.next = next;
		this.bottom = bottom;
	}
}

public class FlatternLinkedList {

	public static void main(String[] args) {
		List node = new List(5);
		node.bottom = new List(7);
		node.bottom.bottom = new List(8);
		node.bottom.bottom = new List(30);
		node.next = new List(10);
		node.next.bottom = new List(20);
		node.next.next = new List(19);
		node.next.next.bottom = new List(22);
		node.next.next.bottom.bottom = new List(50);
		node.next.next.next = new List(28);
		node.next.next.next.bottom = new List(35);
		node.next.next.next.bottom.bottom = new List(40);
		node.next.next.next.bottom.bottom.bottom = new List(45);
		
		find(node);
	}
	
	public static void find(List root) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        List curr = root;
	    while(curr!=null){
	    	List temp = curr;
	        while(temp!=null){
	            list.add(temp.data);
	            temp = temp.bottom;
	        }
	        curr = curr.next;
	    }
	    Collections.sort(list);
	    List newList = new List(0);
	    root = newList;
	    for(int i =0;i<list.size();i++){
	        newList.next = new List(list.get(i));
	        newList = newList.next;
	        
	    }
	    root =root.next;
    
	}

}
