/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cse.airplane_management_system.AirPlaneSystem;

/**
 *
 * @author kb010
 */

import java.io.IOException;

public class MenuContext {
    private MenuBehavior strategy;

    public void setStrategy(MenuBehavior strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() throws IOException {
        if (strategy != null) {
            strategy.showMenu();
        } else {
            System.out.println("전략이 설정되지 않았습니다.");
        }
    }
}