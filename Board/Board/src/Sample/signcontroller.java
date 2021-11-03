package Sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class signcontroller implements Initializable {
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
	}
	
	@FXML
    private Label btnback;

    @FXML
    private Button btnsignup;

    @FXML
    private Label lblconfirm;

    @FXML
    private AnchorPane signuppane;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtname;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private PasswordField txtpasswordconfirm;

    @FXML
    void back(MouseEvent event) {
    	logincontroller.getinstance().loadpage("login");
    }

    @FXML
    void signup(ActionEvent event) {
    	
    	if(txtid.getText().length() < 4  || txtid.getText().length() > 13) {
    		lblconfirm.setText("ID�� 4~12���ڸ� ����");
    		return;
    	}
    	if(txtpassword.getText().length() < 4  || txtpassword.getText().length() > 9) {
    		lblconfirm.setText("PW�� 4~8���ڸ� ����");
    		return;
    	}
    	if(!txtpassword.getText().equals(txtpasswordconfirm.getText())) {
    		lblconfirm.setText("PW�� �������� ����");
    		return;
    	}
    	if(txtname.getText().length() < 2) {
    		lblconfirm.setText("�̸��� 2�����̻� ����");
    		return;	
    	}
    	if(txtemail.getText().length() <5 && !txtemail.getText().contains("@") ) {
    		lblconfirm.setText("Email���ĸ� ����");
    		return;
    	}
    	boolean idcheck = memberdao.getmemberdao().idcheck(txtid.getText());
    	if(idcheck) { 
    		lblconfirm.setText("���������� ID");
    		return;
    	}
    	
    	
    	
    	member member = new member(txtid.getText(),txtpassword.getText(),txtname.getText(),txtemail.getText());
    	boolean result = memberdao.getmemberdao().signup(member);
    	
    	if(result) {
			lblconfirm.setText("�������ּż� �����մϴ�.");
			Alert alert = new Alert(AlertType.INFORMATION); 
			alert.setContentText("ȸ������ �Ϸ� [Point 1500 ����]"); 
			alert.setHeaderText("ȸ������ ����"); 
			alert.setTitle("�˸�");
			alert.showAndWait(); 
			logincontroller.getinstance().loadpage("login");
    	} else {
    		lblconfirm.setText("ȸ������ ����");
    	}
    }
	
	
}
