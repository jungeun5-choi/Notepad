package Notepad.src;

import java.util.Scanner;

public class NotepadApp {

    /* 필드 */
    Scanner sc;

    MemoList memoList;
    // 입력 (생성)
    // 목록조회
    // 수정
    // 삭제
    // 종료
    // 화면 // ScreenPrint screenPrint;

    /* 생성자 */
    public NotepadApp(Scanner sc, MemoList memoList) {
        this.sc = sc;

        this.memoList = memoList;
        // this.입력 = 입력;
        // this.목록조회 = 목록조회;
        // this.수정 = 수정;
        // this.삭제 = 삭제;
        // this.종료 = 종료;
        // 화면 // this.screenPrint = screenPrint;
    }

    /* 메서드 */

    // 0. 최조 진입점
    public void startNotepadApp() {
        // processNotepadApp();

        // screenPrint().최초화면();
        selectMenuInput();
    }

    // 1. 입력
    // 1-1. 메뉴 선택 입력
    private void selectMenuInput() {

        int menuSelect = sc.nextInt();

        switch (menuSelect) {
            case 1: // 입력(생성)
                processCreateMemo();
                break;
            case 2: // 목록조회
                processViewMemoList();
                break;
            case 3: // 수정
                processModifyMemo();
                break;
            case 4: // 삭제
                processDeleteMemo();
                break;
            case 5: // 종료
                processQuit();
                break;
        }
    }

    // 1-2-1. 이름+비밀번호+메모 입력
    // 이름
    private String enterNameInput() {
        return sc.nextLine();
    }
    // 비밀번호
    private String enterPasswordInput() {
        return sc.nextLine();
    }
    // 메모
    private String enterMemoInput() {
        return sc.nextLine();
    }

    // 1-2-2. 메모 저장 여부 선택/입력
    private Boolean saveOrNotInput() {
        return false;
    }

    // 1-3-1. 메뉴로 되돌아가기
    private void goBackToMenuInput() {

    }

    // 1-4-1. 수정할 글 선택/입력
    private int selectModifyMemoInput() {

        int temp = 0;
        return temp;
    }
    // 1-4-2. 비밀번호 입력 -> 일치 여부 판별, (4) 삭제에서도 사용
    private Boolean passwordInput(int index) {
        // 비밀번호 입력
        String pw = sc.nextLine();

        // 비밀번호 일치여부 판별
        /*
        * if(memoList.get어쩌구(index).getPassword()) {
        *
        * }
        * */

        // 일치하면 true, 불일치면 false
        return false;
    }
    // 1-4-3. 수정할 내용 입력
    private void enterModifyInput() {

    }

    // 1-5-1. 삭제할 글 선택/입력
    private int selectDeleteMemoInput() {
        int temp = 0;
        return temp;
    }
    // 1-5-2. 비밀번호 입력 -> 일치 여부 판별
    // 1-4-2 사용

    // 1-5-3. 삭제 여부 선택/입력
    private Boolean deleteOrNotInput() {
        return false;
    }

    // 2. 실행
    // 2-1. 입력(생성) 실행
    private void processCreateMemo() {

    }
    // 2-2. 목록조회 실행
    private void processViewMemoList() {

    }
    // 2-3. 수정 실행
    private void processModifyMemo() {

    }
    // 2-4. 삭제 실행
    private void processDeleteMemo() {

    }
    // 2-5. 종료 실행
    private void processQuit() {

    }
}