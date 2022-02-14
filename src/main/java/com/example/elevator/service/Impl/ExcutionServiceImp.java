package com.example.elevator.service.Impl;

import com.example.elevator.service.ExcutionSerivce;
import com.example.elevator.vo.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("excutionService")
public class ExcutionServiceImp implements ExcutionSerivce {
    elevatorVo elevator = new elevatorVo(10);

    List<memberVo> reservationList=new ArrayList<>();
    @Override
    public void moveElevator() {
        int nowFloor = elevator.getCurrentFloor();
        int eleStatus = elevator.getEleStatus();
        System.out.println(nowFloor);
        elevator.getElevatorUp();
        if (eleStatus==0){ //현재 엘레베이터 이동중이 아니다.
            int Max=9999;
            for (memberVo now : reservationList){
                if (now.getState().equals("1"))continue; //안에 들어온 사람은 안됨
                int gap=Math.abs(now.getStartFloor()-nowFloor);
                if (Max>gap)Max=gap;
            }
            for (memberVo now : reservationList){
                if (now.getState().equals("1"))continue; //안에 들어온 사람은 안됨
                int gap=Math.abs(now.getStartFloor()-nowFloor);
                if (gap==Max) {
                    if (Max==0){//해당 층일때 엘레베이터 안으로
                        now.setState("1");//안에 들어온 사람으로 변경
                        now.setMoveCnt(0);//
                    }else{ // 멀리 있는 층일때 방향 설정
                        if (nowFloor-now.getStartFloor()>0){ //현재 층이윗층일때 아래로 내려가야한다
                            elevator.getElevatorDown();
                            elevator.setUpDown(0);
                        }else{ //현재 층이 아랫층일때 위로 올라가야한다
                            elevator.getElevatorUp();
                            elevator.setUpDown(1);
                        }
                    }
                }
            }
            elevator.setEleStatus(1);
        }else{
            int MaxNum=9999;
            for (memberVo now : reservationList){
                if (now.getState().equals("0"))continue; //밖에 있는 사람은 안됨
                int gap=Math.abs(now.getStartFloor()-nowFloor);
                if (MaxNum>gap)MaxNum=gap;
            }
            for (memberVo now : reservationList){
                if (now.getState().equals("0"))continue; //밖에 있는 사람은 안됨
                int gap=Math.abs(now.getStartFloor()-nowFloor);
                if (gap==MaxNum) {
                    if (MaxNum==0){//해당 층일때 엘레베이터 밖으로
                        now.setState("2");//이제 아예 밖으로 나간 사람으로 설정
                    }else{ // 멀리 있는 층일때 방향 설정
                        if (elevator.getUpDown()==0){ //현재 층이윗층일때 아래로 내려가야한다
                            elevator.getElevatorDown();
                        }else{ //현재 층이 아랫층일때 위로 올라가야한다
                            elevator.getElevatorUp();
                        }
                    }
                }
            }
        }
        allMoveCntUp(); //moveCnt를 1씩 모두 증가시켜준다.
    }

    @Override
    public void reservation(reservationVo reservation) {
        String name=reservation.getName();
        int startFloor=reservation.getStartFloor();
        int endFloor=reservation.getEndFloor();
        memberVo member = new memberVo(name,startFloor,endFloor,0,"0");
    }

    @Override
    public elevationStatusVo getStatus() {
        elevationStatusVo elevationStatus = new elevationStatusVo();
        elevationStatus.setCurrentFloor(elevator.getCurrentFloor());
        for (memberVo now : reservationList){
            memberReturnVo memberReturn = new memberReturnVo();
            memberReturn.setName(now.getName());
            memberReturn.setCnt(now.getMoveCnt());
            memberReturn.setFloor(now.getEndFloor());
            if (now.getState().equals("0")){ //외부 인원일때
                elevationStatus.getInnerList().add(memberReturn);
            }else{
                reservationVo reservation = new reservationVo();
                reservation.setName(now.getName());
                reservation.setStartFloor(now.getStartFloor());
                reservation.setEndFloor(now.getEndFloor());
                elevationStatus.getOuterList().add(reservation);
            }

        }
        return elevationStatus;
    }

    public void allMoveCntUp(){
        for (memberVo now : reservationList){
            now.moveCntUp();
        }
    }



}
