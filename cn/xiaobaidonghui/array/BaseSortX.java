package cn.xiaobaidonghui.array;

/**
 * �����������������������򷽷���
 * <p>ð������ {@link #bubbleSort(int[])} </p>
 * <p>ѡ������ {@link #selectSort(int[])} </p>
 * <p>�������� {@link #insertSort(int[])} </p>
 * <p>����������ĸ��Ӷȶ�ΪO(N^2)��</p>
 * <p>ѡ��������ð��������ȣ��������Ĵ�����O(N^2)��С��O(N)�����ڻ��������������ԣ��������������Ӹ�Ч��</p>
 * @author baidonghui
 */
public class BaseSortX
{
    /**
     * ð������ʼ ������
     * �����Ƚ�ѡȡ�ϴ�ֵ����ĳ����ѭ�������󣬴��������Ҳ��Ԫ�ض��Ǿ��������(������)�������һ��ѭ�����������Ƚϡ�
     * @param array ����Ҫ���������
     */
    public static void bubbleSort(int[] array)
    {
        int n = array.length;
        for (int i = n - 1; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (array[j] > array[j + 1])    //˫��ѭ��Ƕ�ף��˴��Ƚϸ��Ӷ�O(n^2)
                {
                    swap(array, j, j + 1);  //˫��ѭ��Ƕ�ף��˴��������Ӷ�O(n^2)
                }
            }
        }
    }
    
    /**
     * ѡ����������
     * ÿ����ѭ��ѡȡ�����򲿷ֵ���Сֵ�������򲿷ֵĵ�һ��Ԫ��������
     * ��˵�ĳ��ѭ�������󣬴�����������Ԫ�ض��Ǿ��������(������)�������һ�����������Ƚ�
     * ѡ�������ǲ��ȶ��ģ����Թ۲�{ 3,1,5,8,6,5,2}������5����ǰ���˳��
     * @param array ����Ҫ���������
     */
    public static void selectSort(int[] array)
    {   
        int n = array.length;
        for (int i = 0; i < n - 1; i++)
        {
            int min = i; //min��ʾδ������������СԪ�ص��±�
            for (int j = i + 1; j < n; j++)
            {
                if (array[j] < array[min])  //˫��ѭ��Ƕ�ף��˴��Ƚϸ��Ӷ�O(n^2)
                {
                    min = j;
                }
            }
            swap(array, min, i);    //����ѭ�����˴��Ƚϸ��Ӷ�O(n)
        }
    }

    /**
     * ������������
     * ���������Ǿֲ�����ģ����ⲿ��������ģ�������λ�ò��ǲ���ġ�(������)
     * ÿ����ѭ��ִ��ʱ��ȡ��δ���򲿷ֵĵ�һ��Ԫ�أ�
     * ���κ;ֲ������Ԫ�ش���������бȽϣ�ֱ���ҵ����ʵ�λ�ò����ȥ��
     * @param array ����Ҫ���������
     */
    public static void insertSort(int[] array)
    {
        int n = array.length;
        for(int i = 1;i<n;i++)
        {
           int temp = array[i];
           int j = i;
           while(j > 0 && array[j] > temp)
           {
               array[j]= array[j-1];    //˫��ѭ��Ƕ�ף��˴����Ƹ��Ӷ�O(n^2)
               j--;
           }
           array[j] = temp; //����ѭ�����˴����Ƹ��Ӷ�O(n)
        }
    }  
    
    /**
     * ������Ԫ�صĽ���
     * @param array ����Ҫ�������������
     * @param i ��һ������
     * @param j �ڶ�������
     */
    private static void swap(int[] array, int i, int j)
    {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
