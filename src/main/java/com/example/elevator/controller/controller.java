package com.example.elevator.controller;

import com.example.elevator.service.ExcutionSerivce;
import com.example.elevator.vo.elevationStatusVo;
import com.example.elevator.vo.reservationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/elevator")
public class controller {

    @Autowired
    private ExcutionSerivce excutionSerivce;

    @GetMapping("/excution")
    public void excution(){
        excutionSerivce.moveElevator();
    }

    @PostMapping(value = "/reservation")
    public elevationStatusVo reservation(@RequestBody reservationVo reservation) {
        System.out.println("i am in");
        elevationStatusVo ele = new elevationStatusVo();
        ele.setCurrentFloor(2);
        excutionSerivce.reservation(reservation);
        return ele;
    }

    @PostMapping(value = "/getStatus")
    public elevationStatusVo getStatus() {
        return excutionSerivce.getStatus();
    }

}
