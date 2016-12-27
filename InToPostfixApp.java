package StackAndQueue;

public class InToPostfixApp {
	public static void main(String[] argv)
	{
		InToPostfix itp = new InToPostfix("(3-2)*(5-4)*3+2*3");
		System.out.println(itp.transToPostfix());
		System.out.println(itp.parsePostfix());
	}
}
