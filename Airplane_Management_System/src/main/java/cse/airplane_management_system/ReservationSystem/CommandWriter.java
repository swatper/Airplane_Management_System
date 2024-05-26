package cse.airplane_management_system.ReservationSystem;

import cse.airplane_management_system.FileManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 박상현
 */

//Receiver
public class CommandWriter{
    public FileManager WriteFile;
    public ReservationDB DB;

    
    public CommandWriter(ReservationDB InputDB){
        WriteFile = new FileManager();
        this.DB = InputDB;
    }
    //파일 쓰는 작업(버튼 기능)
    public void WriteFile() {
        try {
            WriteFile.writeDBFile(2, DB.GetReservationDB());
        } catch (IOException ex) {
            Logger.getLogger(CommandWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("DB의 내용을 파일에 적습니다. ");
    }
    
}
