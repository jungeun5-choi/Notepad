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
    }
}
