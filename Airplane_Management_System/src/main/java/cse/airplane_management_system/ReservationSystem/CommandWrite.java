package cse.airplane_management_system.ReservationSystem;

/**
 * @author 박상현
 */

//Concrete Command
public class CommandWrite implements Command{
    private CommandWriter fileWriter;

    //생성자
    public CommandWrite(CommandWriter Writer){
        this.fileWriter = Writer;
    }
    
    //파일 쓰기 버튼 누르면 실행
    @Override
    public void execute() {
        fileWriter.WriteFile();
    }
    
}
