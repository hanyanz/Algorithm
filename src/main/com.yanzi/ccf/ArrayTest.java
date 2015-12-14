package com.yanzi.ccf;

import java.util.Scanner;

public class ArrayTest {
     public static void main(String[] args) {

         Scanner sc=new Scanner(System.in);
         System.out.println("请输入一个3*3的整数矩阵：(输入quit结束输入)");

         //建立一个可变型的StringBuffer，记录用户输入的字符
         StringBuffer sb=new StringBuffer(sc.nextLine());

         //定义矩阵A：整数数组
         int[][] A=new int[3][3];
         int i=0;

         //根据用户输入，创建A矩阵
         while(!(("quit").equals(sb.toString().trim()))){ //判定是否为约定的终止输入字符串
              //StringBuffer转化为String数组
              String[] ss=sb.toString().split(" ");
              for(int j=0;j<3;j++){
                A[i][j]=Integer.parseInt(ss[j]);
              }
              i++;
              sb.setLength(0);
              sb.append(sc.nextLine());
         }


         int[][] B = new int[3][3];
         int k=0;
         System.out.println("请输入一个3*3的整数矩阵B：");
         sb.append(sc.nextLine());
         while(!"quit".equals(sb.toString().trim())){
             String[] ss = sb.toString().split(" ");
              for(int j=0;j<3;j++) {
                 B[k][j]=Integer.parseInt(ss[j].replaceAll("quit", ""));
              }
             k++;
             sb.setLength(0);
             sb.append(sc.nextLine());
         }
         sc.close();


         System.out.println("矩阵A是：");
         for(int m=0;m<3;m++) {
             for(int n=0;n<3;n++) {
                 System.out.print(A[m][n]+"\t");
             }
             System.out.println();
         }

         System.out.println("矩阵B是：");
         for(int m=0;m<3;m++) {
             for(int n=0;n<3;n++) {
                 System.out.print(B[m][n]+"\t");
             }
             System.out.println();
         }

            //打印出相加、相减后的两个矩阵内容
         System.out.println("矩阵A+B的结果矩阵是：");
         for(int m=0;m<3;m++) {
             for(int n=0;n<3;n++) {
                 System.out.print((A[m][n]+B[m][n])+"\t");
             }
             System.out.println();
         }

         System.out.println("矩阵A-B的结果矩阵是：");
         for(int m=0;m<3;m++) {
             for(int n=0;n<3;n++) {
                System.out.print((A[m][n]-B[m][n])+"\t");
             }
             System.out.println();
         }

    }
}