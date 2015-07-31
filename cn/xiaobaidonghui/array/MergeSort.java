package cn.xiaobaidonghui.array;

/**
 * 并归排序
 * <p> 并归排序需要双倍的存储空间 {@link #mTemp}，而不只是一个临时变量。</p>
 * <p> 并归排序的递归操作法可以理解为 对于一个数组，先将前半部分和后半部分分别用并归排序变得有序，然后在使用合并操作得出最终的有序数组。 see
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
     * 将整个数组进行并归排序
     */
    public void sort()
    {
        sort(0, mArray.length - 1);
    }

    /**
     * 并归排序的递归调用
     * @param lBound 使用并归排序的数组最小索引
     * @param hBound 使用并归排序的数组最大索引
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
     * 基础的合并操作，将数组的两个相邻的有序部分组合成一个有序数组，并写回到原始数组中。
     * 要模拟两个有序数组的基本合并操作，可以设 mArray = {1,5,9,52,2,3,12,68}，从0-3为一个有序数组，4-7为另一个有序数组。
     * @param aMin 第一个数组的最小索引
     * @param aMax 第一个数组的最大索引
     * @param bMin 第二个数组的最小索引 = 第一个数组的最大索引 + 1
     * @param bMax 第二个数组的最大索引
     */
    private void merge(int aMin, int aMax, int bMin, int bMax)
    {
        int org = aMin;
        int c = aMin;
        /* 比较后将较小的元素复制到临时数组中，并更新索引位置 */
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
        /* 当一部分数组为空时，则剩余的另一部分都比临时数组中的元素要大，而且顺序已经排列好，直接复制到临时数组　*/
        while (aMin <= aMax) 
        {
            mTemp[c++] = mArray[aMin++];
        }

        while (bMin <= bMax)
        {
            mTemp[c++] = mArray[bMin++];
        }
        /* 将排好的数组从临时数组复制回原始数组 */
        c = org;
        while (c <= bMax)
        {
            mArray[c++] = mTemp[c++];
        }
    }
}
