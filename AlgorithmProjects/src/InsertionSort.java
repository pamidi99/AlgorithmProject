import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * InsertionSort Program reads the input data, preferably any number(integer,float,double etc..) from file through command line argument.
 * Sorts the data and stores the result into answer.txt.
 * Delimiter should be ","
 */
//Second Commit 23
public class InsertionSort {

	public InsertionSort() {
	}

	public static void main(String[] args) 
	{
		if(args.length == 0)
		{
			System.out.println("Please enter InputFile name");
			System.out.println("Usage: java (FileName) (Input File)");
			return;
		}
		else if(args.length > 1)
		{
			System.out.println("Please enter only 1 argument");
			return;
		}
		else
		{
			ArrayList<Integer> list = null;
			BufferedReader reader = null;
			

			try {
				//reading contents from input.txt and storing it in ArrayList
				String text = null;
				String inputFile = args[0];
				reader = new BufferedReader(new FileReader(inputFile));
				list = new ArrayList<Integer>();
				
				while ((text = reader.readLine()) != null) 
				{
					String[] resultingTokens = text.split(",");
					for (int i = 0; i < resultingTokens.length; i++)
					{
						list.add(Integer.parseInt(resultingTokens[i].trim()));
					}
				}
                                long startTime = System.currentTimeMillis();
                System.out.println("start time"+startTime);
				//Insertion Sort
				for (int i=1; i< list.size(); i++)
				{
					Integer key = list.get(i);
					int j;
					//Using ParseDouble to make string comparisons
					for (j = i - 1; j >= 0 && (list.get(j)>key) ; j--)
					{
						list.set(j+1, list.get(j));
					}
					list.set(j+1, key);
				}

				long endTime = System.currentTimeMillis();
				System.out.println("end time"+endTime);
				//Print sorted data into answer.txt file
				PrintWriter writer = new PrintWriter("answer.txt", "UTF-8");
				writer.print("size of input list is "+list.size()+"\n");
				writer.print("It took " + (endTime - startTime) + " milliseconds to run the program"+ "\n");
				writer.print("elements in sorted order: ");
				for (int i=0; i< list.size(); i++)
				{
					writer.print(list.get(i));
					if(i != list.size() - 1)
					{
						writer.print(", ");
					}		    	
				}
				writer.close();
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			} 
			
		}
	}

}
