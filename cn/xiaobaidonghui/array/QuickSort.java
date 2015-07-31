package cn.xiaobaidonghui.array;
/**
 * 快速排序
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
        /* 这部分不需要排序 */
        if(lBound >= hBound)
        {
            return;
        }        
        /* 设最左侧的为枢纽 */
        int pivot = array[lBound];
        /* 用于存储比枢纽小的元素 */
        int storeIndex = lBound + 1;        
        /* 遍历一次若找到比枢纽小的元素则和storeIndex元素交换 */
        for(int i = lBound + 1; i<=hBound; i++)
        {
            if(array[i] < pivot)
            {
                swap(array, i, storeIndex);
                ++storeIndex;
            }
        }
        /* 将最后一个比枢纽小的元素与枢纽交换，则完成了枢纽左侧都比枢纽小，右侧都比枢纽大 */
        swap(array, lBound, storeIndex - 1);
        /* 分别对左右两部分在做快排 */
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
