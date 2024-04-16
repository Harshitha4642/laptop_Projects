package websites;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class odoController {
	private int reading = 1234;
	
	public void reset() {
	    this.reading = 1234;
	  }
	private int[] makeArray(int reading) {
		List <Integer> result= new ArrayList <Integer>();
		while(reading>0)
		{
			result.add(reading%10);
			reading=reading/10;
		}
	    Collections.reverse(result);
	    int res[]= new int[result.size()];
	    for(int i = 0;i<result.size();i++)
	    	res[i]=result.get(i);
	    return(res);
	}
	
	private int makeNumber(int[] array) {
		int size=array.length-1;
		int result=0,i=0;
		while(size>=0)
		{
			result=result+(int) (array[i]* Math.pow(10,size));
			--size;	
			i++;
		}
		return result;
	}
	private boolean isAscending(int reading)
	{
		int i;
		boolean result=true;
		int readArray[]= makeArray(reading);
		for(i = 0;i<readArray.length-1;i++)
		{
			if(readArray[i]>=readArray[i+1]) {
				return(false);
			}
		}
		if(i==readArray.length-1)
			result=true;
		
		return (result);
	}
	
	public int nextReading(int reading) {
		if(isAscending(reading)) {
			int readArray[]= makeArray(reading);
			int max[]= {9,8,7,6,5,4,3,2,1};
			int size=readArray.length;
			int i=size-1;
			while(i>=0)
			{
				if(readArray[i]<max[size-1-i])
				{
					int number=makeNumber(readArray);
					if(isAscending(number) && i==size-1) {
						readArray[i]=readArray[i]+1;
						int numb=makeNumber(readArray);
						return(numb);
					}
					else {
						int temp = readArray[i]+1;
						for(int var=i;var<=size-1;var++)
						{
							readArray[var]=temp++;
						}
						int result=makeNumber(readArray);
						return(result);		
					}
				}
				else if(readArray[i]==max[size-1-i])
				 {
					 i--;
				 }
				
				}
			}
			return(1);
		}
	
	public int prevReading(int reading)
	{
		if(isAscending(reading)) {
			int readArray[]= makeArray(reading);
			int max[]= {9,8,7,6,5,4,3,2,1};
			int size=readArray.length;
			int i=size-1;
			while(i>=0) {
				if(i!=0 && readArray[i]!=readArray[i-1]+1)
				{
					readArray[i]=readArray[i]-1;
					int numb=makeNumber(readArray);
					return(numb);
				}
				else {
					if(i!=0) {
					readArray[i]=max[size-1-i];
					i--;
					}
					else {
						readArray[i]=readArray[i]-1;
						int numb=makeNumber(readArray);
						return(numb);
					}
				}
			}
		}
		return(0);
	}
	
	public static void main(String args[])
	{
		odoController o = new odoController();
		System.out.println(o.prevReading(1234));
		System.out.println(o.nextReading(678));
	}
}
