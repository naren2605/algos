package edu.naren;

public class LinkedList<Data extends Comparable<Data>>{
	Node<Data> root,next=null;
	public LinkedList() {
	}
	public LinkedList<Data> add(Data data){
		if(root==null){
		LinkedList<Data> list = new LinkedList<Data>(data);
		this.root=list.root;
		this.next=list.next;
		list=null;
		}
		else{
			Node<Data> addElement=new Node<Data>(data);
			next.front=addElement;
			addElement.rear=next;
			next=next.front;	
		}
		return this;
	}
	/**
	 * index position starts with 0 to length-1
	 * @param position
	 * @return linked list
	 */
	public LinkedList<Data> delete(int position){
		
		int i=-1;
		for(Node node=root;node!=null;node=node.front){
		i++;
		if(i==position){
			return delete(node);
		}	
		}
		if(position>i){
			throw new RuntimeException("element doesn't exist");
		}
		return this;
	}
	
	public Data deleteAndReturnData(int position){
		
		int i=-1;
		if(position<0){
			throw new RuntimeException("element doesn't exist");
		}
		for(Node<Data> node=root;node!=null;node=node.front){
		i++;
		if(i==position){
			Data data=node.data;
			 delete(node);
			 return data;
		}	
		}
		if(position>i||i<0){
			throw new RuntimeException("element doesn't exist");
		}
		return null;
	}
	
	public LinkedList<Data> delete(Data data){
		if(root==null){
			throw new RuntimeException("no elements in list to delete");
		}
	//	System.out.println("deleting...");
		for(Node node=root;node!=null;node=node.front){
			if(node.data.equals(data)){
				if(node.rear!=null&&node.front!=null){
					node.rear.front=node.front;
					node.front.rear=node.rear;
				}
				else if(node.front==null&&node.rear!=null){
					node.rear.front=null;
					next=node.rear;
					node.rear=null;
				}
				else if(node.rear==null&&node.front!=null){
					root=node.front;
					node.front.rear=null;
				}
				else if(node.rear==null&&node.front==null){
					root=null;
					next=null;
				}
			}
		}
		return this;
	}
	
	public LinkedList<Data> delete(Node delnode){
		if(root==null){
			throw new RuntimeException("no elements in list to delete");
		}
		System.out.println("deleting...");
		for(Node node=root;node!=null;node=node.front){
			if(node==delnode){
				if(node.rear!=null&&node.front!=null){
					node.rear.front=node.front;
					node.front.rear=node.rear;
				}
				else if(node.front==null&&node.rear!=null){
					node.rear.front=null;
					next=node.rear;
					node.rear=null;
				}
				else if(node.rear==null&&node.front!=null){
					root=node.front;
					node.front.rear=null;
				}
				else if(node.rear==null&&node.front==null){
					root=null;
					next=null;
				}
			}
		}
		return this;
	}
	
	
	public void display(){
		for(Node node=root;node!=null;node=node.front){
			System.out.print(node+"-->");
		}
	}
	public LinkedList(Data data) {
		next=root=new Node<Data>(data);
		
	}
	
	static class Node<Data extends Comparable<Data>>{
		Data data;
		Node<Data> rear=null;
		Node<Data> front=null;
		
		public Node(Data data) {
		this.data=data;
		}
			@Override
			public String toString() {
				return data+"";
			}
		
	}

	
/**
 * unit test client for linked list	
 * @param args
 */
	
	
	
	
public static void main(String[] args) {
	LinkedList<String> list= new LinkedList<String>("1");
	list.add("2").add("3").add("4").add("5");
	list.delete(0);
	list.display();
}
}
