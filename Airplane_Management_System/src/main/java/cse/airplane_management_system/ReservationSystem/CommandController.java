package cse.airplane_management_system.ReservationSystem;

/**
 * @author 박상현
 */

//Command Pattern  Invoker (리모컨)
public class CommandController {
    private Command Command; //Command 연관
    
    //생성자
    public CommandController(){}
    
    //명령어 타입(?) 설정-> 버튼 설정
    public void SetCommand(Command Command){
        this.Command =Command;
    }
    
    //명령어 실행(리모컨 버튼 누름)
    public void RunCommand(){
        Command.execute();
    }
    
}
