package 코딩테스트.Part1.Ch07_링크드리스트;

public class DoubleLinkedList<T> {
	public Node<T> head = null;
	public Node<T> tail = null;	// 끝에서부터 검색하기 위해서.
	
	public class Node<T> {
		T data;
		Node<T> prev = null;	// 이전 Node를 가르키는 포인터.
		Node<T> next = null;	// 다음 Node를 가르키는 포인터.
		
		// 생성자 - 값을 받아서 넣어줌.
		public Node(T data) {
			this.data = data;
		}
	}
	
	public void addNode(T data) {
		// 링크드리스트에 데이터가 없다는 의미.
		if(this.head == null) {
			// 1. 노드를 하나 생성하고,
			this.head = new Node<T>(data);
			// 2. 데이터가 하나니깐, 해당 노드를 가르키도록 만듬.
			this.tail = this.head;
		}
		// 헤드가 있다는 것은 링크드리스트에 노드가 있다는 의미.
		else {
			Node<T> node = this.head;
			// 맨 끝의 노드를 찾는다.
			while(node.next != null) {
				node = node.next;
			}
			// while문이 끝나면 마지막 노드를 찾았다는 뜻이고, 다음 노드에 인자로 받은 데이터를 통해 노드를 만든다.
			node.next = new Node<T>(data);
			// prev는 현재노드를 가르키도록 세팅.
			node.next.prev = node;
			// 지금 생성한게 존재하니깐 tail을 변경해준다.
			this.tail = node.next;
		}
	}
	
	public void printAll() {
		if(this.head != null) {
			Node<T> node = this.head;
			System.out.println(node.data);
			while(node.next != null) {
				node = node.next;
				System.out.println(node.data);
			}
		}
	}
	
	// 맨 앞에서부터 데이터를 찾는 함수.
	public T searchFromHead(T isData) {
		// 데이터가 없는 경우
		if(this.head == null) {
			return null;
		} else {
			Node<T> node = this.head;
			while(node != null) {
				if(node.data == isData) {
					return node.data;
				} else {
					node = node.next;
				}
			}
			// tail까지 검색해도 존재하지 않을때.
			return null;
		}
	}
	
	// 맨 뒤에서부터 데이터를 찾는 함수.
	public T searchFromTail(T isData) {
		if(this.head == null) {
			return null;
		} else {
			Node<T> node = this.tail;
			while(node != null) {
				if(node.data == isData) {
					return node.data;
				} else {
					node = node.prev;
				}
			}
			// head까지 검색해도 존재하지 않을때.
			return null;
		}
	}
	
	/**
	 * existedData 앞에 addData 를 넣어야함.
	 * @param existedData : 해당 데이터를 가진 노드
	 * @param addData : 새로 만들 노드가 가질 데이터
	 * @return
	 */
	public boolean insertToFront(T existedData, T addData) {
		if(this.head == null) {
			this.head = new Node<T>(addData);
			this.tail = this.head;
			return true;
		}
		// 기준 노드가 head노드일때.
		else if(this.head == existedData) {
			Node<T> newHead = new Node<T>(addData);
			// head앞에 추가한다.
			newHead.next = this.head;
			// head를 변경한다.
			this.head = newHead;
			return true;
		} else {
			Node<T> node = this.head;
			while(node != null) {
				if(node.data == existedData) {
					Node<T> nodePrev = node.prev;
					nodePrev.next = new Node<T>(addData);
					nodePrev.next.next = node;
					
					nodePrev.next.prev = nodePrev;
					node.prev = nodePrev.next;
					return true;
				} else {
					node = node.next;
				}
			}
			// 전부 확인해도 existedData를 노드가 없을때.
			return false;
		}
	}
}
