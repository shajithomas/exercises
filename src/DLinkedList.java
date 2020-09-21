public class DLinkedList {
	public static void main ( String [] args) {
		DLinkedList list = new DLinkedList();
		insertData(list);
		System.out.println ("The linked list is as follows");
		list.print();
		System.out.println("\n---------------------------------------");

		DLinkedList list2 = new DLinkedList();
		insertData2(list2);
		list2.print();

		
		//To check how an explicit insertAfter works. Sort order is not maintained
		//list.insertAfter(5, 7);
		//list.insertAfter(12, 44);
		//System.out.println ("The  new linked list is as follows");
		//list.print();
	}

	private static void insertData(DLinkedList list) {
		list.insert(10);
		list.insert(15);
		list.insert(5);
		list.insert(22);
		list.insert(3);
		list.insert(3);
		list.insert(12);
		list.insert(15);
	}
	private static void insertData2(DLinkedList list) {
		list.insert2(10);
		list.insert2(15);
		list.insert2(5);
		list.insert2(22);
		list.insert2(3);
		list.insert2(3);
		list.insert2(12);
		list.insert2(15);
	}



	Link head = null;
	class Link {
		Link next;
		Link prev;
		int data;
		Link(int data, Link next,Link prev){
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
		public void print(){
			Integer left = prev != null ? prev.data : null;
			Integer right = next != null ? next.data : null;
			System.out.println( left + " <-- " + data + " --> " + right);
		}
	}
	//insert into a sorted linked List
	public void insert(int data) {
		if ( head == null ) {
			head = new Link(data, head,null);
		} else if ( data <= head.data ) {
			Link newNode =  new Link(data, head,null);
			head.prev =  newNode;
			head = newNode;
		} else {
			Link curNode = head;
			Link prevNode = head;
			while ( (curNode = curNode.next) != null ) {
				if (data <= curNode.data) {
					Link newNode = new Link( data, curNode,curNode.prev);
					prevNode.next = newNode;
					curNode.prev = newNode;
					break;
				} else {
					prevNode = curNode;
				}
			}
			if (curNode == null ) { // we are at the end of the list. add it here
				prevNode.next = new Link ( data,null,prevNode);
			}
		}
	}

	public void insert2(int data) {
		if ( head == null) {
			head = new Link(data, null, null);
		} else if (data <= head.data) {
			Link link = new Link(data, head, null);
			head.prev = link;
			head = link;
		} else {
			Link curLink = head;
			while (curLink.next != null && curLink.next.data < data ) {
				curLink = curLink.next;
			}
			Link temp = curLink.next;
			curLink.next = new Link(data, temp, curLink);
			if ( temp != null) {
				temp.prev = curLink.next;
			}
		}
	}
	
	/*
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
	*/
	public void print() {
		Link curNode = head;
		while ( curNode != null ) {
			System.out.print(curNode.data + " --> ");
//			curNode.print();
			curNode = curNode.next;
		}
	}	
}	

