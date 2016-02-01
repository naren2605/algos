package edu.naren;

public class StackList<Data extends Comparable<Data>> {
LinkedList<Data> list = new LinkedList<Data>();

	public StackList<Data> push(Data data){
		list.add(data);
		return this;
	}
	public Data pop(){
		if(list.next==null){
			throw  new RuntimeException("stack is empty");	
		}
		Data data= list.next.data;
		list.delete(list.next);
		return data;
	}
	public Data delete(int position){
		return list.deleteAndReturnData(position);
	}
	
	
	public void display(){
		list.display();
	}
	
	public static void main(String[] args) {
		
		
		StackList<String> stack= new StackList<String>();
		
		stack.push("a").push("b").push("c");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
	}
}
