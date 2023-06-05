import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class MemoList {
    private LinkedList<MemoVO> memoList = new LinkedList<MemoVO>();

    public void getMemoList(){//메모 전체 조회
        for(MemoVO memo : memoList){
            System.out.println("----------");
            memo.getMemo();
            System.out.println("----------\n");
        }
    }

    public int getLength(){
        return memoList.size();
    }


    public void insert(MemoVO memoVO){
        memoList.add(memoVO);
    }


    //조우진 - 수정하기

    public MemoVO getMemoVO(int number){
        return memoList.get(number-1);
    }
    public void update(StringBuilder editText,int number) {
        getMemoVO(number).setText(editText);
        getMemoVO(number).setPostTime();
    }
    public void delete(MemoVO memoVO) {

    }
}
