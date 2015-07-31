package cn.xiaobaidonghui.array;

/**
 * 这是对普通数组的封装，数组是应用最广泛的数据存储结构。由于数组中元素无序，因此插入操作只需要一步，而查找则只能线性遍历查找。
 * 
 * <h3>主要操作</h3>
 * <p>插入操作 算法复杂度O(1) see {@link #insert(int)} </p>
 * <p>查找操作 算法复杂度O(N) see {@link #find(int)} </p>
 * <p>删除操作 算法复杂度O(N) see {@link #delete(int)} </p>
 * 
 * @author baidonghui
 * @version 1.0
 */
public class ArrayX {
	int[] mData;
	int mSize;
	int mCount;
	
	/**
	 * 构造函数
	 * @param size 初始化数组的大小
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
	 * 插入元素
	 * @param key 要插入元素的关键字
	 * @return 成功插入则返回数组中元素的总数，否则返回-1；
	 */
	public int insert(int key)
	{
		if(!isFull())
		{
			mData[mCount++] = key;	//此处除了赋值不要忘记增加数组中元素个数
			return mCount;
		}
		else
		{
			return -1;
		}
	}
	
	/**
	 * 查找一个满足满足要求的元素
	 * @param key 要查找的关键字 
	 * @return 找到则返回索引>=0，找不到则返回-1
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
	 * 删除一个满足要求的元素
	 * @param key 要删除的关键字
	 * @return 没有找到要删除的元素则返回-1，否则返回数组中剩余的元素个数
	 */
	public int delete(int key)
	{
		int index = find(key);
		if(index == -1)
		{
			return -1;
		}
		
		/* 通过循环将后一项复制到前一项 */
		for(int i = index + 1; i < mCount; i++)
		{
			mData[i - 1] = mData[i];
		}
		
		mCount--;  //数组中元素个数-1
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
