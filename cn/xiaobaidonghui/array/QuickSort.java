package cn.xiaobaidonghui.array;
/**
 * ��������
 * @author baidonghui
 */
public class QuickSort
{
    public static void sort(int[] data)
    {
        sort(data, 0, data.length - 1);
    }
    
    private static void sort(int[] array, int lBound, int hBound)
    {
        /* �ⲿ�ֲ���Ҫ���� */
        if(lBound >= hBound)
        {
            return;
        }        
        /* ��������Ϊ��Ŧ */
        int pivot = array[lBound];
        /* ���ڴ洢����ŦС��Ԫ�� */
        int storeIndex = lBound + 1;        
        /* ����һ�����ҵ�����ŦС��Ԫ�����storeIndexԪ�ؽ��� */
        for(int i = lBound + 1; i<=hBound; i++)
        {
            if(array[i] < pivot)
            {
                swap(array, i, storeIndex);
                ++storeIndex;
            }
        }
        /* �����һ������ŦС��Ԫ������Ŧ���������������Ŧ��඼����ŦС���Ҳ඼����Ŧ�� */
        swap(array, lBound, storeIndex - 1);
        /* �ֱ�������������������� */
        sort(array, lBound, storeIndex - 2);
        sort(array, storeIndex, hBound);
    }

    private static void swap(int[] array, int i, int j)
    {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
