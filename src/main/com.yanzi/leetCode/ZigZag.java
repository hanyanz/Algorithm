package com.yanzi.leetCode;

public class ZigZag {
	public static void main(String[] args){
		ZigZag test = new ZigZag();
		System.out.print(test.convert("PAYPALISHIRING", 3));
	}
	public String convert(String str,int nRows){
		if(nRows <= 1 || str.length() <= nRows || str == null)
		    return str;
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < str.length(); i += (nRows-1)*2){
			sb.append(str.charAt(i));
		}
		for (int i = 1; i < nRows -1; i++){
			for(int j = i; j < str.length(); j += (nRows-1)*2){
				sb.append(str.charAt(i));
				if(j+(nRows-i-1)*2 < str.length()){
					sb.append(str.charAt(j+(nRows- i-1)*2));
				}
			}			
		}
		for(int i = nRows-1; i < str.length(); i += (nRows-1)*2){
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}

}
