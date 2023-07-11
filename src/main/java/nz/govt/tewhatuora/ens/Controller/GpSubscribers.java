package nz.govt.tewhatuora.ens.Controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import nz.govt.tewhatuora.ens.Entity.Cache;
import nz.govt.tewhatuora.ens.Entity.RLS;
import nz.govt.tewhatuora.ens.Services.GpService;

@RestController
@AllArgsConstructor 
public class GpSubscribers {

    GpService gpService;

    @PostMapping("/json")
    public ResponseEntity<HttpStatus> json(@RequestBody String s) {
        gpService.json(s);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/email")
    public ResponseEntity<HttpStatus> email(@RequestBody String s) {
        gpService.email(s);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/db")
    public ResponseEntity<HttpStatus> db(@Validated @RequestBody RLS rls) {
        gpService.db(rls);
        System.out.println("DB call has been made");
           
        // System.out.println(gpService.db(cache));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
}
