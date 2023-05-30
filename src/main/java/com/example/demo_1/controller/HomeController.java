package com.example.demo_1.controller;

import com.example.demo_1.dto.NationDTO;
import com.example.demo_1.service.HomeService;
import com.example.demo_1.service.HomeService2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor // final을 적용한 필드를 매개변수로 하는 생성자
public class HomeController {
    private final HomeService homeService;
    private HomeService2 homeService2;

//    public HomeController(HomeService homeService, HomeService2 homeService2) {
//        this.homeService=homeService;
//        this.homeService2=homeService2;}
//     ==> 이게 바로 @RequiredArgsController를 넣으면 위의 세 줄 코드를 넣는다는 것을 의미함.
//    public HomeController(HomeService homeService){
//        this.homeService = homeService;
//    }


    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/hell1")
    public String hell1(){
        return "hell1";
    }
    @GetMapping("/hell2")
    public String hell2(){
        homeService.save();
        return "hell2";
    }
    @GetMapping("/param/{id}")
    public String param1(@PathVariable Long id){
        System.out.println("id = " + id); // soutp
        return "index";
    }
    @GetMapping("/model1")
    public String model1(Model model){
        model.addAttribute("param1","안녕하세요");
        model.addAttribute("param2","감사해요");
        model.addAttribute("param3","다시 만나요");
        return  "model1";
    }

    @GetMapping("/model2")
    public String model2(Model model){
        NationDTO  nationDTO = new NationDTO();
        nationDTO.setName("대한민국");
        nationDTO.setCapital("인천");
        nationDTO.setPopulation(3000000);
        model.addAttribute("nation",nationDTO);
        return "model2";
    }
    @GetMapping("/model3")
    public String model3(Model model){
        List<NationDTO> nationDTOList = new ArrayList<>();
        nationDTOList.add(new NationDTO("대한민국","인천",3000000));
        nationDTOList.add(new NationDTO("미국","WashingTonDC",33190000));
        nationDTOList.add(new NationDTO("프랑스", "Paris", 6775000 ));
        nationDTOList.add(new NationDTO("호주","캔버라", 25690000));
        model.addAttribute("list", nationDTOList);
        return "model3";
    }
}
