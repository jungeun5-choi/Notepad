package Notepad.src;

import java.time.LocalDateTime;
import java.util.*;
import java.util.Scanner;

public class MemoList {
    LinkedList<MemoVO> memoList = new LinkedList<>(); // 메모를 저장하는 리스트
    Scanner sc;
    // MemoVO vo = new MemoVO();

    LocalDateTime time;
    MemoVO vo;

    MemoList(MemoVO memoVO) {

        time = LocalDateTime.now();   // ISO 8601 형식의 시스템상의 현재 시간
        this.vo = memoVO;
    }


    private int count = 1; // 첫번째 메모를 1번으로 표현하기 위한 선언


    public void Insert(String name, String password, String memo) {

        /*
        //System.out.print("이름 : ");
        //String name = sc.nextLine();
        //System.out.print("비밀번호 : ");
        //String password = sc.nextLine();
        //System.out.print("내용 : ");
        //String memo = sc.nextLine();

        // MemoVO vo = new MemoVO();
        */

        MemoVO vo = new MemoVO(name, password, memo, time);

        // vo.setIdx(count++); // 번호
        // vo.setName(name);   // 이름
        // vo.setPassword(password);   // 비밀번호
        // vo.setMemo(memo);   // 메모 내용
        // vo.setTime(time);   // 현재시간

        memoList.add(vo);
    }

//    public void Update() {
//        System.out.print("수정할 메모의 번호를 입력하시오 : ");
//        int number = sc.nextInt();
//
//        try {    // linkedlist의 크기보다 높은 값을 입력 했을 때 발생하는 오류에 대한 예외처리
//            if (number == memoList.get(number - 1).getIdx()) {  // linkedlist의 크기는 0부터 시작하므로 1을 빼준다. 입력한 number가 getIdx로 불러온 값이 같으면 진행
//                if (passwordInput(number)) {
//                    System.out.print("새로운 메모를 입력하시오 : ");
//                    memoList.get(number - 1).setMemo(sc.nextLine());
//                    memoList.get(number - 1).setTime(LocalDateTime.now());
//                    System.out.println("수정이 완료되었습니다.");
//                } else {                                                 // 입력한 pass와 getPassword로 불러온 값이 다르면 진행
//                    System.out.println("비밀번호가 틀렸습니다.");
//                }
//            }
//        } catch (IndexOutOfBoundsException e) {   // 예외처리
//            System.out.println("없는 번호입니다.");
//            Update();   // 재귀함수
//        }
//    }

    public void View() {    // 목록을 보여주는 메소드
        for (int i = memoList.size() - 1; i >= 0; i--) {
            System.out.println(memoList.get(i));
        }
    }

    public void deleteMemo(int index) {

        // linkedlist의 크기보다 높은 값을 입력 했을 때 발생하는 오류에 대한 예외처리
        try {
            if(index < memoList.size()) {
                memoList.remove(index);
            }

        } catch (IndexOutOfBoundsException e) {   // 예외처리
            System.out.println("없는 번호입니다.");
            deleteMemo(index); // 재귀함수
        }
    }

    /*
    public void Delete() {
        System.out.print("삭제할 메모의 번호를 입력하시오 : ");
        int number = sc.nextInt();

        try {    // linkedlist의 크기보다 높은 값을 입력 했을 때 발생하는 오류에 대한 예외처리
            if (number == memoList.get(number - 1).getIdx()) {  // linkedlist의 크기는 0부터 시작하므로 1을 빼준다. 입력한 number가 getIdx로 불러온 값이 같으면 진행
                if (passwordInput(number)) {
                    memoList.remove(number - 1);
                    System.out.println("삭제가 완료되었습니다.");
                    for (int i = memoList.size() - 1; i >= 0; i--) {
                        memoList.get(i).setIdx(i + 1);
                    }
                    count--;    // 글이 삭제된 후 새 글이 입력될 때 idx가 기존 idx값에 이어서 1씩 증가할 수 있도록
                } else {
                    System.out.println("비밀번호가 틀렸습니다.");
                }
            }
        } catch (IndexOutOfBoundsException e) {   // 예외처리
            System.out.println("없는 번호입니다.");
            Delete();   // 재귀함수
        }
    }
    */

    public boolean passwordConfirm(String password, int index){

        if (password.equals(memoList.get(index).getPassword())){
            return true;
        }
        return false;
    }

    private Boolean passwordInput(int index) {
        System.out.print("비밀번호를 입력하시오 : ");
        String pw = sc.nextLine();
        sc.nextLine(); // 입력버퍼를 지워주는 역할
        return pw.equals(memoList.get(index - 1).getPassword());
    }

    // private int selectDeleteMemoInput(){
    //     System.out.print("삭제할 메모의 번호를 입력하시오 : ");
    //     int temp = sc.nextInt();
    // }


    //조우진 - 수정하기
    public int getLength() {
        return memoList.size();
    }

    public MemoVO getMemoVO(int number) {
        return memoList.get(number);
    }

    public void update(String editText, int number) {
        getMemoVO(number).setMemo(editText);
        getMemoVO(number).setTime(LocalDateTime.now());
    }
    public void update(StringBuilder editText, int number) {
        getMemoVO(number).setText(editText);
        getMemoVO(number).setTime(LocalDateTime.now());
        //getMemoVO(number).setPostTime();
    }

    // 조회
    public MemoVO getMemo(int i) {
        return memoList.get(i); // LinkedList 에서 번호를 받고 글1건 리턴
    }
    public LinkedList<MemoVO> getMemoList() {
        return memoList;
    }
    public void setMemoList(LinkedList<MemoVO> memoList) {
        this.memoList = memoList;
    }


//package Notepad;
//
//
//import java.util.LinkedList;
//
//public class MemoList {
//    public static void main(String[] args) {
//
//    }
//
//    LinkedList<MemoVO> memoList = new LinkedList<>();  //  여러건의 메모를 나타내는
//
//    public MemoVO getMemo(int i) {
//        return memoList.get(i); // LinkedList 에서 번호를 받고 글1건 리턴
//    }
//
//    public LinkedList<MemoVO> getMemoList() {
//        return memoList;
//    }
//
//    public void setMemoList(LinkedList<MemoVO> memoList) {
//        this.memoList = memoList;
//    }
//
//    public void Savememo(MemoVO m) {
//        this.memoList.add(m); // 메모 저장
//
//
//    }
//
//    public String memonumber() {
//        if (memoList.size() != 0) {
//            for (int i = 0; i < memoList.size() - 1; i--) {
//
//            }
//        }
//
//
//    } 서연님

}