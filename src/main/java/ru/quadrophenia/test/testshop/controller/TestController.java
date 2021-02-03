package ru.quadrophenia.test.testshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.quadrophenia.test.testshop.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/getMSG")
    public String getMSG() {
        return "Its work";
    }

    @GetMapping("/addGoods")
    public Boolean addGoods(
            @RequestParam("name") String name,
            @RequestParam("price") Double price
    ) {
        return testService.addGoods(name, price);
    }

    @GetMapping("/getAllDoods")
    public ResponseEntity<?> getAllDoods() {
        return ResponseEntity.ok(testService.getAllDoods());
    }

    @GetMapping("/goodsFindById")
    public ResponseEntity<?> goodsFindById(
            @RequestParam("id") Integer id
    ) {
        return ResponseEntity.ok(testService.goodsFindById(id));
    }

    @GetMapping("/getGoodsIdName")
    public ResponseEntity<?> getGoodsIdName() {
        return ResponseEntity.ok(testService.getGoodsIdName());
    }
}
