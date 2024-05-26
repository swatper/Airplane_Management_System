
package cse.airplane_management_system.LoginSystem;

/**
 * @author 박상현
 */
public class AlgoLogin extends AlgoUserInfoInput{

    @Override
    void OtherInfoInput() {
        TargetUser =new User(userID, userPW);
        }
}
