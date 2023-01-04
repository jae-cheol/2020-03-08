package 코딩테스트.Part1.Ch07_링크드리스트;

public class SingleLinkedList<T> {
	public Node<T> head = null;	// 최초에는 아무것도 없으니깐 null

	public class Node<T> {
		T data;
		Node<T> next = null;

		Node(T data) {
			this.data = data;
		}
	}

	// 노드 추가
	public void addNode(T data) {
		if (this.head == null) {
			this.head = new Node<T>(data);
		} else {
			Node<T> node = this.head;
			while (node.next != null) {
				node = node.next;
			}
			node.next = new Node<T>(data);
		}
	}

	// 노드 전체 출력
	public void printAll() {
		if (head != null) {
			Node<T> node = this.head;
			System.out.println(node.data);
			while (node.next != null) {
				node = node.next;
				System.out.println(node.data);
			}
		}
	}

	// 노드를 원하는 위치에 삽입.(삽입데이터, 이전데이터)
	public void addNodeInside(T data, T isData) {
		Node<T> searchedNode = this.search(isData);
		
		if(searchedNode == null) {
			this.addNode(data);
		} else {
			Node<T> nextNode = searchedNode.next;
			searchedNode.next = new Node<T>(data);
			searchedNode.next.next = nextNode;
		}
	}
	
	// 해당 노드 검색
	public Node<T> search(T data) {
		if(this.head == null) {
			return null;
		} else {
			Node<T> node = this.head;
			while(node != null) {
				if(node.data == data) {
					return node;
				} else {
					node = node.next;
				}
			}
			return null;
		}
	}
	
	// 해당 노드 삭제
	public boolean delNode(T isData) {
		if(this.head == null) {
			return false;
		} else {
			Node<T> node = this.head;
			if(node.data == isData) {
				this.head = this.head.next;
				return true;
			} else {
				while(node.next != null) {
					if(node.next.data == isData) {
						node.next = node.next.next;
						return true;
					} else {
						node = node.next;
					}
				}
				return false;
			}
		}
	}
}