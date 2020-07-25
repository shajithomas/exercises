public class MyLinkedList<N> {
	public static void main ( String [] args) {
/*
		MyLinkedList<N> list = new MyLinkedList<N>();
		list.insert(10);
		list.insert(15);
		list.insert(5);
		list.insert(22);
		list.insert(3);
		list.insert(3);
		list.insert(12);
		list.insert(15);
		System.out.println ("The linked list is as follows");
		list.print(list.head);
		Link revList = list.reverseList(list.head);
		System.out.println("================================");
		list.print(revList);
*/


		
		//To check how an explicit insertAfter works. Sort order is not maintained
		//list.insertAfter(5, 7);
		//list.insertAfter(12, 44);
		//System.out.println ("The  new linked list is as follows");
		//list.print();
	}
	Link head = null;
	class Link {
		Link next;
		int data;
		Link(int data, Link next){
			this.data = data;
			this.next = next;
		}
	}
	public void insert(int data) {
		if ( head == null || data <= head.data ) {
			head = new Link(data, head);
		} else {
			Link curNode = head;
			Link prevNode = head;
			while ( (curNode = curNode.next) != null ) {
				if (data <= curNode.data) {
					prevNode.next = new Link( data, curNode);
					break;
				} else {
					prevNode = curNode;
				}
			}
			if (curNode == null ) { // we are at the end of the list. add it here
				prevNode.next = new Link ( data,null);
			}
		}
	}
	public Link reverseList(Link head) {
		if (head == null || head.next == null) {
			return head;
		}
		Link curNode = head;
		Link nextNode = head.next;
		head.next = null;
		while (nextNode != null) {
			Link temp = nextNode.next;
			nextNode.next = curNode;
			curNode = nextNode;
			nextNode = temp;
		}
		return curNode;
	}
	
	public void insert1(int data) {
		if ( head == null ) { 
			head = new Link(data,null);
		} else if ( data <= head.data) {
			Link tempNode = new Link(data, head);
			head = tempNode;
		} else {
			Link curNode = head;
			Link prevNode = head;
			while ( (curNode = curNode.next) != null ){
				if ( data <= curNode.data) {
					Link node = new Link(data, curNode);
					prevNode.next = node;
					break;
				} else {
					prevNode = curNode;
				}
				
			}
			if ( curNode == null ) {
				prevNode.next = new Link( data,null);
			}
		}
	}
	public void insertAfter(int data1, int data) {
		if ( head == null ) System.out.println("empty list");
		Link curNode = head;
		do {
			if ( data1 == curNode.data ) {
				Link tempNode = new Link ( data, curNode.next);
				curNode.next = tempNode;
				break;
			}
		} while ( (curNode = curNode.next) != null );
		if (curNode == null ) System.out.println("Unable to find the node: " + data1); 
	}
	
	public void print(Link head) {
		Link curNode = head;
		while ( curNode != null ) {
			System.out.println(curNode.data);
			curNode = curNode.next;
		}
	}	
}	

