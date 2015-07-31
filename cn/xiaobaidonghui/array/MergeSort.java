package cn.xiaobaidonghui.array;

/**
 * ��������
 * <p> ����������Ҫ˫���Ĵ洢�ռ� {@link #mTemp}������ֻ��һ����ʱ������</p>
 * <p> ��������ĵݹ�������������Ϊ ����һ�����飬�Ƚ�ǰ�벿�ֺͺ�벿�ֱַ��ò�������������Ȼ����ʹ�úϲ������ó����յ��������顣 see
 * {@link #sort(int, int)} </p>
 * @author baidonghui
 */
public class MergeSort
{
    int[] mArray;
    int[] mTemp;

    public MergeSort(int[] data)
    {
        mArray = data;
        mTemp = new int[data.length];
    }

    /**
     * ������������в�������
     */
    public void sort()
    {
        sort(0, mArray.length - 1);
    }

    /**
     * ��������ĵݹ����
     * @param lBound ʹ�ò��������������С����
     * @param hBound ʹ�ò�������������������
     */
    public void sort(int lBound, int hBound)
    {
        if (lBound == hBound)
            return;

        int mid = (lBound + hBound) / 2;
        sort(lBound, mid);
        sort(mid + 1, hBound);
        merge(lBound, mid, mid + 1, hBound);
    }

    /**
     * �����ĺϲ���������������������ڵ����򲿷���ϳ�һ���������飬��д�ص�ԭʼ�����С�
     * Ҫģ��������������Ļ����ϲ������������� mArray = {1,5,9,52,2,3,12,68}����0-3Ϊһ���������飬4-7Ϊ��һ���������顣
     * @param aMin ��һ���������С����
     * @param aMax ��һ��������������
     * @param bMin �ڶ����������С���� = ��һ�������������� + 1
     * @param bMax �ڶ���������������
     */
    private void merge(int aMin, int aMax, int bMin, int bMax)
    {
        int org = aMin;
        int c = aMin;
        /* �ȽϺ󽫽�С��Ԫ�ظ��Ƶ���ʱ�����У�����������λ�� */
        while (aMin <= aMax && bMin <= bMax)
        {
            if (mArray[aMin] < mArray[bMin])    
            {
                mTemp[c++] = mArray[aMin++];
            }
            else
            {
                mTemp[c++] = mArray[bMin++];
            }
        }
        /* ��һ��������Ϊ��ʱ����ʣ�����һ���ֶ�����ʱ�����е�Ԫ��Ҫ�󣬶���˳���Ѿ����кã�ֱ�Ӹ��Ƶ���ʱ���顡*/
        while (aMin <= aMax) 
        {
            mTemp[c++] = mArray[aMin++];
        }

        while (bMin <= bMax)
        {
            mTemp[c++] = mArray[bMin++];
        }
        /* ���źõ��������ʱ���鸴�ƻ�ԭʼ���� */
        c = org;
        while (c <= bMax)
        {
            mArray[c++] = mTemp[c++];
        }
    }
}
