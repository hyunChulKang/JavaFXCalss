package kr.or.ddit.basic;

import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class T08_AlertTest extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Alert alertInfomatrion  = new Alert(AlertType.INFORMATION);
		alertInfomatrion.setTitle("INFORMATION");
		alertInfomatrion.setContentText("TNFORMATION창 입니다");
		alertInfomatrion.showAndWait();	//Alert창 보이기
		//========================================================
		Alert alertError =  new Alert(AlertType.ERROR);
		alertError.setTitle("ERROR");
		alertError.setContentText("ERROR Alert창 입니다.");
		alertError.showAndWait();
		//========================================================
		Alert alertWarn = new Alert(AlertType.WARNING);
		alertWarn.setTitle("WARNINg");
		alertWarn.setContentText("WARNING Alert창입니다.");
		alertWarn.showAndWait();
		//========================================================
		Alert alertConfirm = new Alert(AlertType.CONFIRMATION);
		alertConfirm.setTitle("CONFIRMATION");
		alertConfirm.setContentText("CONFIRMATION Alert창 입니다.");
		
		//Alert창을 보여주고 사용자가 누른 버튼 값 잆어오기
		ButtonType confirmResult = alertConfirm.showAndWait().get();
		
		if(confirmResult == ButtonType.OK) {
			System.out.println("OK버튼을 눌렀습니다.");
		}else if (confirmResult == ButtonType.CANCEL) {
			System.out.println("취소버튼을 눌렀습니다.");
		}
		//========================================================
		
		//Javascript의 Prompt창과 같은 기능
		
		TextInputDialog inputDialog = new TextInputDialog("기본값");
		inputDialog.setTitle("Prompt창");
		inputDialog.setHeaderText("TextInputDialog창입니다.");//출력메시지
		
		Optional<String> result  = inputDialog.showAndWait();
		String strResult = null;	//입력한 값이 저장될 변수 선언
		
		//입력한 값이 있는지 검사 (값 입력 후 'OK'버튼을 눌렀는지 검사)
		if(result.isPresent()) {
			strResult = result.get(); //값 읽어 오기
		}
		
		System.out.println("일어온 값: " + strResult);
		
	}
	
	
}
