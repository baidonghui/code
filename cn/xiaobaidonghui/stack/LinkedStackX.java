package cn.xiaobaidonghui.stack;

import cn.xiaobaidonghui.link.LinkX;
import cn.xiaobaidonghui.link.NodeX;

/**
 * 这是由链表实现的栈，栈为后入先出模式，限制用户的访问，数据的出栈和入栈复杂度都为O(1)。
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
