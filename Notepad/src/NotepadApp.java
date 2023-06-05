package Notepad.src;

import java.util.*;

public class NotepadApp {

    /* 필드 */
    Scanner sc;

    MemoVO memoVO;
    MemoList memoList;

    ScreenPrint screenPrint;

    /* 생성자 */
    public NotepadApp(Scanner sc, MemoVO memoVo, MemoList memoList, ScreenPrint screenPrint) {

        this.sc = sc;

        this.memoVO = memoVo;
        this.memoList = memoList;

        this.screenPrint = screenPrint;
    }

    /* 메서드 */

    // 0. 최조 진입점
    public void startNotepadApp() {
        // processNotepadApp();

        // 출력
        screenPrint.pWelcomeMsg();
        screenPrint.pMenu();

        // 입력
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

   public String enterMemoInput() {

       ArrayList<String> textList = new ArrayList<>();
       StringBuilder text = new StringBuilder();

       while (sc.hasNextLine()) {
           String word = sc.nextLine();
           if (word.isEmpty()) {
               break;
           }
           textList.add(word);
       }

       for (String item : textList) {
           text.append(item).append("\n");
       }

       // StringBuilder -> String 변환
       return text.toString();
   }

    // 1-2-2. yes or no 선택/입력
    private int yesOrNoInput() {

        return sc.nextInt();
    }


    // 1-4-1. 수정할 글 선택/입력
    private int selectMemoNumberInput() {
        return sc.nextInt() - 1;
    }
    // 1-4-2. 비밀번호 입력 -> 일치 여부 판별, (4) 삭제에서도 사용
    private String passwordInput(int index) {
        // 비밀번호 입력
        String password = sc.nextLine();

        return password;
    }
    // 1-4-3. 수정할 내용 입력
    private String enterModifyInput() {
        return enterMemoInput();
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

    private void viewMemoList() {
        // 메모 목록 조회
        for(int index = 0; index < memoList.getLength(); index++) {
            System.out.printf("%d. %s", index+1, memoList.getMemo(index));
        }
    }

    // 2. 실행
    // 2-1. 입력(생성) 실행
    private void processCreateMemo() {

        String name, password, memo;

        sc.nextLine();

        // 이름 입력
        screenPrint.pInputName();
        name = enterNameInput();

        // 비밀번호 입력
        screenPrint.pInputPassword();
        password = enterPasswordInput();

        // 메모 입력
        screenPrint.pInputMemo();
        memo = enterMemoInput();


        // Q. "저장하시겠습니까?"
        screenPrint.pSaveYnMsg();
        int save = yesOrNoInput();

        switch (save) {
            case 1: // 1. 저장함
                {
                    // 저장
                    memoList.Insert(name,password, memo);
                    screenPrint.pSavedMsg();

                    // 메뉴로 돌아간다
                    startNotepadApp();
                }
                break;
            case 2: // 2. 저장 안 함
                {
                    // 최초 메뉴로 돌아감
                    startNotepadApp();
                }
                break;
        }
    }

    // 2-2. 목록조회 실행
    private void processViewMemoList() {

        // 메뉴 목록 조회
        viewMemoList();

        System.out.println("메뉴로 되돌아 가시겠습니까?");
        System.out.println("1. 예");

        int selectReturn = yesOrNoInput();

        switch (selectReturn) {
            case 1: // 1. 돌아간다
            {
                // 메인 메뉴
                startNotepadApp();
                break;
            }
        }
    }
    // 2-3. 수정 실행
    private void processModifyMemo() {
        // 메뉴 목록 조회
        viewMemoList();

        // 수정할 글을 선택하세요
        screenPrint.pInputReviseNumber();
        int index = selectMemoNumberInput();
        Boolean correct = false;

        while(!correct) {

            // -> 비밀번호 입력
            screenPrint.pInputPassword();
            String password = passwordInput(index);

            // 비밀번호 판별
            correct = memoList.passwordConfirm(password, index);

            if (correct) { // 1. 비밀번호 일치
                // 1 수정내용 입력
                System.out.println("수정할 내용을 입력하세요.");
                String newMemo = enterModifyInput();

                // 2 업데이트
                memoList.update(newMemo, index);

                // 3 메뉴로 되돌아감
                startNotepadApp();
                break;

            } else { // 2. 비밀번호 불일치
                // 불일치
                screenPrint.pNonPasswordMsg();
            }
        }
    }
    // 2-4. 삭제 실행
    private void processDeleteMemo() {
        // 메뉴 목록 조회
        viewMemoList();

        // 삭제할 글을 선택하세요
        screenPrint.pInputDeleteNumber();
        int index = selectMemoNumberInput();
        Boolean correct = false;

        while(!correct) {
            // -> 비밀번호 입력
            screenPrint.pInputPassword();
            String password = passwordInput(index);

            // 비밀번호 판별
            correct = memoList.passwordConfirm(password, index);

            if (correct) { // 1. 비밀번호 일치
                // 1 삭제
                memoList.deleteMemo(index);

                // 2 메뉴로 되돌아감
                startNotepadApp();
                break;

            } else { // 2. 비밀번호 불일치
                // 불일치
                screenPrint.pNonPasswordMsg();
            }
        }
    }
    // 2-5. 종료 실행
    private void processQuit() {
        System.exit(0);
    }
}