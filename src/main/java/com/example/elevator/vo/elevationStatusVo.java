package com.example.elevator.vo;

import java.util.List;

public class elevationStatusVo {
    int currentFloor; //현재 엘레베이터의 층
    List<memberReturnVo> innerList; //내부인원
    List<reservationVo> outerList; //외부인원

    public int getCurrentFloor() {
        return currentFloor;
    }

    public List<memberReturnVo> getInnerList() {
        return innerList;
    }

    public List<reservationVo> getOuterList() {
        return outerList;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setInnerList(List<memberReturnVo> innerList) {
        this.innerList = innerList;
    }

    public void setOuterList(List<reservationVo> outerList) {
        this.outerList = outerList;
    }
}
