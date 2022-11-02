package com.liaohui.all.javaBase;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @auther Mr.Liao
 * @date 2022/10/29 23:35
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();//学号个数
        String tmp;
        //考虑到交互数据一般为JSON格式 在处理时常常转换为字符串 因此后面n行均用字符串接收
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tmp = scan.next();
            list.add(tmp);
        }
//        System.out.println(list);

        for (String s : list) {
            if(s.length()<12) {
                System.out.println(false);
            }
            else if(!StringUtils.isNumeric(s.substring(0,11))){
                System.out.println(false);
            } else {
                String grade = s.substring(0, 4);
                String college = s.substring(4, 6);
                String department = s.substring(6, 8);
                String classNum = s.substring(8, 10);
                String num = s.substring(10);
                System.out.println(true + "," + grade + "," + college + "," + department + "," + classNum + "," + num);
            }
        }

    }
}
