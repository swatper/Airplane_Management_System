package cse.airplane_management_system.ReservationSystem;

import cse.airplane_management_system.FileManager;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author 박상현
 */
public class FileReader {
    public FileManager ReadFile;
    //파일에 읽은 내용을 저장할 String형 ArratList
    public ArrayList<String> FileInfo;
    
    //생성자
    public FileReader(){
        ReadFile = new FileManager();
    };
    
    public void ReadFile() throws IOException{
        FileInfo = ReadFile.readDBFile(2);
    }
    
    //파일에 읽은 내용 전달
    public ArrayList<String> GetFileInfo(){
        return FileInfo;
    }
}
