package cn.xiaobaidonghui.stack;

import cn.xiaobaidonghui.link.LinkX;
import cn.xiaobaidonghui.link.NodeX;

/**
 * ����������ʵ�ֵ�ջ��ջΪ�����ȳ�ģʽ�������û��ķ��ʣ����ݵĳ�ջ����ջ���Ӷȶ�ΪO(1)��
 * @author baidonghui
 */
public class LinkedStackX implements IStackX
{
    LinkX mLink;
    
    public LinkedStackX()
    {
        mLink = new LinkX();
    }

    @Override
    public boolean isEmpty()
    {
        return mLink.isEmpty();
    }

    @Override
    public boolean push(int key)
    {
        mLink.insertFirst(new NodeX(key));
        return true;
    }

    @Override
    public int pop()
    {
        NodeX first = mLink.removeFirst();
        if(first == null)
        {
            return Integer.MIN_VALUE;
        }
        else
        {
            return first.getKey();
        }
    }
    
    
}
