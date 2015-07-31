package cn.xiaobaidonghui.queue;

/**
 * ���ȼ����е�����ʵ�֣�����һ�ֶ��У�������ѭ�����е����ԣ�ֻ��һ����ͷ���� {@link #mSize} - 1 ������һ����β����Զ���±�Ϊ0������
 * ���е��������ڲ���ʱ���Ǹ��ڶ�β������Ѱ���Լ���λ�ã���������ҲҪΪ���ڳ��ռ䣬�������ȼ����еĲ���������Ӷ�O(N)
 * ����Сֵ��Զ�ڶ�ͷ�����Ӹ��Ӷ�O(1)
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
