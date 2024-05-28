/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.airplane_management_system.ReportSystem;

import cse.airplane_management_system.AirPlaneSystem.AirPlane;
import java.util.List;

/**
 *
 * @author 박규리
 */
public class ReportFactory {
    private List<AirPlane> AirplaneDB;
    public void SetDB( List<AirPlane> AirplaneDB){
        this.AirplaneDB = AirplaneDB;
    }
    public Report createReport(String reportType) {
        switch (reportType) {
            case "Sales":
                return new SalesReport(AirplaneDB);
            case "Reservation":
                return new ReservationReport();
            case "Feedback":
                return new FeedbackReport();
            default:
                return null;
        }
    }
}
