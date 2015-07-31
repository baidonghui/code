package cn.xiaobaidonghui.array;

/**
 * ���Ƕ���ͨ����ķ�װ��������Ӧ����㷺�����ݴ洢�ṹ������������Ԫ��������˲������ֻ��Ҫһ������������ֻ�����Ա������ҡ�
 * 
 * <h3>��Ҫ����</h3>
 * <p>������� �㷨���Ӷ�O(1) see {@link #insert(int)} </p>
 * <p>���Ҳ��� �㷨���Ӷ�O(N) see {@link #find(int)} </p>
 * <p>ɾ������ �㷨���Ӷ�O(N) see {@link #delete(int)} </p>
 * 
 * @author baidonghui
 * @version 1.0
 */
public class ArrayX {
	int[] mData;
	int mSize;
	int mCount;
	
	/**
	 * ���캯��
	 * @param size ��ʼ������Ĵ�С
	 */
	public ArrayX(int size)
	{
		mData = new int[size];
		mSize = size;
		mCount = 0;
	}
	
	public boolean isEmpty()
	{
		return (mCount == 0);
	}
	
	public boolean isFull()
	{
		return (mCount == mSize);
	}
	
	/**
	 * ����Ԫ��
	 * @param key Ҫ����Ԫ�صĹؼ���
	 * @return �ɹ������򷵻�������Ԫ�ص����������򷵻�-1��
	 */
	public int insert(int key)
	{
		if(!isFull())
		{
			mData[mCount++] = key;	//�˴����˸�ֵ��Ҫ��������������Ԫ�ظ���
			return mCount;
		}
		else
		{
			return -1;
		}
	}
	
	/**
	 * ����һ����������Ҫ���Ԫ��
	 * @param key Ҫ���ҵĹؼ��� 
	 * @return �ҵ��򷵻�����>=0���Ҳ����򷵻�-1
	 */
	public int find(int key)
	{
		for(int i = 0; i < mCount; i++)
		{
			if(mData[i] == key)
			{
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * ɾ��һ������Ҫ���Ԫ��
	 * @param key Ҫɾ���Ĺؼ���
	 * @return û���ҵ�Ҫɾ����Ԫ���򷵻�-1�����򷵻�������ʣ���Ԫ�ظ���
	 */
	public int delete(int key)
	{
		int index = find(key);
		if(index == -1)
		{
			return -1;
		}
		
		/* ͨ��ѭ������һ��Ƶ�ǰһ�� */
		for(int i = index + 1; i < mCount; i++)
		{
			mData[i - 1] = mData[i];
		}
		
		mCount--;  //������Ԫ�ظ���-1
		return mCount;
	}		
	
	public void display()
	{
		for(int i = 0; i < mCount; i++)
		{
			System.out.print(mData[i] + " ");
		}
		System.out.println();
	}
}
