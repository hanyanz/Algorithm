package com.yanzi.hihoCoder;
/*���֮��������һ��
 * ���� :���������ϵ�£�һ����˵�������õ��ĵ�λ���ȣ����ǡ��ס������Ĺ��ʵ�λ�������������صĳ��ȡ����������������ϵ�еĴ�С��
 * ����ͼ���������һ���ǳ���Ҫ�������������������Ѿ���������������õ���ͷ���������С(focal length)���������Ƭ�Ŀ��(CCD width)��
 * �Լ���Ƭ�ĺ���ֱ���(image width)���������㹫ʽΪ��Focal length in pixels = (image width in pixels) * (focal length on earth) / (CCD width on earth);
 * ���ڣ�����дһ��ͨ�õĳ�������⽹�����������ϵ�еĴ�С��
 * 
 * ����:����������ݡ�������һ��������T����ʾ�������ݵ�������ÿ���������ռһ�У��ֱ�Ϊ��ͷ���������С(focal length on earth)\
 * �����Ƭ�Ŀ��(CCD width on earth)\��Ƭ�ĺ���ֱ��ʴ�С(image width in pixels)����λΪpx��֮����һ���ո�ָ���
 * 
 * ���:ÿ���������һ�У���ʽΪ��Case X: Ypx���� XΪ�������ݵı�ţ���1��ʼ��YΪ�������������ϵ�еĴ�С(focallength in pixels)��
 * ����С�����2λ��Ч���֣���������ȡ����
 * 
 * ���ݷ�Χ����С���ݣ�focal length on earth��CCD width on earth��λ���Ǻ���(mm),
 * ���ڴ����ݣ����ȵ�λ������Ϊ��(m), ����(dm), ����(cm), ����(mm), ΢��(um)������(nm)
 * */
import java.util.Scanner;

public class hihoCoder {
	public static void main(String[] args){
		hihoCoder test = new hihoCoder();
		test.run();
	}
	public void run(){
		Scanner fin = new Scanner(System.in);
		//�������������
		int T = fin.nextInt();
		fin.nextLine();
		for(int i =1; i <= T; i++){
			String[] inputData = fin.nextLine().split(" ");
			if(getFocalLength(inputData) >= 0){
			System.out.println("Case "+ i + ": "+new  java.text.DecimalFormat("#.00").format(getFocalLength(inputData))+"px");
			}
			else{
				System.out.println("Illegal input!");
			}
		}
	}
	
	//��⽹�����������ϵ�еĴ�С
	public float getFocalLength(String[] inputData){
		if(inputData == null || inputData.length != 3){
			return -1;
		}
		float focalLength = getValueOfMMUnit(inputData[0]);
		float CCDWidth = getValueOfMMUnit(inputData[1]);
		float imageWidth = Float.parseFloat(inputData[2].substring(0,inputData[2].length()-2));
		if(focalLength != -1 && CCDWidth != -1){
			float result = (imageWidth*focalLength)/CCDWidth;
			return result;
		}
		return -1;
	}
	//�����Ժ���Ϊ��λ����ֵ
	public float getValueOfMMUnit(String str){
		if(str == null || str.length() < 3)
			return -1;
		
		int strLength = str.length();
		String unit = str.substring(strLength-2);
		switch (unit){
			case("mm"):
				return Float.parseFloat(str.substring(0, strLength-2));
			case("nm"):
				return Float.parseFloat(str.substring(0, strLength-2))/(1000000);
			case("um"):
				return Float.parseFloat(str.substring(0, strLength-2))/1000;
			case("cm"):
				return Float.parseFloat(str.substring(0, strLength-2))*10;
			case("dm"):
				return Float.parseFloat(str.substring(0, strLength-2))*100;
			case("m"):
				return Float.parseFloat(str.substring(0, strLength-2))*1000;
			default:
				return  -1;
		}

	}

}
