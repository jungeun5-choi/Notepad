package Notepad.Notepad.src;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Scanner;

public class MemoList {
    LinkedList<MemoVO> memoList = new LinkedList<>(); // 메모를 저장하는 리스트
    Scanner sc = new Scanner(System.in);
    MemoVO vo = new MemoVO();
    private int count = 1; // 첫번째 메모를 1번으로 표현하기 위한 선언

    public void Insert() {
        LocalDateTime time = LocalDateTime.now();   // ISO 8601 형식의 시스템상의 현재 시간
        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("비밀번호 : ");
        String password = sc.nextLine();
        System.out.print("내용 : ");
        String memo = sc.nextLine();

        MemoVO vo = new MemoVO();
        vo.setIdx(count++); // 번호
        vo.setName(name);   // 이름
        vo.setPassword(password);   // 비밀번호
        vo.setMemo(memo);   // 메모 내용
        vo.setTime(time);   // 현재시간

        memoList.add(vo);
    }

    public void Update() {
        System.out.print("수정할 메모의 번호를 입력하시오 : ");
        int number = new Scanner(System.in).nextInt();

        try{    // Arraylist의 크기보다 높은 값을 입력 했을 때 발생하는 오류에 대한 예외처리
            if (number == memoList.get(number-1).getIdx()) {  // Arraylist의 크기는 0부터 시작하므로 1을 빼준다. 입력한 number가 getIdx로 불러온 값이 같으면 진행
                System.out.print("비밀번호를 입력하시오 : ");
                String password = sc.nextLine();
                if(password.equals(memoList.get(number-1).getPassword())){  // 입력한 pass와 getPassword로 불러온 값이 같으면 진행
                    System.out.print("새로운 메모를 입력하시오 : ");
                    memoList.get(number-1).setMemo(sc.nextLine());
                    memoList.get(number-1).setTime(LocalDateTime.now());
                    System.out.println("수정이 완료되었습니다.");
                } else{                                                 // 입력한 pass와 getPassword로 불러온 값이 다르면 진행
                    System.out.println("비밀번호가 틀렸습니다.");
                }
            }
        } catch(IndexOutOfBoundsException e){   // 예외처리
            System.out.println("없는 번호입니다.");
            Update();   // 재귀함수
        }
    }
    public void View() {    // 목록을 보여주는 메소드
        for (int i = memoList.size() - 1; i >= 0; i--) {
            System.out.println(memoList.get(i));
        }
    }
    public void Delete(){
        System.out.print("삭제할 메모의 번호를 입력하시오 : ");
        int number = sc.nextInt();
        sc.nextLine();  // 입력 버퍼를 지워주는 역할(비밀번호가 바로 틀렸다고 뜸)

        try{    // Arraylist의 크기보다 높은 값을 입력 했을 때 발생하는 오류에 대한 예외처리
            if (number == memoList.get(number-1).getIdx()) {  // Arraylist의 크기는 0부터 시작하므로 1을 빼준다. 입력한 number가 getIdx로 불러온 값이 같으면 진행
                System.out.print("비밀번호를 입력하시오 : ");
                String password = sc.nextLine();
                if(password.equals(memoList.get(number-1).getPassword())){  // 입력한 pass와 getPassword로 불러온 값이 같으면 진행
                    memoList.remove(number-1);
                    System.out.println("삭제가 완료되었습니다.");
                    for(int i = memoList.size()-1;i>=0;i--){
                        memoList.get(i).setIdx(i+1);
                    }
                    count--;
                } else{                                                 // 입력한 pass와 getPassword로 불러온 값이 다르면 진행
                    System.out.println("비밀번호가 틀렸습니다.");
                }
            }
        } catch(IndexOutOfBoundsException e){   // 예외처리
            System.out.println("없는 번호입니다.");
            Delete();   // 재귀함수
        }
    }
}
