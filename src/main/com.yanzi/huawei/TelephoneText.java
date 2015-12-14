package com.yanzi.huawei;
/*����:ʵ��һ�����׵绰���뱾�ĳ��򣬴洢�绰���룬����ͨ�����ֻ�ȡ�绰���룬ͬʱҲ����ͨ��
�绰�����ȡ��Ӧ�����֡�
	1. ������Ӣ����ĸ��ɣ����ִ�Сд��1<=��ĸ����<=20
	2. ���ֺ͵绰����һһ��Ӧ
	3. ���ֺ͵绰�����Ψһ
	4. �绰���볤��n,��������ɡ�1<= n <=20
	5. �绰���뱾�����ļ�¼����Ϊ200
���:
	1. �����벻����Ҫ���磺�����к��з�Ӣ����ĸ����������Ϊ��������룩������
	����error����
	2. ÿ�������ʹ�û��з�����(����������)��
	���Ҫ��
	1. ����绰���뱾������ɹ���Ҫ����ԡ��������롱save tom 13888888888���������
	Ϊ��tom 13888888888����ͬʱ�����Ӧ�����ֺ͵绰���롣�����ֻ�绰������ڣ�
	�������error������洢������С�����������error����
	2. ͨ���绰�����ȡ���֡��������롱getName 13888888888�������Ϊ��tom�������޶�
	Ӧ�ĵ绰���룬�������error��
	3. ͨ�����ֻ�ȡ�绰���롣�������롱getPhoneNum tom��,�����Ϊ��13888888888����
	���޶�Ӧ�����֣��������error��
	4. ɾ����Ӧ�Ĵ洢��¼�����統ǰ�洢�ļ�¼Ϊ��tom 13888888888��,���롱delete
	tom�����������ok�������롱delete jack�����������error����
	5. ��ȡ�绰���뱾�洢�������������統ǰ�洢�����绰���롣���롱count���������
	Ϊ��2��
	6. ����绰�����绰���뱾��¼��������������
 * */

/*1.����õ���JDK1.7�Ļ�������ֱ��switch String �ࣻ
 * 2.saveʱ���ж�����Ϸ����ɵ���д��һ�ַ����������������Ӵ���ɶ���
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
