


import java.io.PrintWriter;



public class RandomInputgenerator {
	public static void main(String[] args) throws Exception 
	{
		if(args.length == 0)
		{
			System.out.println("Please enter InputFile name");
			System.out.println("Usage: java (FileName) (Input File)");
			return;
		}
		else if(args.length>2)
		{
			System.out.println("Please enter only 1 argument");
			return;
		}
		
		else if(args.length==2)
		{
			PrintWriter writer;
			
				writer = new PrintWriter(args[0], "UTF-8");
			 			String result="";
			int random=1;
		    int size=Integer.parseInt(args[1]);
		    random=(int)Math.floor((Math.random()*10000));
		    
		    result=result+random;
			for (int i=1; i<size;i++)
			{
				 System.out.println(Math.random());
			     random=(int)Math.floor(Math.random()*100000);
			     result=result+","+random;
			}
			writer.print(result);
			writer.close();
			
		}
	}
}
