package Notepad.src;

import java.util.List;
import java.util.Scanner;

public class ScreenPrInt {
    Scanner scanner = new Scanner(System.in);
    public void welcomMsg(){
        System.out.println("안녕하세요");
        System.out.println("Notepad에 오신것을 환영합니다");
    }

    public void saved(){
        System.out.println("이름을 입력하세요");
        String inputName = scanner.next();

        System.out.println("비밀번호를 입력하세요");
        Integer inputPassword = scanner.nextInt();

        System.out.println("메모를 입력하세요");
        String inputMomo = scanner.next();

        System.out.println("저장되었습니다.");
    }

    public void revised(List<Memo> memos){
        System.out.println("수정할 글 번호를 입력해 주세요");
        Integer inputNumber = scanner.nextInt();
        if (inputNumber >= 1 && inputNumber <= memos.size()) {
            System.out.println("비밀번호를 입력해주세요");
            Integer password = scanner.nextInt();
            if (password.equals()) {
            }
            else {
                System.out.println("비밀번호가 일치하지 않습니다.");
                revised(memos);
            }
            System.out.println("수정되었습니다.");
        } else {
            System.out.println("글 번호기 존재하지 않습니다. 다시 입력해 주세요.");
            revised(memos);
        }
    }

    public void delete(List<Memo> memos){
        System.out.println("삭제할 글 번호를 입력해 주세요");
        Integer inputNumber = scanner.nextInt();
        if (inputNumber >= 1 && inputNumber <= memos.size()) {
            //여기 뭐 쓰징
            System.out.println("삭제되었습니다.");
        } else {
            System.out.println("글 번호기 존재하지 않습니다. 다시 입력해 주세요.");
            revised(memos);
        }
    }

}
