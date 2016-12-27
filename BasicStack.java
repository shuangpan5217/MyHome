package StackAndQueue;

public class BasicStack {
	private int maxSize;
	private int[] Stack;
	private int top;
	
	public BasicStack(int maxSize)
	{
		Stack = new int[maxSize];
		this.maxSize = maxSize;
		top = -1;
	}
	public boolean isFull()
	{
		if(top == maxSize - 1)
			return true;
		else
			return false;
	}
	public boolean isEmpty()
	{
		if(top == -1)
			return true;
		else 
			return false;
	}
	public void push(int number)
	{
		if(isFull())
			System.out.println("The stack is full. You can't continue pushing any items");
		else
		{
			top++;
			Stack[top] = number;
		}
	}
	public int pop()
	{
		if(isEmpty())
		{
			System.out.println("The stack is empty. You can't do any popping opreation");
			return Integer.MIN_VALUE;
		}
		else
		{
			int temp = Stack[top];
			System.out.println(Stack[top] + " is popped.");
			top--;
			return temp;
		}
	}
	public void peek()
	{
		System.out.println("The top of the stack is " + Stack[top]);
	}
	
}
