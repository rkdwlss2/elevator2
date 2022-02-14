package com.example.elevator.service;


import com.example.elevator.vo.elevationStatusVo;
import com.example.elevator.vo.reservationVo;

public interface ExcutionSerivce{
    public void moveElevator();

    public void reservation(reservationVo reservation);

    elevationStatusVo getStatus();
}
