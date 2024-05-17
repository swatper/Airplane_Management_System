package cse.airplane_management_system.ReservationSystem;

/**
 * @author 박상현
 */
//Command Pattern  Invoker (리모컨)
public class FileController {
    private FileCommand Command; //Command 연관
    
    //생성자
    public FileController(){}
    
    //명령어 타입(?) 설정-> 버튼 설정
    public void SetCommand(FileCommand Command){
        this.Command =Command;
    }
    
    //명령어 실행(리모컨 버튼 누름)
    public void RunCommand(){
        Command.execute();
    }
    
}
