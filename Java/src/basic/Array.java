package basic;
import java.util.*;

public class Array extends Execute implements MethodArrayClass{
//	byte
	public void Sort(byte[] array, int mode) {
		int i, j, index;
		int l = array.length;
		
		for(i = 0; i < l - 1; ++i) {
			index = i;
			for(j = i + 1; j < l; ++j) {
				if(mode == 1 && array[j] < array[index]) {
					index = j;
				}
				
				if(mode == 0 && array[j] > array[index]) {
					index = j;
				}
			}
			
			byte tmp = array[i];
			array[i] = array[index];
			array[index] = tmp;
		}
	}
	
//	short
	public void Sort(short[] array, int mode) {
		int i, j, index;
		int l = array.length;
		
		for(i = 0; i < l - 1; ++i) {
			index = i;
			for(j = i + 1; j < l; ++j) {
				if(mode == 1 && array[j] < array[index]) {
					index = j;
				}
				
				if(mode == 0 && array[j] > array[index]) {
					index = j;
				}
			}
			
			short tmp = array[i];
			array[i] = array[index];
			array[index] = tmp;
		}
	}
	
//	int
	public void Sort(int[] array, int mode) {
		int i, j, index;
		int l = array.length;
		
		for(i = 0; i < l - 1; ++i) {
			index = i;
			for(j = i + 1; j < l; ++j) {
				if(mode == 1 && array[j] < array[index]) {
					index = j;
				}
				
				if(mode == 0 && array[j] > array[index]) {
					index = j;
				}
			}
			
			int tmp = array[i];
			array[i] = array[index];
			array[index] = tmp;
		}
	}
	
//	long
	public void Sort(long[] array, int mode) {
		int i, j, index;
		int l = array.length;
		
		for(i = 0; i < l - 1; ++i) {
			index = i;
			for(j = i + 1; j < l; ++j) {
				if(mode == 1 && array[j] < array[index]) {
					index = j;
				}
				
				if(mode == 0 && array[j] > array[index]) {
					index = j;
				}
			}
			
			long tmp = array[i];
			array[i] = array[index];
			array[index] = tmp;
		}
	}
	
//	float
	public void Sort(float[] array, int mode) {
		int i, j, index;
		int l = array.length;
		
		for(i = 0; i < l - 1; ++i) {
			index = i;
			for(j = i + 1; j < l; ++j) {
				if(mode == 1 && array[j] < array[index]) {
					index = j;
				}
				
				if(mode == 0 && array[j] > array[index]) {
					index = j;
				}
			}
			
			float tmp = array[i];
			array[i] = array[index];
			array[index] = tmp;
		}
	}
	
//	double
	public void Sort(double[] array, int mode) {
		int i, j, index;
		int l = array.length;
		
		for(i = 0; i < l - 1; ++i) {
			index = i;
			for(j = i + 1; j < l; ++j) {
				if(mode == 1 && array[j] < array[index]) {
					index = j;
				}
				
				if(mode == 0 && array[j] > array[index]) {
					index = j;
				}
			}
			
			double tmp = array[i];
			array[i] = array[index];
			array[index] = tmp;
		}
	}
	
//	char
	public void Sort(char[] array, int mode) {
		int i, j, index;
		int l = array.length;
		
		for(i = 0; i < l - 1; ++i) {
			index = i;
			for(j = i + 1; j < l; ++j) {
				if(mode == 1 && array[j] < array[index]) {
					index = j;
				}
				
				if(mode == 0 && array[j] > array[index]) {
					index = j;
				}
			}
			
			char tmp = array[i];
			array[i] = array[index];
			array[index] = tmp;
		}
	}
	
//	string
	public void Sort(String[] array, int mode) {
		int i, j, index;
		int l = array.length;
		
		for(i = 0; i < l - 1; ++i) {
			index = i;
			for(j = i + 1; j < l; ++j) {
				if(mode == 1 && array[j].compareTo(array[index]) < 0) {
					index = j;
				}
				
				if(mode == 0 && array[j].compareTo(array[index]) > 0) {
					index = j;
				}
			}
			
			String tmp = array[i];
			array[i] = array[index];
			array[index] = tmp;
		}
	}
	
	public void Show(byte[] array) {
		for (byte i : array) {
			echo(i + "\n");
		}
	}
	
	public void Show(short[] array) {
		for (short i : array) {
			echo(i + "\n");
		}
	}
	
	public void Show(int[] array) {
		for (int i : array) {
			echo(i + "\n");
		}
	}
	
	public void Show(long[] array) {
		for (long i : array) {
			echo(i + "\n");
		}
	}
	
	public void Show(float[] array) {
		for (float i : array) {
			echo(i + "\n");
		}
	}
	
	public void Show(double[] array) {
		for (double i : array) {
			echo(i + "\n");
		}
	}
	
	public void Show(char[] array) {
		for (char i : array) {
			echo(i + "\n");
		}
	}
	
	public void Show(String[] array) {
		for (String i : array) {
			echo(i + "\n");
		}
	}
	
	public byte Sum(byte[] array) {
		byte sum = 0;
		for (byte i : array) {
			sum += i;
		}
		
		return sum;
	}
	
	public short Sum(short[] array) {
		short sum = 0;
		for (short i : array) {
			sum += i;
		}
		
		return sum;
	}
	
	public int Sum(int[] array) {
		int sum = 0;
		for (int i : array) {
			sum += i;
		}
		
		return sum;
	}
	
	public long Sum(long[] array) {
		long sum = 0;
		for (long i : array) {
			sum += i;
		}
		
		return sum;
	}
	
	public float Sum(float[] array) {
		float sum = 0;
		for (float i : array) {
			sum += i;
		}
		
		return sum;
	}
	
	public double Sum(double[] array) {
		double sum = 0;
		for (double i : array) {
			sum += i;
		}
		
		return sum;
	}
	public String Sum(String[] array) {
		String sum = "";
		for (String i : array) {
			sum += i;
		}
		
		return sum;
	}
}