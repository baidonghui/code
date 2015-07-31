package cn.xiaobaidonghui.stack;

/**
 * 这是由数组实现的栈，栈为后入先出模式，限制用户的访问，数据的出栈和入栈复杂度都为O(1)。
 * @author baidonghui
 */
public class StackX implements IStackX
{
    int[] mData;
    int mSize;
    int mTop;    //类似一个指针，标识栈顶所在下标。
    
    public StackX(int size)
    {
        mSize = size;
        mData = new int[size];
        mTop = -1;
    }
    
    public boolean isEmpty()
    {
        return (mTop == -1);
    }
    
    public boolean isFull()
    {
        return (mTop == mSize - 1);
    }
    
    /**
     * 将数据压入栈中
     * @param key 数据项
     * @return 返回操作是否成功
     */
    public boolean push(int key)
    {
        if(!isFull())
        {
            mData[++mTop] = key;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * 将数据弹出栈
     * @return 返回栈顶元素，如果栈为空，范围整型最小值
     */
    public int pop()
    {
        if(!isEmpty())
        {
            return mData[mTop--];
        }
        else
        {
            return Integer.MIN_VALUE;
        }
    }

}
