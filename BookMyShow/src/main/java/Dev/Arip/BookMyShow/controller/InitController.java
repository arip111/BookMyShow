package Dev.Arip.BookMyShow.controller;

import Dev.Arip.BookMyShow.service.InItService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {

    @Autowired
    private InItService inItService;

    @GetMapping("/init")
    public ResponseEntity generateData()
    {
        return ResponseEntity.ok(inItService.initialize());
    }
}
