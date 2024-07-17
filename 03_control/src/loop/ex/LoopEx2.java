package loop.ex;

import java.util.Scanner;

public class LoopEx2 {

	// 필드
	Scanner sc = new Scanner(System.in);
	
	/** 다음 모양 출력하기
	 * 1234
	 * 1234
	 * 1234
	 * 
	 */
	public void method1() {		
		for(int i = 1 ; i <=3 ; i++) { // 행 제어(3행 반복)			
			for(int j = 1 ; j <= 4 ; j++) { // 열 제어(4열 반복)				
				System.out.print(j);
			}
			System.out.println(); // 한 행이 끝나면 줄 바꿈
		}
	}
	
	
	
	
	/** 다음 모양 출력하기
	 * 54321
	 * 54321
	 * 54321
	 * 54321
	 */
	public void method2() {
		for(int i = 1 ; i <=4 ; i++) { // 행 제어(4행 반복)
			
			for(int j = 5 ; j >= 1 ; j--) { // 열 제어(5열 반복) 				
				System.out.print(j);
			}
			
			System.out.println(); // 한 행이 끝나면 줄 바꿈
		}
	}
	
	
	
	/**
	 * 행, 열, 정방향(1)/역방향(-1)
	 * 
	 * 행 입력 : 3
	 * 열 입력 : 6
	 * 정방향(1)/역방향(-1) : -1
	 * 
	 * 654321
	 * 654321
	 * 654321
	 */
	public void method3() {
		System.out.println("행 입력 :");
		int row = sc.nextInt();
		
		System.out.println("열 입력 :");
		int col = sc.nextInt();
		
		System.out.println("정방향(1)/역방향(-1) : ");
		int dir = sc.nextInt();
		
		for(int x = 1 ; x <= row ; x++) {
			
		
			if(dir == 1) {
				for(int y = 1 ; y <= col ; y++) {
					System.out.print(y); // 정방향
				}
			} else {
				for(int y = col ; y >= 1 ; y--) {
					System.out.print(y); // 역방향
				}
			}
		
			System.out.println(); // 행 출력 완료 -> 줄바꿈
		}
		
		
		System.out.println("----------------------------------");
		
		// 정방향 초기화
		int start = 1;
		int end = col;
		
		if(dir == -1) { // 역방향
			start = col;
			end = 1;
		}
		
		for(int x = 1 ; x <= row ; x++) {
			
			for(int y = start ;  ; y+= dir ) {
				if(dir == 1 && y <= end) {
					System.out.print(y);
					continue;
				} 
				
				if(dir == -1 && y >= end) {
					System.out.print(y);
					continue;
				}
				
				break;
			}
			
			System.out.println(); // 줄바꿈
		}		
	}
	
	
	/** 다음 모양 출력 하기
	 * 
	 * (0,0) (0,1) (0,2)
	 * (1,0) (1,1) (1,2)
	 * (2,0) (2,1) (2,2)
	 */
	public void method4() {
		System.out.println("행 입력 :");
		int row = sc.nextInt();
		
		System.out.println("열 입력 :");
		int col = sc.nextInt();
		
		for(int i = 0 ; i <= row ; i++) {
			for(int j = 0 ; j <= col ; j++) {
				System.out.printf("(%d,%d)" , i, j );
			}
			System.out.println();
		}		
	}
	
	/** 다음 모양 출력 하기
	 * 
	 * (0,0) 
	 * (1,0) (1,1) 
	 * (2,0) (2,1) (2,2)
	 */
		public void method5() {
		
			for(int row = 0 ; row < 3 ; row++) { // 0~2행(1번칸)
				
				for(int col = 0 ; col <= row ; col++) { // 0~2열(2번칸)
					
					System.out.printf("(%d,%d) ", row, col );
				}
				
				System.out.println(); // 줄 바꿈
			}
		}
		
		
		/** 다음 모양 출력 하기
		 * 
		 * (0,0) (0,1) (0,2)
		 * (1,0) (1,1) 
		 * (2,0) 
		 */
		public void method6() {
			for(int row = 0 ; row < 3 ; row++) { // 0~2행(1번칸)				
				for(int col = 0 ; col < 3 - row ; col++) { // 0~2열(2번칸)
					
					System.out.printf("(%d,%d) ", row, col );
				}
				
				System.out.println(); // 줄 바꿈
			}
		}
		
		/** [do ~  while]
		 * - 최소 1회 이상 반복하는 while문 
		 */
		public void method7() {
			
			int num = 10;			
			do {
				System.out.println("반복 출력");
				
			} while(num < 10);
			
			System.out.println("--- 종료 ---");			
		}
		
		
		/**
		 * 0이 입력될 때 까지 입력된 모든 수의 합
		 */
		public void method8() {
			
			
			int input = 0; // 숫자를 입력 받을 변수
			
			int sum = 0; // 합계
			
			do {
				System.out.print("숫자 입력 : ");
				input = sc.nextInt();
				sum += input;				
			}
			while(input != 0);
			
			System.out.println("합계 : " + sum);
			
		}
		
		
		
		
		
		
}
