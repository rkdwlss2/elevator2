package com.example.elevator.vo;

public class reservationVo {
    String name;
    int startFloor;
    int endFloor;

    public String getName() {
        return name;
    }

    public int getStartFloor() {
        return startFloor;
    }

    public int getEndFloor() {
        return endFloor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartFloor(int startFloor) {
        this.startFloor = startFloor;
    }

    public void setEndFloor(int endFloor) {
        this.endFloor = endFloor;
    }
}
