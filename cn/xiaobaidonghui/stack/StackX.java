package cn.xiaobaidonghui.stack;

/**
 * ����������ʵ�ֵ�ջ��ջΪ�����ȳ�ģʽ�������û��ķ��ʣ����ݵĳ�ջ����ջ���Ӷȶ�ΪO(1)��
 * @author baidonghui
 */
public class StackX implements IStackX
{
    int[] mData;
    int mSize;
    int mTop;    //����һ��ָ�룬��ʶջ�������±ꡣ
    
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
     * ������ѹ��ջ��
     * @param key ������
     * @return ���ز����Ƿ�ɹ�
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
     * �����ݵ���ջ
     * @return ����ջ��Ԫ�أ����ջΪ�գ���Χ������Сֵ
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
