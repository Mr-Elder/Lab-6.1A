
// ****************************************************************
// Sales.java
//
// Reads in and stores sales for each of 5 salespeople.  Displays
// sales entered by salesperson id and total sales for all salespeople.
//
// ****************************************************************

public class Sales
{
	
    public static void main(String[] args)
    {
    	String message = "";
    	
		final int people = GetInfo.getInt("Enter how many sales people");
		int[] sales = new int[people];
		int sum = 0;

		for(int i = 0; i < people; i++){
			sales[i] = GetInfo.getInt("Enter sale for person : " + (i+1));
		
			message += "Seller ID#"+ (i+1) + " sold $" + sales[i] + "\n"; 
				
			sum+= sales[i];
		}
		
		message += "\n\nSum of all sales : " + sum;
		message += "\nAverage sales : " + sum/people;
		
		int topSeller = -100000000;
		int bottomSeller = 1000000000;
		
		int top = 0, bottom = 0;
		for(int i = 0; i < people; i++){
			
			if(sales[i] < bottomSeller){
				bottomSeller = sales[i];
				bottom = i;	
			}
			
			if(sales[i] > topSeller){
				topSeller = sales[i];
				top = i;	
			}
		}
		
		message += "\nMax sale : ID(" + (top+1) + ") " + topSeller;
		message += "\nMin sale : ID(" + (bottom+1) + ")" + bottomSeller + "\n\n\n";
		
		GetInfo.showMessage(message);
		message = "";
		
		int threshold = GetInfo.getInt("Enter a threshold value");
		sum = 0;
		
		for(int i = 0; i < people; i++){
			if(sales[i] > threshold){
				message+= "\nSalesman #" + (i+1) + " exceeded the threshold with $" + sales[i];
				sum++;
			}
		}

		message += "\n\n\n" + sum  + " people exceeded the threshold";
		
		GetInfo.showMessage(message);
    }
}


