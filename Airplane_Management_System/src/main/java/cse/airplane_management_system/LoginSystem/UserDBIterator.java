package cse.airplane_management_system.LoginSystem;

import java.util.Iterator;

/**
 * @author 박상현
 */
public class UserDBIterator implements Iterator<User> {

    private UserDB userDB; //검색을 수행할 userDB
    private int userIndex = 0;

    //생성자
    public UserDBIterator(UserDB userDB) {
        this.userDB = userDB;
    }
    //범위 지정

    @Override
    public boolean hasNext() {
        return userIndex < userDB.GetDBSize();
    }

    //찾은 객체 전달, 0부터 DB의 크기까지 모든 객체를 하나씩 전달함
    @Override
    public User next() {
        User targetUser = userDB.GetUser(userIndex);
        userIndex++;
        return targetUser;
    }

}
