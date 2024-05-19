package cse.airplane_management_system.ReservationSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 박상현
 */
//Concrete Command
public class CommandResearch implements Command{
    private ArrayList<String> fileInfo;
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
