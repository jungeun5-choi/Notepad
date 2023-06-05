package Notepad.Notepad.src;

import java.time.LocalDateTime;
public class MemoVO {
    // VO (Value Object) : 게시글 한 건을 기억할 클래스
    private int idx;    // 메모의 번호
    private String name;    // 메모 이름
    private String password;    // 메모 비밀번호
    private String memo;    // 메모 내용
    private LocalDateTime time; // ISO 8601 형식 > java 8 이후는 LocalDateTime 사용
    public int getIdx(){
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

//    public String getName() {
//        return name;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getMemo() {
//        return memo;
//    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

//    public LocalDateTime getTime() {
//        return time;
//    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    @Override   // 객체를 println으로 출력 -> println은 String.valueOf 메서드를 통해 파라미터로 받은 객체를 문자열로 변환
                // String.valueOf 메서드는 toString()메서드를 호출해 문자열 반환 > 모든 클래스는 Object 클래스를 기본으로 상속받고
                // Object 클래스에 toString 메서드를 가지고 있다.
    public String toString(){
        return idx +". "+name+" / "+password+" / "+memo+" / "+time;
    }
//    @Override
//    public String toString(){
//        return "[ "+idx+" "+name+" "+password+" "+memo+" "+time+" ]";
//    }
}
