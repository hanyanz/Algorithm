package com.yanzi.qunar;
/*ȥ�Ķ�ʵϰ���Եڶ��⣺Ϊһ���ַ������룬����ǰ����ַ��Ӵ��ظ���ֵ����
 * ���ǿ�ͷ������ĸ�������֣���ֱ�Ӱ����ּ����������ظ�
 * �����β���������֣���ôҪ�ѽ�β���ַ��Ӵ�Ҳ�����������ظ�
 * ���ǵ��ն��� ���ַ�������Ϊ0�����
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
		//����ַ������������ֽ����ģ���ôҪ�ѽ�β������ĸ����
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
