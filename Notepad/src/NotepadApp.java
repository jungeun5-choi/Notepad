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
                processReviseMemo();
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

    // 메모 입력
    public String enterMemoInput() {

        // 임시 list 생성
        ArrayList<String> textList = new ArrayList<>();
        // 임시 stringBuilder 객체 생성
        StringBuilder text = new StringBuilder();

        // 입력을 계속 받는다
        while (sc.hasNextLine()) {
            String word = sc.nextLine();
            // 아무런 값도 입력받지 않았을 때
            if (word.isEmpty()) {
                break; // 빠져나간다
            }
            // 입력 받은 값은 임시 list에 저장
            textList.add(word);
        }

        // 임시 list에 저장된 텍스트를 stringbuilder 객체로 추가
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


    // 1-4-1. 수정 및 삭제할 글 선택/입력
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

    // 1-5-2. 비밀번호 입력 -> 일치 여부 판별
    // 1-4-2 사용


    // 메모 목록 조회
    private boolean isMemoListEmpty() {
        // 목록이 비어있으면
        if(memoList.getLength() <= 0) {
            // 1 비어있다고 알리고
            screenPrint.pMemoListIsEmpty();
            // 2 메뉴로 돌아간다
            startNotepadApp();
            return true;
        }
        return false;
    }

    // 2. 실행
    // 2-1. 입력(생성) 실행
    private void processCreateMemo() {

        String name, password, memo;
        sc.nextLine(); // 오입력방지버퍼

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

        // 메모 목록 비어있는지 확인
        if (isMemoListEmpty()) return;

        // 메뉴 목록 조회
        screenPrint.viewMemoList();

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
    private void processReviseMemo() {

        // 메모 목록 비어있는지 확인
        if (isMemoListEmpty()) return;

        // 메뉴 목록 조회
        screenPrint.viewMemoList();

        // 수정할 글을 선택하세요
        screenPrint.pInputReviseNumber();
        int index = selectMemoNumberInput();
        // 인덱스를 벗어나면
        if(index > memoList.getLength() - 1) {
            screenPrint.pNonReviseNumberMsg();
            processReviseMemo(); // 재귀
        }

        sc.nextLine(); // 오입력방지버퍼

        Boolean correct = false;

        while(!correct) {

            // -> 비밀번호 입력
            screenPrint.pInputPassword();
            String password = passwordInput(index);

            // 비밀번호 판별
            correct = memoList.passwordConfirm(password, index);

            // 1. 비밀번호 일치
            if (correct) {
                // 1 수정내용 입력
                System.out.println("수정할 내용을 입력하세요.");
                String newMemo = enterModifyInput();

                // 2 업데이트
                memoList.update(newMemo, index);
                screenPrint.pCompleteRevise();

                // 3 메뉴로 되돌아감
                startNotepadApp();
                break;

            // 2. 비밀번호 불일치
            } else {
                // 불일치
                screenPrint.pNonPasswordMsg();
            }
        }
    }


    // 2-4. 삭제 실행
    private void processDeleteMemo() {

        // 0. 메모 목록 비어있는지 확인
        if (isMemoListEmpty()) return;

        // 1. 메뉴 목록 조회
        screenPrint.viewMemoList();

        // 2. 삭제할 글을 선택하세요
        screenPrint.pInputDeleteNumber();
        int index = selectMemoNumberInput();
        // 인덱스를 벗어나면
        if(index > memoList.getLength() - 1) {
            screenPrint.pNonDeleteNumberMsg();
            processDeleteMemo(); // 재귀
        }

        sc.nextLine(); // 오입력방지버퍼

        // 3. 비밀번호 입력 및 판정
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
                screenPrint.pCompleteDelete();

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