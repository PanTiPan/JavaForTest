package data0415;

import java.util.Scanner;
import java.util.TreeSet;

public class Test10 {

	public static void main(String[] args) {
		TreeSet<Integer> tre = new TreeSet<Integer>();
		int order = 1;
		System.out.print("請輸入10次數字：");
		while (order < 11) {
			Scanner scn = new Scanner(System.in);
			int inner = scn.nextInt();
			if (tre.add(inner)) {
				order++;
			} else {
				System.out.println("輸入數字重複啦");
			}
		}
		// 以上為輸入10個數字，然後會從小排到大，因為TreeSet的特性
		// int num;
		// while(order< 11){
		// num=((int)(Math.random()*100))+1;
		// if(tre.add(num)){
		// order++;
		// }else{
		//
		// }
		// }
		// 以上是隨機產生出10個數字，也是從小排到大
		System.out.println("10個數字從小排到大分別為:" + tre);
		System.out.println("最小值為:" + tre.first());
		System.out.println("最大值為:" + tre.last());
	}

}
