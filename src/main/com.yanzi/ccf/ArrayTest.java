package com.yanzi.ccf;

import java.util.Scanner;

public class ArrayTest {
     public static void main(String[] args) {

         Scanner sc=new Scanner(System.in);
         System.out.println("������һ��3*3����������(����quit��������)");

         //����һ���ɱ��͵�StringBuffer����¼�û�������ַ�
         StringBuffer sb=new StringBuffer(sc.nextLine());

         //�������A����������
         int[][] A=new int[3][3];
         int i=0;

         //�����û����룬����A����
         while(!(("quit").equals(sb.toString().trim()))){ //�ж��Ƿ�ΪԼ������ֹ�����ַ���
              //StringBufferת��ΪString����
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
         System.out.println("������һ��3*3����������B��");
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


         System.out.println("����A�ǣ�");
         for(int m=0;m<3;m++) {
             for(int n=0;n<3;n++) {
                 System.out.print(A[m][n]+"\t");
             }
             System.out.println();
         }

         System.out.println("����B�ǣ�");
         for(int m=0;m<3;m++) {
             for(int n=0;n<3;n++) {
                 System.out.print(B[m][n]+"\t");
             }
             System.out.println();
         }

            //��ӡ����ӡ�������������������
         System.out.println("����A+B�Ľ�������ǣ�");
         for(int m=0;m<3;m++) {
             for(int n=0;n<3;n++) {
                 System.out.print((A[m][n]+B[m][n])+"\t");
             }
             System.out.println();
         }

         System.out.println("����A-B�Ľ�������ǣ�");
         for(int m=0;m<3;m++) {
             for(int n=0;n<3;n++) {
                System.out.print((A[m][n]-B[m][n])+"\t");
             }
             System.out.println();
         }

    }
}