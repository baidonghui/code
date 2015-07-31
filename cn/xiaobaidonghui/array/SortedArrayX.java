package cn.xiaobaidonghui.array;

/**
 * ����һ����������ķ�װ
 * 
 * ������Ϊ����������ģ� {@link #binarySearch(int, int, int)}Ϊ�ݹ�Ķ��ֲ��ҷ����������ٶȱ���ͨ����Ĳ���Ч��������
 * ��ִ�в������ʱ��Ҫ��������������ԣ������Ҫ���Ҳ����λ�ã��󲿵�Ԫ����Ҫ���θ���Ϊ��Ԫ���ó��ռ䡣
 * 
 * <h3>��Ҫ����</h3>
 * <p>������� �㷨���Ӷ�O(N) see {@link #insert(int)} </p>
 * <p>���Ҳ��� �㷨���Ӷ�O(logN) see {@link #find(int)} </p>
 * <p>ɾ������ �㷨���Ӷ�O(N) see {@link #delete(int)} </p>
 * 
 * @author baidonghui
 * @version 1.0
 */
public class SortedArrayX extends ArrayX {
	
	public SortedArrayX(int maxSize)
	{
		super(maxSize);		
	}
	
	@Override
	public int insert(int key)
	{
		if(isFull())
		{
			return -1;
		}
		else if(isEmpty())
		{
			mData[0] = key;
			mCount++;
		}
		else
		{
			for(int i = mCount - 1; i >=0; i--)
			{
				if(mData[i] > key)
				{
					mData[i+1] = mData[i];
				}
				else
				{
					mData[i + 1] = key;
					mCount++;
					break;
				}	 
			}
		}

		return mCount;
	}

	@Override
	public int find(int key)
	{
		return binarySearch(0, mCount, key);
	}
	
	private int binarySearch(int lBound, int hBound, int key)
	{
		if(lBound > hBound)
		{
			return -1;
		}
		
		int mid = (lBound + hBound) / 2;
		if(mData[mid] == key)
		{
			return mid;
		}
		else if(mData[mid] > key)
		{
			return binarySearch(lBound, mid - 1, key);
		}
		else
		{
			return binarySearch(mid + 1, hBound, key);
		}
	}
	
}
