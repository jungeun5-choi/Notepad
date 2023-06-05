package Notepad.src;

import java.util.List;
import java.util.Scanner;

public class ScreenPrInt {
    Scanner scanner = new Scanner(System.in);
    public void pWelcomeMsg(){
        System.out.println("안녕하세요");
        System.out.println("Notepad에 오신것을 환영합니다");
    }
    public void pEndMsg(){
        System.out.println("Notepad가 종료되었습니다.");
        System.out.println("이용해주셔서 감사합니다.");
    }
    public void pSavedMsg(){
        System.out.println("저장되었습니다.");
    }
    public void pSevisedMsg(){
        System.out.println("수정되었습니다");
    }
    public void pDeltedMsg(){
        System.out.println("삭제되었습니다.");
    }
    public void pInputMemo() {
        System.out.println("이름을 입력하세요");
        String inputName = scanner.next();

        System.out.println("비밀번호를 입력하세요");
        Integer inputPassword = scanner.nextInt();

        System.out.println("메모를 입력하세요");
        String inputMomo = scanner.next();
    }
    public void pInputPassword(){
        System.out.println("비밀번호를 입력해 주세요");
        Integer inputPassword = scanner.nextInt();
    }

    public void pNonPasswordMsg(){
        System.out.println("비밀번호가 일치하지 않습니다.");
    }
    public void pInputReviseNumber(){
        System.out.println("수정할 글 번호를 입력해 주세요");
        Integer inputReviseNumber = scanner.nextInt();
    }
    public void pNonNumberMsg(){
        System.out.println("수정할 글 번호가 존재하지 않습니다.");
    }
    public void pReviseYnMsg(){
        System.out.println("수정하시겠습니까?");
        System.out.println("1.예");
        System.out.println("2.아니요");
    }




//    public void revised(List<Memo> memos){
//        System.out.println("수정할 글 번호를 입력해 주세요");
//        Integer inputNumber = scanner.nextInt();
//        if (inputNumber >= 1 && inputNumber <= memos.size()) {
//            System.out.println("비밀번호를 입력해주세요");
//            Integer password = scanner.nextInt();
//            if (password.equals()) {
//            }
//            else {
//                System.out.println("비밀번호가 일치하지 않습니다.");
//                revised(memos);
//            }
//            System.out.println("수정되었습니다.");
//        } else {
//            System.out.println("글 번호기 존재하지 않습니다. 다시 입력해 주세요.");
//            revised(memos);
//        }
//    }
//
//    public void delete(List<Memo> memos){
//        System.out.println("삭제할 글 번호를 입력해 주세요");
//        Integer inputNumber = scanner.nextInt();
//        if (inputNumber >= 1 && inputNumber <= memos.size()) {
//            //여기 뭐 쓰징
//            System.out.println("삭제되었습니다.");
//        } else {
//            System.out.println("글 번호기 존재하지 않습니다. 다시 입력해 주세요.");
//            revised(memos);
//        }
//    }

}
