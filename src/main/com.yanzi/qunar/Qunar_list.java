package com.yanzi.qunar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*实现对一个list中数据的处理,返回小于某个值的所有数；
 * 返回比某个值大的第一个数
 * 查找某个数
*/
public class Qunar_list {
	private boolean isIllegal = false;
	public static void main(String[] args){
		Qunar_list test = new Qunar_list();
		List<Integer> list = Arrays.asList();
		test.smaller(4, list);
		test.bigger(5, list);
		test.equal(9, list);
	}
	public void smaller (Integer comp,List<Integer> list){
		if(list.size() == 0 || comp == null || list == null){
			System.out.println("error1");
			return ;
		}
		List<Integer> result = new ArrayList<Integer>();
		for(int t: list){
			if( t < comp)
				result.add(t);			
		}
		if(result.size() != 0){
			for(int t : result)
				System.out.print(t +" ");
		}
		System.out.println();
	}
	
	public void bigger(Integer comp, List<Integer> list){
		if(list.size() == 0 || comp == null || list == null){
			isIllegal = true;
			System.out.println("error2");
			return;
		}
		for(int t:list){
			//找到第一个比参照值大的数就返回
			if(t > comp){
				System.out.println(t);
				return ;	
			}
		}
		return ;
	}
	
	public void equal(Integer comp, List<Integer> list){
		if(list.size() == 0 || comp == null || list == null){
			isIllegal = true;
			System.out.println("error3");
			return ;
		}
		for(int t:list){
			if(t == comp){
				System.out.println(t);
				return ;
			}
		}
		 return ;
	}
}
