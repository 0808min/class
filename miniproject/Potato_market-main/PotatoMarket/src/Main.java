import potato.process.MainProcess;

/**
 * 최초 실행되는 부분
 * 처리 해야할 것 -> config 파일 불러오기, session 데이터 불러와서 자동 로그인 단계로 넘기기
 */
public class Main {
	
	public static void main(String[] args) {
		MainProcess.getInstance().initialize();
		
		MainProcess.getInstance().loginProcess();

		MainProcess.getInstance().mainProcess();
		
		MainProcess.getInstance().endpointProcess();
	}
}
