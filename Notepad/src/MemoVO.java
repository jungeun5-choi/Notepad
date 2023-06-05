import java.text.SimpleDateFormat;
import java.util.Date;

public class MemoVO {

    private int memoNum;    //글번호. 자동 증가
    private String userName;//이름
    private String password;//비밀번호
    private StringBuilder text;     //게시글
    private long postTime; //작성일, 자동 입력

    static int counter=1;
    public MemoVO(String userName, String password, StringBuilder text){
        this.memoNum = counter;
        counter++;
        this.userName = userName;
        this.password = password;
        this.text = text;
        this.postTime = System.currentTimeMillis();
    }
    public int getMemoNum(){
        return memoNum;
    }
    public String getTime(){//시간 값을 yyyy-mm-dd hh:mm:ss 형태로 변환하여 가져오기
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return timeFormat.format(new Date(postTime));
    }

    public void setPostTime() {//시간값 다시저장
        this.postTime = System.currentTimeMillis();
    }
    public String getUserName(){
        return userName;
    }
    public StringBuilder getText(){
        return text;
    }
    public boolean passwordConfirm(String password){
        if (this.password.equals(password)){
//            System.out.println("수정할 내용을 작성하세요.");
//            setpostTime();
//            setPost("내용");
            return true;
        }
        else{
//            System.out.println("비밀번호가 틀립니다.");\
        }
        return false;
    }
    public void setText(StringBuilder editText){
        this.text = editText;
    }

    public void getMemo(){
        System.out.println("글번호 :" + this.getMemoNum());
        System.out.println("작성자 :" + this.getUserName());
        System.out.println("작성시간 :"+this.getTime());
        System.out.print("작성 내용 :\n" +this.getText());
    }


}
