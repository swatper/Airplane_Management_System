package cse.airplane_management_system.ReservationSystem;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 박상현
 */
//Concrete Command
public class FileReadCommand implements FileCommand{
    private ReservationDB DB;
    private FileReader fileReader;
    
    //생성자
    public FileReadCommand(FileReader Reader){
        this.fileReader = Reader;
    }
    
    //파일 읽기 버튼을 누루면 실행
    @Override
    public void execute() {
        try {
            fileReader.ReadFile();
        } catch (IOException ex) {
            Logger.getLogger(FileReadCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
