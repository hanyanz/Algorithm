package com.yanzi.swordOffer;

public class ReplaceBlank4 {
	public static void main(String[] args){
		String origStr = " ";
		
//		replaceBlank(origStr,50);
		replaceBlankUseStringBuilder(origStr);
	}
	//���и��Ĳ�����char[],length;  ������StringΪ�������д���
	public static void replaceBlank(String origStr, int length){
		if(origStr == null || origStr.equals("")){
			return;
		}
		int blankCount = 0;
		for(int i = 0; i < origStr.length(); i++){
			if(origStr.charAt(i) == ' ')
				blankCount++;
		}
	    int charLength = origStr.length()+ 2*blankCount;
	    if(charLength > length){
	    	return;
	    }
	    //charLength--��Ϊ���������ѭ���У� charArr[charLength--]��Խ�磻
	    char[] charArr = new char[charLength--];
	    for(int j = origStr.length()-1; j >= 0;j--){
	    	if(origStr.charAt(j) == ' '){
	    		charArr[charLength--] = '0';
	    		charArr[charLength--] = '2';
	    		charArr[charLength--] = '%';
	    	}
	    	else{
	    		charArr[charLength--] = origStr.charAt(j);
	    	}
	    }
	    System.out.println(new String(charArr));
	}
	
	public static void replaceBlankUseStringBuilder(String origStr){
		if(origStr == null || origStr == ""){
			System.out.println("wrong input");
			return;
		}
		StringBuilder strBuilder = new StringBuilder();
		for(int i = 0; i < origStr.length(); i++){
			if(origStr.charAt(i) == ' '){
				strBuilder.append("20%");
			}
			else{
				strBuilder.append(origStr.charAt(i));
			}
		}
		System.out.println(strBuilder.toString());
	}
	

}
