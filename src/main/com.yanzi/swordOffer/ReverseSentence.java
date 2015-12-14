package com.yanzi.swordOffer;

/*反转一个字符串句子*/

public class ReverseSentence {

	public static void main(String[] args){
		ReverseSentence test = new ReverseSentence();
		String ss = "  ";
		char[] arr = ss.toCharArray();
		System.out.println(ss.length()+"  "+arr.length);
		System.out.println(test.reverseSentence("  "));
	}
    public String reverseSentence(String str) {
    	if(str == null )
    		return null;
    	if(str.length() == 0)
    		return "\"\"";
        
        char[] arr = str.toCharArray();
        if(arr == null || arr.length == 0)
            return null;
        ReverseStr(arr,0,arr.length-1);       
        int begin = 0;
        int end = arr.length-1;
        for(int i  = 0; i <= end;i++){
            if(arr[i] == ' '){
                ReverseStr(arr, begin, i-1);
                begin = i+1;
            }
            if(i == end){
            	 ReverseStr(arr, begin, end);
            }
        }
        return new String(arr);
        
    }
    public void ReverseStr(char[] arr, int begin, int end){
        int length = arr.length-1;
        if(arr == null || length == 0 || end < begin || end < 0 || begin > length)
            return ;
        if(begin < 0)
            begin = 0;
        if(end > length)
            end = length;
        while(end>begin){
            char temp = arr[end];
            arr[end] = arr[begin];
            arr[begin] = temp;   
            begin++;
            end--;
        }
    }
}
