import java.text.SimpleDateFormat;
import java.util.Date;

public class Memo {

    private int memoNum;
    private String userName;
    private String password;
    private String post;//게시글
    private long postTime;

    int counter=1;
    public Memo( String userName, String password, String post,long postTime){
        this.memoNum = counter;
        counter++;
        this.userName = userName;
        this.password = password;
        this.post = post;
        this.postTime = System.currentTimeMillis();
    }
    public String geteditTime(){//시간 값 가져오기
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String result = timeFormat.format(new Date(postTime));
        return result;
    }

    public String getUserName(){
        return userName;
    }
    public String getPost(){
        return post;
    }
    public boolean  updateConfirm(String password){
        if (this.password.equals(password)){
//            System.out.println("수정할 내용을 작성하세요.");
            return true;
        }
        else{
//            System.out.println("비밀번호가 틀립니다.");\
        }
        return false;
    }
    public void update(String editpost){
        this.post = editpost;
        this.postTime = System.currentTimeMillis();
    }

}
