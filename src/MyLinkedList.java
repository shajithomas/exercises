import org.junit.Test;

/*
 Sorted linked list implementation
 */
public class MyLinkedList {
	public static void main ( String [] args) {
		MyLinkedList list = new MyLinkedList();
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

	public void insert2(int data) {
		if ( head == null || data <= head.data) {
			head = new Link(data,head);
		} else {
			Link curNode = head;
			while (curNode.next != null && curNode.next.data < data) {
				curNode = curNode.next;
			}
			curNode.next = new Link(data, curNode.next);
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

	public static class UnitTest {
		@Test
		public void testInsertAndReverse() {
			MyLinkedList list = new MyLinkedList();
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

		}

		@Test
		public void testInsert2AndReverse() {
			MyLinkedList list = new MyLinkedList();
			list.insert2(10);
			list.insert2(15);
			list.insert2(5);
			list.insert2(22);
			list.insert2(3);
			list.insert2(3);
			list.insert2(12);
			list.insert2(15);
			System.out.println ("The linked list is as follows");
			list.print(list.head);

			Link revList = list.reverseList(list.head);
			System.out.println("================================");
			list.print(revList);

		}


	}
}	

