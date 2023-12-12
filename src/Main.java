import java.io.InputStreamReader;
import java.util.*;


public class Main {


    //터미널 a~f 선언 / 입력의 끝을 알리기 위한 q$선언
    // 에러 여부 판단위해 error_occur 불린 변수로 판별
    static char ta = 'a';
    static char tb = 'b';
    static char tc='c';
    static char td='d';
    static char te='e';
    static char tf='f';
    static boolean error_occur = false;
    static char q$ = '$';

    static char nextSymbol;


    // 문자열을 자료구조 큐에 담기위한 큐 선언
    static Queue<Character> q = new LinkedList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));

   /*     System.out.println("CFG rules:\n\t1.  S->aA|Bb\n\t2.  A->aBb|bBb|cBb\n\t3.  B->d|e|f");
        System.out.print("input:  ");*/

        // 문자열 입력받고 큐에 넣기
        String input = sc.nextLine();

        for (int i = 0; i < input.length(); i++) {
            q.add(input.charAt(i));
        }

        get_nextSymbol();

        pS();

        // 만약 다음 심볼이 종료심벌이라면
        if (nextSymbol == q$) {
            //에러여부 확인 후 맞는 메시지 출력
            if (error_occur) {
                System.out.println("Failed!");
            } else {
                System.out.println("OK");
            }
        } else{
            // 종료 심벌이 아니라면 남아 있는 문자가 있는데도 토큰으로 분리하지 못한 것이므로 오류메시지 출력
            System.out.println("Failed!");
        }

    }
    // terminal a 처리 함수
    static void pa() {

        if (nextSymbol == ta) {
        //    print(ta);
            get_nextSymbol();
        } else {
            error();
        }
    }

    // terminal b 처리 함수

    static void pb() {

        if (nextSymbol == tb) {
         //   print(tb);
            get_nextSymbol();

        } else {
            error();
        }
    }
    // terminal c 처리 함수
    static void pc() {

        if (nextSymbol == tc) {
        //    print(tc);
            get_nextSymbol();

        } else {
            error();
        }
    }

    // terminal d 처리 함수
    static void pd() {

        if (nextSymbol == td) {
        //    print(td);
            get_nextSymbol();

        } else {
            error();
        }
    }

    // 터미널 e 처리 함수
    static void pe() {

        if (nextSymbol == te) {
        //    print(te);
            get_nextSymbol();

        } else {
            error();
        }
    }
    // terminal f 처리 함수
    static void pf() {

        if (nextSymbol == tf) {
        //    print(tf);
            get_nextSymbol();

        } else {
            error();
        }
    }

    //Symbol S 처리 함수

    static void pS() {
        // 만약 다음 심볼이 a 라면 aA 로
        if (nextSymbol == ta) {
            // nextSymbol 이 터미널 'a'일 Eo
            pa();
            pA();
        // 만약 다음 심볼이 b 라면 bB 로
        }else if(nextSymbol == tb){
            pB();
            pb();
        }
    }

    //논터미널 A 처리함수

    static void pA() {
        //다음 심볼 a라면 aBb로
        if (nextSymbol == ta) {
            pa();
            pB();
            pb();
            // 다음심볼 b라면 bBb 로
        } else if (nextSymbol == tb) {
            pb();
            pB();
            pb();
            //다음심볼 c라면 cBb로
        } else if(nextSymbol==tc) {
            pc();
            pB();
            pb();
            // 그 외는 예외처리
        }else{
            error();
        }
    }

    // 논터미널 B 처리함수
    static void pB() {
        // 만약 다음 심볼 d라면 d로
        if(nextSymbol==td){
            pd();
            // 다음심볼이 e 라면 e로
        }else if(nextSymbol==te){
            pe();
            // 다음 심볼 f 라면 f로
        }else if(nextSymbol==tf){
            pf();
            //  그 외는 예외처리
        }else{
            error();
        }
    }

  //  public static void print(char c) {
  //      System.out.println("char:  " + c);
  //  }


    //에러 표기 함수
    public static void error() {
        error_occur = true;
    }


    //nextSymbol을 큐에서 꺼내옴
    static void get_nextSymbol() {
        // 만약 큐가 비어있다면 다 읽어왔으므로 nextSymbol에 종료문자 넣어주고 리턴
        if(q.isEmpty()) {
            nextSymbol = '$';
            return;
        }
        nextSymbol = q.poll();

    }
}


