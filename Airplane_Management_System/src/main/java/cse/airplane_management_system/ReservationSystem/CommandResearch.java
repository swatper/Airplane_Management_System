package cse.airplane_management_system.ReservationSystem;

/**
 * @author 박상현
 */
//Concrete Command
public class CommandResearch implements Command{
    private CommandResearcher researcher;
    
    //생성자
    public CommandResearch(CommandResearcher researcher){
        this.researcher = researcher;
    }
    
    //파일 읽기 버튼을 누루면 실행
    @Override
    public void execute() {
        researcher.Search();
    }
    
}
