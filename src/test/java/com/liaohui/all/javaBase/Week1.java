package com.liaohui.all.javaBase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;



/**
 * @auther Mr.Liao
 * @date 2022/10/29 22:55
 */

public class Week1 {

    public static void main(String[] args) {
        //java的Scanner类无法在单元测试中使用，在这里用main方法演示
        Scanner scan = new Scanner(System.in);
//        ArrayList<Integer>  arr = new ArrayList<>(); 有现成的排序API
        int tmp,n;
        n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i <n ; i++) {
            tmp = scan.nextInt();
            arr[i] = tmp;
        }
        arrSort(arr,0,arr.length-1);
        System.out.println(arr[n/2]);

    }
    private static void arrSort(int[] arr,int low,int high) {
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        arrSort(arr, low, j-1);
        //递归调用右半数组
        arrSort(arr, j+1, high);

    }

    @Test
    public void testSort(){
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer>  arr = new ArrayList<>();
        int tmp,n;
        n = scan.nextInt();
        for (int i = 0; i <n ; i++) {
            tmp = scan.nextInt();
            arr.add(tmp);
        }


    }
}
