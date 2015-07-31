package cn.xiaobaidonghui.queue;

/**
 * ����������ʵ�ֵ�ѭ�����У���Ϊѭ����������Ϊ����β��������Ķ���ʱ���������ĵ׶��Ѿ��ճ������βѭ��������ĵ׶ˡ�
 * ����Ϊ�����ȳ�ģʽ���������û��ķ��ʡ�����Ӻͳ��Ӹ��ӶȾ�ΪO(1)
 * @author baidonghui
 *
 */
public class QueueX
{
    int[] mData;
    int mSize;
    int mFront;
    int mRear;
    int mCount;
    
    public QueueX(int size)
    {
        mSize = size;
        mData = new int[size];
        mFront = 0;
        mRear = -1;
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
    
    public boolean enque(int key)
    {
        if(isFull())
        {
            return false;
        }
        
        if(mRear == mSize - 1)
        {
            mRear = -1;
        }
        
        mData[++mRear] = key;
        mCount++;
        return true;
    }
    
    public int deque()
    {
        if(isEmpty())
        {
            return Integer.MIN_VALUE;
        }
        
        int rtn = mData[mFront++];
        if(mFront == mSize)
        {
            mFront = 0;
        }
        mCount--;
        return rtn;
    }
}
