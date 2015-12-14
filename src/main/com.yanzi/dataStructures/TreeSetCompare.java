package com.yanzi.dataStructures;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
/**打印结果不是和先前加入的顺序一样，它是按照一个字母的排序法进行排序的。
 * 这是因为String 类实现了Comparable接口。
如果我们自己定义的一个类的对象要加入到TreeSet当中，
那么这个类必须要实现Comparable接口。
 * */
public class TreeSetCompare {
	
	    public static void main(String[] args) {
	        Set<Teacher> ts = new TreeSet<Teacher>();
	        ts.add(new Teacher("zhangsan", 1));
	        ts.add(new Teacher("lisi", 2));
	        ts.add(new Teacher("wangmazi", 3));
	        ts.add(new Teacher("mazi", 3));
	        Iterator<Teacher> it = ts.iterator();
	        while (it.hasNext()) {
	            System.out.println(it.next());
	        }
	       
	    }
	}


	class Teacher implements Comparable<Object> {
	    int num;
	    String name;

	    Teacher(String name, int num) {
	        this.num = num;
	        this.name = name;
	    }

	    public String toString() {
	        return "学号" + num + "姓名" + name;
	    }

	    public int compareTo(Object o) {
	        Teacher ss = (Teacher) o;
	        int result = (num > ss.num ? 1 : (num == ss.num ? 0 : -1));
	        if (result == 0) {
	            result = name.compareTo(ss.name);
	        }
	        return result;
	    }
	}

