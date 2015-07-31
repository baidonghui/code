package cn.xiaobaidonghui.queue;

/**
 * 优先级队列的数组实现，它是一种队列，不具有循环队列的特性，只有一个队头（在 {@link #mSize} - 1 处），一个队尾（永远在下标为0处）。
 * 其中的数据项在插入时不是跟在队尾，而是寻找自己的位置，其他数据也要为其腾出空间，所以优先级队列的插入操作复杂度O(N)
 * 而最小值永远在队头，出队复杂度O(1)
 * @author baidonghui
 *
 */
public class PriorityQueueX
{
    int[] mData;
    int mSize;
    int mCount;

    public PriorityQueueX(int size)
    {
        mSize = size;
        mData = new int[size];
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
        if (isFull())
        {
            return false;
        }
        else
        {
            int i = mCount;
            while (i > 0 && mData[i - 1] < key)
            {
                mData[i] = mData[i - 1];
                i--;
            }
            mData[i] = key;

            mCount++;
        }
        return true;
    }
    

    public int deque()
    {
        if (isEmpty())
        {
            return Integer.MIN_VALUE;
        }

        return mData[--mCount];
    }
}
