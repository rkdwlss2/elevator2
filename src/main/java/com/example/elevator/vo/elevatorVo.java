package com.example.elevator.vo;

import java.util.List;

public class elevatorVo {


    int currentFloor; //현재 엘레베이터의 층
    int upDown; // 엘레베이터의 방향 down 0 up 1
    int eleStatus; // 엘레베이터 상태 현재 방향고정X 0 이동중(방향 고정) 1

    public elevatorVo(int i) {
        this.currentFloor=i;
        this.eleStatus=0;
        this.upDown=0;
    }

    public void getElevatorDown(){
        currentFloor--;
    }
    public void getElevatorUp(){
        currentFloor++;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getUpDown() {
        return upDown;
    }

    public int getEleStatus() {
        return eleStatus;
    }

    public void setUpDown(int upDown) {
        this.upDown = upDown;
    }

    public void setEleStatus(int eleStatus) {
        this.eleStatus = eleStatus;
    }
}
