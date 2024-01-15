package com.example.gameoftruth2.controller;

import com.example.gameoftruth2.model.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class RoomController {

    @GetMapping("/")
    public String game(Model model) {

        return "index";
    }

    @GetMapping("/init")
      public String init() {

          return "init";
      }
}
