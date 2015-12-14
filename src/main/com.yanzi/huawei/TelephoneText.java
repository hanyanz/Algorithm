package com.yanzi.huawei;
/*描述:实现一个简易电话号码本的程序，存储电话号码，可以通过名字获取电话号码，同时也可以通过
电话号码获取对应的名字。
	1. 名字由英文字母组成，区分大小写。1<=字母数量<=20
	2. 名字和电话号码一一对应
	3. 名字和电话号码均唯一
	4. 电话号码长度n,由数字组成。1<= n <=20
	5. 电话号码本中最大的记录条数为200
输出:
	1. 若输入不符合要求（如：名字中含有非英文字母，或其他认为错误的输入）均需输
	出”error”。
	2. 每条输出后使用换行符隔开(见后面样例)。
	输出要求：
	1. 保存电话号码本，保存成功后要求回显。例如输入”save tom 13888888888”，则输出
	为”tom 13888888888”。同时保存对应的名字和电话号码。如名字或电话号码存在，
	则输出”error”。如存储超过大小限制则输出”error”。
	2. 通过电话号码获取名字。例如输入”getName 13888888888”则输出为”tom”。如无对
	应的电话号码，则输出”error”
	3. 通过名字获取电话号码。例如输入”getPhoneNum tom”,则输出为”13888888888”。
	如无对应的名字，则输出”error”
	4. 删除对应的存储记录。例如当前存储的记录为”tom 13888888888”,输入”delete
	tom”，则输出”ok”。输入”delete jack”，则输出”error”。
	5. 获取电话号码本存储的总人数。例如当前存储两个电话号码。输入”count”，则输出
	为”2”
	6. 清除电话本。电话号码本记录清除，无需输出。
 * */

/*1.如果用的是JDK1.7的话，可以直接switch String 类；
 * 2.save时，判断输入合法，可单独写成一种方法，这样可以增加代码可读性
 * */
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class TelephoneText {
	
	
	public static void main(String[] args){
		Set<Person> text = new HashSet<Person>();
		int count = 0;
		Scanner fin = new Scanner(System.in);
		while(fin.hasNextLine()){
			String[] temp = fin.nextLine().split(" ");
			if(temp[0].equals("save")){	  
				//if name or phoneNum exists
			    if(text.contains(temp[1])||(text.contains(temp[2]))){
					System.out.println("error");
					}
				else if(temp[1].length() > 20 || temp[1].length() < 0 ||temp[2].length() >20 ||temp[2].length() < 0){
					System.out.println("error");
				}
				else{
					for(int i = 0; i < temp[1].length(); i++){
						  if(!((temp[1].charAt(i)>='a'&& temp[1].charAt(i) <= 'z') || (temp[1].charAt(i)>='A'&& temp[1].charAt(i) <= 'Z'))){
						     System.out.println("error");
							  return;}
					  }
					for(int i = 0; i < temp[2].length(); i++){
						  if(!((temp[2].charAt(i)>='0'&& temp[2].charAt(i) <= '9'))){
							  System.out.println("error");
						      return;}
					  }
					Person person = new Person(temp[1],temp[2]);
					text.add(person);
					count++;
					System.out.println(person.name +" "+ person.phoneNum);
				}
			}
			else if(temp[0].equals("count")){
				System.out.println(count);
			}
			else if(temp[0].equals("getName")){
				int i = 1;
				for(Person ss:text){
					if (ss.phoneNum.equals(temp[1])){
						System.out.println(ss.name);
						break;
					}
					i++;
				}
				if(i > text.size()){
					System.out.println("error");
				}
				
			}
			else if(temp[0].equals("getphoneNum")){
				int i = 1;
				for(Person ss:text){
					if (ss.name.equals(temp[1])){
						System.out.println(ss.phoneNum);
						break;
					}
					i++;
				}
				if(i > text.size()){
					System.out.println("error");
				}
			}
			else if(temp[0].equals("delete")){
				int i = 0;
				if(text.size() == 0)
					System.out.println("error");
				else{
					for(Person ss:text){
						if (ss.name.equals(temp[1])){
							text.remove(ss);
							count--;
							System.out.println("OK");
							break;
						}
						i++;
					}
					if(i > text.size()){
						System.out.println("error");
					}
				}
			}
			else if(temp[0].equals("clear")){
				count = 0;
				text.clear();
			}
			
			else
					break;
			}
		}
	
	  
	
	 static class  Person{
		private String name ;
		private String phoneNum;
		public Person(String name,String phoneNum){
			this.name =  name;
			this.phoneNum = phoneNum;		
		}
		
	}
	

}
