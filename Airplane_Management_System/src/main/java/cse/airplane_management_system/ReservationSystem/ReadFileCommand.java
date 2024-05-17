package cse.airplane_management_system.ReservationSystem;

/**
 * @author 박상현
 */
//Concrete Command
public class ReadFileCommand implements FileCommand{
    private ReservationDB DB;
    private FileReader fileReader;
    
    //생성자
    public ReadFileCommand(FileReader SetFileReader){
        this.fileReader = SetFileReader;
    }
    
    @Override
    public void execute() {
        //fileReader,execute();
        
    }
    
}
