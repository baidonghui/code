package cn.xiaobaidonghui.queue;

/**
 * 这是由数组实现的循环队列，称为循环队列是因为当队尾到达数组的顶端时，如果数组的底端已经空出，则队尾循环到数组的底端。
 * 队列为先入先出模式，限制了用户的访问。其入队和出队复杂度均为O(1)
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
