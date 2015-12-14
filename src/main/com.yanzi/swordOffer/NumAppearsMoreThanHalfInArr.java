package com.yanzi.swordOffer;
import java.util.ArrayList;
public class NumAppearsMoreThanHalfInArr {
    boolean isInputInvalid = false;
    boolean isHalf = true;
    public static void main(String [] args)  {
    	NumAppearsMoreThanHalfInArr test = new NumAppearsMoreThanHalfInArr();
    	ArrayList<Integer> arrList = new ArrayList<Integer>();
    	arrList.add(1);
    	arrList.add(1);
    	arrList.add(2);
    	arrList.add(2);
    	arrList.add(2);
    	arrList.add(3);
    	arrList.add(3);
    	arrList.add(3);
    	System.out.println(test.MoreThanHalfNum_Solution(arrList));
    	System.out.println(test.isHalf);
    }
    public int MoreThanHalfNum_Solution(ArrayList<Integer> array) {
        
        if(array == null || array.size() == 0){
            isInputInvalid = true;
            return 0;
        }
        
        int result = array.get(0);
        int count = 1;
        for(int i = 1; i < array.size();i++){
            if(count == 0){
                result = array.get(i);
                count++;
            }
            else if (result == array.get(i)){
                count++;
                
            }
            else{
                count--;
            }           
        }
        if(isMoreThanHalf(array,result) == false){
            result = 0;
            isHalf = false;
         }
        return result;
        
    }
    boolean isMoreThanHalf(ArrayList<Integer> array,int number){
        int count = 0;
        for(Integer ss: array){
            if(ss == number)
                count++;
        }
        if ((count<<1) < array.size())
            return false;
        else
            return true;
    }
}
