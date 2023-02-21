package ex001;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
	
		Student st1 = new Student("남윤도", "16");
		Student st2 = new Student("사랑한다", "17");
		Student st3 = new Student("님내꺼임", "17");
		
		ArrayList <Student>list = new ArrayList<Student>();
		
		list.add(st1);
		list.add(st2);
		list.add(st3);

		// for(변수 임의의 변수 :참조변수)
		for(Student stu :list) {
			
			System.out.println(stu.getName());
			System.out.println(stu.getNo());
			System.out.println(); // ctrl+space바
			System.out.println(); // ctrl+space바
		}
		
		Scanner sc = new Scanner(System.in);
		
	
		while(true) {
			System.out.println("계속 검색하고 싶으시면 y, 종료하고 싶으시면 n을 입력해주세요");
			String input = sc.next();
			
			if(input.equals("y")) {
				System.out.println("검색을 시작합니다.");
				String name = sc.next();
				boolean flag = false; // 학생이름이 없는 경우를 출력하기 위해
				
				for(Student stu: list) {
					if(stu.getName().equals(name)) {
						System.out.println("해당하는 학생의 학번은 "+stu.getNo());
						flag = true; // 한번이라도 있었다면 true 출력.
						
					}
				}
				if(!flag) { //한번이라도 flag가 실행이 안됐으면
					System.out.println("해당하는 학생이름이 없습니다.");
				}
			}
				
			if(input.equals("y")) {
				System.out.println("검색을 시작합니다");
		
		} else if(input.equals("n")) {
			break;
			}
	}	
		System.out.println("프로그램을 종료합니다.");
	}
}

