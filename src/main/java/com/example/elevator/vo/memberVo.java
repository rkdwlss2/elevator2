package com.example.elevator.vo;

public class memberVo {

    public memberVo(String name, int startFloor, int endFloor, int moveCnt, String state) {
        this.name = name;
        this.startFloor = startFloor;
        this.endFloor = endFloor;
        this.moveCnt = moveCnt;
        this.state = state;
    }

    private String name; //사람 이름
    private int startFloor; //
    private int endFloor;
    private int moveCnt; //기다리는 숫자
    private String state; //현재 밖에서 예약 기다리는중인지 0 , 안에 있는지 상태 1

    public void moveCntUp(){
        this.moveCnt++;
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

    public void setMoveCnt(int moveCnt) {
        this.moveCnt = moveCnt;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public int getStartFloor() {
        return startFloor;
    }

    public int getEndFloor() {
        return endFloor;
    }

    public int getMoveCnt() {
        return moveCnt;
    }

    public String getState() {
        return state;
    }



}
