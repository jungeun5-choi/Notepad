package Notepad;


import java.util.LinkedList;

public class MemoList {
    public static void main(String[] args) {

    }

    LinkedList<MemoVO> memoList = new LinkedList<>();  //  여러건의 메모를 나타내는

    public MemoVO getMemo(int i) {
        return memoList.get(i); // LinkedList 에서 번호를 받고 글1건 리턴
    }

    public LinkedList<MemoVO> getMemoList() {
        return memoList;
    }

    public void setMemoList(LinkedList<MemoVO> memoList) {
        this.memoList = memoList;
    }

    public void Savememo(MemoVO m) {
        this.memoList.add(m); // 메모 저장


    }

    public String memonumber() {
        if (memoList.size() != 0) {
            for (int i = 0; i < memoList.size() - 1; i--) {

            }
        }


    }
}












