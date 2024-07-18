package practice;

import java.util.Scanner;

public class ArrayPractice {

	Scanner sc = new Scanner(System.in);
	
	/* [실습 문제 1]
		길이가 9인 배열을 선언 및 할당하고, 
		1부터 9까지의 값을 반복문을 이용하여
		순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
		짝수 번째 인덱스 값의 합을 출력하세요. 
		(0 번째 인덱스는 짝수로 취급)
	*/
	public void practice1(){
		
		int[] arr = new int[9]; // 배열 선언, 할당

		// 배열 요소 초기화
		for(int i=0 ; i<arr.length ; i++) {
			arr[i] = i + 1;
		}
		
		// 출력 및 합계
		int sum = 0;
		
		for(int i = 0 ; i<arr.length ; i++) {
			System.out.print(arr[i] + " ");
			
			if(i % 2 == 0) { // 짝수번째 인덱스 요소 합
				sum += arr[i];
			}
		}
		
		// \n : 줄바꿈 (개행) 문자
		System.out.println("\n짝수 번째 인덱스 합 : " + sum);
		
	}
	
	public void practice2() {
		
		int[] arr = new int[9]; // 배열 선언, 할당

		// 배열 요소 초기화
		for(int i=0 ; i < arr.length ; i++) {
			arr[i] = arr.length - i;
		}
		
		// 출력 및 합계
		int sum = 0;
		
		for(int i = 0 ;  i< arr.length ; i++) {
			System.out.print(arr[i] + " ");
			
			if(i % 2 == 1) { // 홀수번째 인덱스 요소 합
				sum += arr[i];
			}
		}
		
		// \n : 줄바꿈 (개행) 문자
		System.out.println("\n홀수 번째 인덱스 합 : " + sum);
		
		
		System.out.println("--------------------------");
		
		// 역방향(8 -> 0)
		int[] arr2 = new int[9];
		
		int sum2 = 0;
		
		// arr.length     : 9 9 9 9 9 9 9 9 9
		// i              : 8 7 6 5 4 3 2 1 0
		// arr.length - i : 1 2 3 4 5 6 7 8 9
		// arr[i]         : 1 2 3 4 5 6 7 8 9
		
		// 대입은 역방향
		for(int i = arr2.length - 1 ; i >= 0 ; i--) {
			arr2[i] = arr2.length - i;
			if(i % 2 == 1)  sum2 += arr2[i];
		}
		
		// 출력은 정방향
		for(int num : arr2) {
			System.out.print(num + " ");
		}
		
		System.out.println("\n홀수 번째 인덱스 합 : " + sum2);
	}
	
	
	public void practice3() {
		
		
		System.out.print("양의 정수 :" );
		int i = sc.nextInt();
		
		int[] arr = new int[i];
		
		for(int j=0 ; j<arr.length ; j++) {
			arr[j] = j + 1;
			System.out.print(arr[j] + " ");
		}		
	}
	
	public void practice4() {		 
		int[] arr = new int[5];
		
		for(int i=0 ; i<arr.length ; i++) {
			System.out.printf("입력 %d : ", i);
			arr[i] = sc.nextInt(); // 요소 마다 입력 값 대입
		}
		
	     System.out.print("검색할 값 : ");
	     int search = sc.nextInt();
	        
		// 검색 값이 존재하면 true
		// 없으면 false
	     boolean found = false;
	     
	     for (int i = 0; i < arr.length; i++) {
	    	 
	         if (arr[i] == search) {
	             System.out.printf("인덱스 : %d\n", i);
	             found = true;
	             break;
	         }
	     }
	        
	     if (!found) {
	         System.out.println("일치하는 값이 존재하지 않습니다.");
	     }
	 }
		
	public void practice5() {
		
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		
		int sum = 0;
		
		for(int i=0 ; i<arr.length ; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);			
			arr[i] = sc.nextInt();
			 
			sum += arr[i]; // 합계 누적
		}
			    
		
		// 한 줄 출력
		for(int value : arr) System.out.print(value + " ");
	    
		// 합계 출력
		System.out.println("\n 총 합 : " + sum);		
	}
		
		
	public void practice6() {
		char [] arr = new char[14];
		
		System.out.print("주민등록번호(-포함) : ");
		String str = sc.next();
		
		for(int i = 0 ; i < str.length() ; i++) {
			if( i <= 7) arr[i] = str.charAt(i);
			else        arr[i] = '*';
			
			System.out.print(arr[i]);
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
