package service;

import model.User;

//오라클에 맞게 메소드 파라미터 수정하면 될듯
public interface LoginService {
	
	//회원가입
	public int insertUser(User user);
	
	public void selectAllUser();
	public User selectUser(User user) throws Exception;
}
