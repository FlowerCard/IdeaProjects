package test01;

public class Test01 {
	
	public static void main(String[] args) {
		Person person = new Person();
		person.age = 20;
		person.showAge();
		person.study();
		person.addAge();
		person.showAge();
		
		System.out.println("------------------------------------------------------");
		
		ArraysSort arrs = new ArraysSort();
		int[] arrs01 = new int[20];
		int[] arrs02 = new int[20];
		int max01 = 0;
		int max02 = 0;
		int min01 = 0;
		int min02 = 0;
		int[] sort01 = null;
		int[] sort02 = null;
		double avg = 0.0;
		boolean flag01 = false;
		boolean flag02 = false;
		
		for (int i = 0; i < 20; i++) {
			arrs01[i] = (int)(Math.random()*20+1);
			arrs02[i] = (int)(Math.random()*100+1);
		}
		
		//�������ֵ
		max01 = arrs.maxArrays(arrs01);
		max02 = arrs.maxArrays(arrs02);
		System.out.println(max01);
		System.out.println(max02);
		
		//������Сֵ
		min01 = arrs.minArrays(arrs01);
		min02 = arrs.minArrays(arrs02);
		System.out.println(min01);
		System.out.println(min02);
		
		//������������
		sort01 = arrs.sortArrays(arrs01);
		sort02 = arrs.sortArrays(arrs02);
		System.out.println(sort01);
		System.out.println(sort02);
		
		//���������飬��ƽ��ֵ
		avg = arrs.avgArrays(arrs01, arrs02);
		System.out.println(avg);
		
		//�������Ƿ���9
		flag01 = arrs.haveArrays(arrs01);
		flag02 = arrs.haveArrays(arrs02);
		if (flag01) {
			System.out.println("��������9");
		}else {
			System.out.println("������û��9"); 
		}
		
		if (flag02) {
			System.out.println("��������9");
		}else {
			System.out.println("������û��9"); 
		}
		
		
	}

}
