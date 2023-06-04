package Notepad.Notepad.src;

import java.util.Scanner;

public class Memo {
    public static void main(String[] args) {
        MemoList list = new MemoList();
        int choice = 0; // 목차의 번호를 입력받는 변수
        while(choice != 5){ // 종료를 입력하기 전까지 계속 반복
            System.out.println("--------------------------------------------");
            System.out.println("1. 입력, 2. 목록 보기, 3. 수정, 4. 삭제, 5. 종료");
            System.out.println("--------------------------------------------");
            do{
                Scanner sc = new Scanner(System.in);
                choice = Integer.valueOf(sc.nextLine());
            } while(!(1<=choice && choice<8));

            switch(choice){
                case 1 : list.Insert(); break;
                case 2 : list.View(); break;
                case 3 : list.Update(); break;
//                case 4 : list.Delete(); break;
            }
        }   // 5가 입력되었을 때 종료
        System.out.println("---------");
        System.out.println("종료합니다.");
        System.out.println("---------");
    }
}
