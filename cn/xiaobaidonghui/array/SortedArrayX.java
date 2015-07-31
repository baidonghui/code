package cn.xiaobaidonghui.array;

/**
 * 这是一个有序数组的封装
 * 
 * 正是因为数组是有序的， {@link #binarySearch(int, int, int)}为递归的二分查找方法，查找速度比普通数组的查找效率增加了
 * 但执行插入操作时，要保持数组的有序性，因此需要查找插入的位置，后部的元素需要依次复制为新元素让出空间。
 * 
 * <h3>主要操作</h3>
 * <p>插入操作 算法复杂度O(N) see {@link #insert(int)} </p>
 * <p>查找操作 算法复杂度O(logN) see {@link #find(int)} </p>
 * <p>删除操作 算法复杂度O(N) see {@link #delete(int)} </p>
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
