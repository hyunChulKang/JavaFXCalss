package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class T13_ListViewTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		ListView<String> list = new ListView<>();
		
		Label label = new Label();
		label.setFont(new Font(20));
		
		//ListView에 들어갈 데이터 구성하기
		ObservableList<String> data = FXCollections.observableArrayList(
					"green", "gold", "red",  "blue", "black",
					"brown", "blueviolet", "pink", "yellow", "chocolate"
				);
		
		list.setItems(data);
		
		
		//ListView에서 값이 선택되었을때 처리
		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(
				ObservableValue<? extends String> observable,
				String oldValue, String newValue) {
			
			label.setText(newValue);
			label.setTextFill(Color.web(newValue));	//글자색변경
		
			}
		});
		
		
		// ListView의 내용은 변경하지 않고 화면에 보이는 부분만 변경하는 방법
		list.setCellFactory(			//Callback 객체만 넣을수있다.!
				new Callback<ListView<String>,
							ListCell<String>>(){
		@Override
		public ListCell<String> call(ListView<String> param){
			
			return new ListCell<String>() {
				protected void updateItem(String item, boolean empty) {		//셀이 처음만들어잘때 updateItem이 생성된다.
					super.updateItem(item, empty);		//item -> 넘어온 값
					
					//변경 되는 데이터가 문자열이면 setText()를 사용함.
					//setText(item);
					
					Rectangle rect = new Rectangle(100, 20);
					if(item != null) { //또는 !empty
						rect.setFill(Color.web(item));// 색칠하기
						//setGraphic(rect); // 값 변경하기
						
						Label lbtxt =new Label(item);
						lbtxt.setTextFill(Color.web(item));
						
						HBox hb2 = new HBox(10);
						
						hb2.getChildren().addAll(rect,lbtxt);
						
						setGraphic(hb2);
					}
				}
			};
		}
		
	});
		VBox vbox = new VBox(10);
		
		vbox.getChildren(). addAll(list, label);
		
		Scene scene =new Scene(vbox);
		
		primaryStage.setTitle("ListView 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
