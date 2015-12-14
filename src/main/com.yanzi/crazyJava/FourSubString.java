package com.yanzi.crazyJava;

public class FourSubString {
        public static String getSubString(String str, int begin, int end) {
            byte[] c = str.getBytes();
            byte[] c2 = new byte[end - begin + 1];
            int j = 0;
            for (int i = begin; i < end + 1; i++) {
                c2[j] = c[i];
                j++;
            }
            String sub=new String(c2);
            return sub;
        }
        public static void main(String[] args) {
            System.out.println(getSubString("ÖÐ¹úabc", 0, 5));
        }
}
