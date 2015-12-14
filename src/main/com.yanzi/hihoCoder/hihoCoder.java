package com.yanzi.hihoCoder;
/*编程之美初赛第一场
 * 描述 :在相机坐标系下，一般来说，我们用到的单位长度，不是“米”这样的国际单位，而是相邻像素的长度。而焦距在相机坐标系中的大小，
 * 是在图像处理领域的一个非常重要的物理量。假设我们已经根据相机参数，得到镜头的物理焦距大小(focal length)，和相机胶片的宽度(CCD width)，
 * 以及照片的横向分辨率(image width)，则具体计算公式为：Focal length in pixels = (image width in pixels) * (focal length on earth) / (CCD width on earth);
 * 现在，请您写一段通用的程序，来求解焦距在相机坐标系中的大小。
 * 
 * 输入:多组测试数据。首先是一个正整数T，表示测试数据的组数。每组测试数据占一行，分别为镜头的物理焦距大小(focal length on earth)\
 * 相机胶片的宽度(CCD width on earth)\照片的横向分辨率大小(image width in pixels)，单位为px。之间用一个空格分隔。
 * 
 * 输出:每组数据输出一行，格式为“Case X: Ypx”。 X为测试数据的编号，从1开始；Y为焦距在相机坐标系中的大小(focallength in pixels)，
 * 保留小数点后2位有效数字，四舍五入取整。
 * 
 * 数据范围对于小数据：focal length on earth和CCD width on earth单位都是毫米(mm),
 * 对于大数据：长度单位还可能为米(m), 分米(dm), 厘米(cm), 毫米(mm), 微米(um)，纳米(nm)
 * */
import java.util.Scanner;

public class hihoCoder {
	public static void main(String[] args){
		hihoCoder test = new hihoCoder();
		test.run();
	}
	public void run(){
		Scanner fin = new Scanner(System.in);
		//测试数组的组数
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
	
	//求解焦距在相机坐标系中的大小
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
	//返回以毫米为单位的数值
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
