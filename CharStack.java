package StackAndQueue;

public class CharStack {
		private int maxSize;
		private char[] Stack;
		private int top;
		
		public CharStack(int maxSize)
		{
			Stack = new char[maxSize];
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
		public void push(char number)
		{
			if(isFull())
				System.out.println("The stack is full. You can't continue pushing any items");
			else
			{
				top++;
				Stack[top] = number;
			}
		}
		public char pop()
		{
			if(isEmpty())
			{
	//			System.out.println("The stack is empty. You can't do any popping opreation");
				System.out.println("n is popped. n that is popped means the Stack is empty.");
				return 'n';
			}
			else
			{
				char a = Stack[top];
				System.out.println(Stack[top] + " is popped.");
				top--;
				return a;
			}
		}
		public void peek()
		{
			System.out.println("The top of the stack is " + Stack[top]);
		}
		
	}

