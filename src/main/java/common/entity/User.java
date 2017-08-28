package common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	String Login = null;
	@Column(nullable=false)
	String Password = null;

	public int get_Id(){
	     return id;
	}
	public void set_Id(int id){
	this.id = id;
	}
	public String getLogin(){     
	return Login;
	}
	public void setLogin(String Login){
	     this.Login = Login;
	}
	public String getPassword(){
	     return Password;
	}
	public void setPassword(String Password){
	     this.Password = Password;
	}
     
}
