package com.yanzi.qunar;
/*去哪儿实习笔试第二题：为一串字符串解码，数字前面的字符子串重复数值次数
 * 考虑开头不是字母而是数字，则直接把数字记下来，不重复
 * 如果结尾处不是数字，那么要把结尾的字符子串也记下来，不重复
 * 考虑到空对象 和字符串长度为0的情况
 * */
public class Quanr_decodeString {

	public static void main(String[] args){
		Quanr_decodeString test = new Quanr_decodeString();
		String str = "123aba2a";
		System.out.println(test.decode(str));
	}
	public String decode(String str){
		if( str == null || str.length() == 0  )
			return null;
		int index = 0;
		StringBuffer buffer = new StringBuffer();
		StringBuffer bufferTem = new StringBuffer();
		while(true){
			if(isNum(str.charAt(index))){
					buffer.append(str.charAt(index));
					index++;
			}
			else
				break;
		}
		for(int i = index; i < str.length(); i++){
			if(isNum(str.charAt(i))){
				int length = (int) str.charAt(i)-'0';
				for(int j = 0; j < length; j++){
					buffer.append(bufferTem);
				}
				bufferTem.setLength(0);
				continue;
			}
			else{
				bufferTem.append(str.charAt(i));
				continue;
			}
		}
		//如果字符串不是以数字结束的，那么要把结尾处的字母补上
		if(bufferTem.length() != 0){
			buffer.append(bufferTem);
		}
		return buffer.toString();
		
	}
	public boolean isNum(char c){
		if(c >= '0' && c <= '9')
			return true;
		else
			return false;
	}
}
