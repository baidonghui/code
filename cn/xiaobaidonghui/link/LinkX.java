package cn.xiaobaidonghui.link;

/**
 * �������ڱ�ͷ������ɾ���ڵ㸴�Ӷ�ΪO(1)�����Ҹ��Ӷ�O(N)��������λ�ò����ɾ����Ϊ���ҵ�ԭ���Ӷ�O(N)��
 * ��������ȣ�����Ĵ�С�ǿɱ�ģ��������Ǵ�С�̶��ġ�
 * @author baidonghui
 */
public class LinkX
{
    protected NodeX mFirst;

    public boolean isEmpty()
    {
        return (mFirst == null);
    }

    public void insertFirst(NodeX node)
    {
        node.setNext(mFirst);
        mFirst = node;
    }

    public NodeX removeFirst()
    {
        NodeX first = mFirst;
        if (!isEmpty())
        {
            mFirst = mFirst.getNext();
        }
        return first;
    }

    public NodeX find(int key)
    {
        NodeX current = mFirst;
        while (current != null)
        {
            if (current.getKey() == key)
            {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public NodeX insertAfter(int key, NodeX node)
    {
        NodeX current = find(key);
        if (current != null)
        {
            node.setNext(current.getNext());
            current.setNext(node);
            return node;
        }
        return null;
    }

    public NodeX delete(int key)
    {
        if (isEmpty())
        {
            return null;
        }

        NodeX current = mFirst;
        NodeX previous = mFirst;
        while (current != null)
        {
            if (current.getKey() == key)
            {
                break;
            }
            previous = current;
            current = current.getNext();
        }

        previous.setNext(current.getNext());
        return current;
    }

    public void display()
    {
        System.out.println("-------");
        NodeX current = mFirst;
        while (current != null)
        {
            current.display();
            current = current.getNext();
        }
        System.out.println("-------");
    }
}
