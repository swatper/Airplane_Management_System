package cse.airplane_management_system.LoginSystem;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 박상현
 */
class UserDB implements ObjectDB {

    private ArrayList<User> userDBList;
    private int dbSize;         //DB의 크기
    
    //생성자
    public UserDB() {
        userDBList = new ArrayList<>();
    }

    //User객체 추가
    public void AddUser(User Users) {
        userDBList.add(Users);
    }

    //객체를 찾는 횟수??
    public int GetDBSize() {
        this.dbSize = userDBList.size();
        return this.dbSize;
    }

    //DB에 있는 객체 찾아서 전달
    public User GetUser(int Index) {
        User TargetUser = userDBList.get(Index);
        return TargetUser;
    }

    public ArrayList<User> GetUserDB() {
        return userDBList;
    }

    //UserDB안에 User객체를 돌아다닐 Iterator 생성
    @Override
    public Iterator CreatIterator() {
        return new UserDBIterator(this);
    }
    
    // UserDB에서 User 객체 삭제
    public void DeleteUser(int index) {
    userDBList.remove(index);
    dbSize--; // 데이터베이스 크기 감소
}

    // UserDB에서 User 객체 수정
    public void UpdateUser(int index, User updatedUser) {
        userDBList.set(index, updatedUser);
    }
    
    
}
