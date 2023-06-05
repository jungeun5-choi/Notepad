<<<<<<< HEAD
package Notepad.src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 객체 생성
        Scanner sc = new Scanner(System.in);
        MemoList memoList = new MemoList();
        NotepadApp notepadApp = new NotepadApp(sc, memoList);

        // 시작
        notepadApp.startNotepadApp();


//        MemoList list = new MemoList();
//        int choice = 0; // 목차의 번호를 입력받는 변수
//        while(choice != 5){ // 종료를 입력하기 전까지 계속 반복
//            System.out.println("--------------------------------------------");
//            System.out.println("1. 입력, 2. 목록 보기, 3. 수정, 4. 삭제, 5. 종료");
//            System.out.println("--------------------------------------------");
//            do{
//                Scanner sc = new Scanner(System.in);
//                choice = Integer.parseInt(sc.nextLine());
//            } while(!(1<=choice && choice<8));
//
//            switch(choice){
//                case 1 : list.Insert(); break;
//                case 2 : list.View(); break;
//                case 3 : list.Update(); break;
//                case 4 : list.Delete(); break;
//            }
//        }   // 5가 입력되었을 때 종료
//        System.out.println("---------");
//        System.out.println("종료합니다.");
//        System.out.println("---------");
//>>>>>>> insert-jeongmin
    }
}
=======
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//        boolean status = true;
//        String userName;
//        String password;
//        MemoList memoList = new MemoList();
//
//        Scanner sc = new Scanner(System.in);
//
//
//        while (status) {
//            System.out.println("환영합니다.");
//            System.out.println("원하는 기능을 입력해주세요.");
//            System.out.println("1. 메모 작성   2.메모 조회   3.메모 수정   4.메모 삭제 5.종료");
//
//            int response = sc.nextInt();
//            sc.nextLine();
//
//            switch (response) {
//                case 1: {
//                    ArrayList<String> textList = new ArrayList<>();
//                    StringBuilder text = new StringBuilder();
//                    System.out.println("< 메모 작성하기 >");
//                    System.out.print("이름 입력 :");
//                    userName = sc.nextLine();
//
//                    System.out.print("비밀번호 입력 :");
//                    password = sc.nextLine();
//                    System.out.println("메모를 입력하세요.");
//
//                    while (sc.hasNextLine()) {
//                        String word = sc.nextLine();
//                        if (word.isEmpty()) {
//                            break;
//                        }
//                        textList.add(word);
//                    }
//
//
//                    for (String item : textList) {
//                        text.append(item).append("\n");
//                    }
//                    System.out.println("결과 : " + text);
//
//                    MemoVO memo = new MemoVO(userName, password, text);
//                    memoList.insert(memo);
//                    break;
//                }
//                case 2: {
//                    System.out.println("< 메모 조회하기 >");
//                    System.out.println("1. 전체 조회   2. 선택 조회");
//                    response = sc.nextInt();
//                    if (response == 1) {
//                        memoList.getMemoList();
//                    } else if (response == 2) {
//
//                    }
//                    break;
//                }
//                //조우진 구현기능 - 수정하기
//                case 3: {
//                    System.out.println("< 메모 수정하기 >");
//                    System.out.println("수정할 글번호를 입력하세요.");
//                    int postNum = sc.nextInt();
//                    sc.nextLine();
//                    if(memoList.getLength() < postNum) {
//                        System.out.println("존재하지 않는 글번호입니다.");
//                        break;
//                    }
//                    System.out.println("수정할 메모장");
//
//                    MemoVO targetMemo = memoList.getMemoVO(postNum);
//                    targetMemo.getMemo(); //내용 전체 조회
//                    System.out.println("비밀번호를 입력하세요.");
//                    String targetPassword;
//                    targetPassword = sc.nextLine();
//                    if (targetMemo.passwordConfirm(targetPassword)) {
//                        System.out.println("메모를 입력해주세요.");
//                        ArrayList<String> textList = new ArrayList<>();
//                        StringBuilder text = new StringBuilder();
//                        while (sc.hasNextLine()) {
//                            String word = sc.nextLine();
//                            if (word.isEmpty()) {
//                                break;
//                            }
//                            textList.add(word);
//                        }
//                        for (String item : textList) {
//                            text.append(item).append("\n");
//                        }
//                        memoList.update(text, postNum);
//                        System.out.println("수정이 완료되었습니다.");
//
//                    } else System.out.println("비밀번호가 틀립니다.");
//                    break;
//                }
//                case 5:{
//                    status = false;
//                    break;
//                }
//                default:{
//                    break;
//                }
//            }
//
//
//        }
//    }
//}
//>>>>>>> update-woojin
