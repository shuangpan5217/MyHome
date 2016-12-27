

public class InToPostfix {
	private String output = "";
	private String input;
	private CharStack cs;
	
	public InToPostfix(String input)
	{
		this.input = input;
		cs = new CharStack(input.length());
	}
	public String transToPostfix()
	{
		for(int i = 0; i < input.length(); i++)
		{
			char ch = input.charAt(i);
			switch(ch)
			{
			case '+':
			case '-':
				if(cs.isEmpty())
					cs.push(ch);
				else
				{
					char chTop = cs.pop();
					if(chTop == '(')
						cs.push(ch);
					else if(chTop == '*' || chTop == '/')
					{
						output = output + chTop;
						cs.push(ch);
					}
					else if(chTop == '+' || chTop == '-')
					{
						output = output + chTop;
						cs.push(ch);
					}
					
				}
				break;
			case '*':
			case '/':
				if(cs.isEmpty())
					cs.push(ch);
				else
				{
					char chTop = cs.pop();
					if(chTop == '(')
					{
						cs.push(chTop);
						cs.push(ch);
					}
					else if(chTop == '*' || chTop == '/')
					{
						output = output + chTop;
						cs.push(ch);
					}
					else if(chTop == '+' || chTop == '-')
					{
						cs.push(chTop);
						cs.push(ch);
					}
				}
				break;
			case ')':
				while(!cs.isEmpty())
				{
					char chTop = cs.pop();
					if(chTop == '(')
						break;
					else
						output = output + chTop;
				}
				break;
			case '(':
				cs.push(ch);
				break;
			default:
				output = output + ch;
				break;
			}
		} //end of for
		while(!cs.isEmpty())
		{
			char chTop = cs.pop();
			output = output + chTop;
		}
		return output;
	}
	public int parsePostfix()
	{
		int result = 0;
		BasicStack bs = new BasicStack(output.length());
		for(int i = 0; i < output.length(); i++)
		{
			if(output.charAt(i) >= '0' && output.charAt(i) <= '9')
			{
			//	System.out.println((int)output.charAt(i));
				bs.push((int) (output.charAt(i) - '0'));
			}
			else{
				int a = bs.pop();
				int b = bs.pop();
				char ch = output.charAt(i);
				switch(ch)
				{
				case '+':
					result = b + a;
					bs.push(result);
					break;
				case '-':
					result = b - a;
					bs.push(result);
					break;
				case '*':
					result = b * a;
					bs.push(result);
					break;
				case '/':
					result = b / a;
					bs.push(result);
					break;
			}
				}
		}
		result = bs.pop();
		return result;
	}
}
