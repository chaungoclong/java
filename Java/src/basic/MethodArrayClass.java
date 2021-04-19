package basic;

public interface MethodArrayClass {
//	sort
	public void Sort(byte[] array, int mode);
	public void Sort(short[] array, int mode);
	public void Sort(int[] array, int mode);
	public void Sort(long[] array, int mode);
	public void Sort(float[] array, int mode);
	public void Sort(double[] array, int mode);
	public void Sort(char[] array, int mode);
	public void Sort(String[] array, int mode);
	
//	show
	public void Show(byte[] array);
	public void Show(short[] array);
	public void Show(int[] array);
	public void Show(long[] array);
	public void Show(float[] array);
	public void Show(double[] array);
	public void Show(char[] array);
	public void Show(String[] array);
	
//  sum
	public byte Sum(byte[] array);
	public short Sum(short[] array);
	public int Sum(int[] array);
	public long Sum(long[] array);
	public float Sum(float[] array);
	public double Sum(double[] array);
	public String Sum(String[] array);
}
