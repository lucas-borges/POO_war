package etc;
import java.util.Random;

public class Dices {
	
	public Dices ()
	{
		
	}
	
	public int[] lancar_dados (int n)
	{
		Random dicesNumber = new Random();
		int nums [] = new int[n];
		
		for(int i=0;i<n;i++)
		{
			nums [i] =  dicesNumber.nextInt(6) + 1;
		}
		
		return nums;
	}
	

}
