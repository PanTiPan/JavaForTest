package data0415;

import java.util.Scanner;
import java.util.TreeSet;

public class Test10 {

	public static void main(String[] args) {
		TreeSet<Integer> tre = new TreeSet<Integer>();
		int order = 1;
		System.out.print("�п�J10���Ʀr�G");
		while (order < 11) {
			Scanner scn = new Scanner(System.in);
			int inner = scn.nextInt();
			if (tre.add(inner)) {
				order++;
			} else {
				System.out.println("��J�Ʀr���ư�");
			}
		}
		// �H�W����J10�ӼƦr�A�M��|�q�p�ƨ�j�A�]��TreeSet���S��
		// int num;
		// while(order< 11){
		// num=((int)(Math.random()*100))+1;
		// if(tre.add(num)){
		// order++;
		// }else{
		//
		// }
		// }
		// �H�W�O�H�����ͥX10�ӼƦr�A�]�O�q�p�ƨ�j
		System.out.println("10�ӼƦr�q�p�ƨ�j���O��:" + tre);
		System.out.println("�̤p�Ȭ�:" + tre.first());
		System.out.println("�̤j�Ȭ�:" + tre.last());
	}

}
