package kr.or.ddit.basic;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;

public class ComboGugudanController implements Initializable{				//FX화면 단의 기능을 모두 여기서 구현한다.

	@FXML
	private ComboBox<Integer> cmbDan;			//fxml에 있는 id에 있는 값에 있는 정보를 객체화 시켜 멤버변수에 넣어준다.
	@FXML 
	private Button btnDan;						//fxml에 있는 id에 있는 값에 있는 정보를 객체화 시켜 멤버변수에 넣어준다.
	@FXML 
	private TextArea txtResult;					//fxml에 있는 id에 있는 값에 있는 정보를 객체화 시켜 멤버변수에 넣어준다.  ※ 아이디 Mapping 주의 
	
	public static void main(String[] args) {
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {		//컨트롤러의 초기화 작업을 할때 사용
		
	/* 콤보박스 */
		ObservableList<Integer> list = FXCollections.observableArrayList(	//기능 및 정보 입력
				1,2,3,4,5,6,7,8,9
			);
		cmbDan.setItems(list);
		
		
//	/* 버튼 */
//		btnDan.setOnAction(e->{		
//			int dan = cmbDan.getSelectionModel().getSelectedItem();
//			
//	/*텍스트*/	
//			txtResult.setText(dan + "단\n\n");								//덮어 씌우기
//			for(int i=1; i<=9; i++) {
//				int r =dan * i;
//				txtResult.appendText(dan + " * " + i + " = " + r + "\n");   //바로 밑에 추가 하기 
//			}
//		});
	}
	@FXML
	public void btnDanClicked(ActionEvent event) {							//이벤트 핸들러
		
		/* 버튼 */
			int dan = cmbDan.getSelectionModel().getSelectedItem();
			
	/*텍스트*/	
			txtResult.setText(dan + "단\n\n");								//덮어 씌우기
			for(int i=1; i<=9; i++) {
				int r =dan * i;
				txtResult.appendText(dan + " * " + i + " = " + r + "\n");   //바로 밑에 추가 하기 
			}
		
	}
	

}
