package tur.tkey.CargoManager.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tur.tkey.CargoManager.model.SearchRequest;
import tur.tkey.CargoManager.model.transport.Transport;
import tur.tkey.CargoManager.service.TransportService;
import tur.tkey.CargoManager.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/main")
public class UserController {
    private final UserService userService;
    private final TransportService transportService;

    @PostMapping("/searchTransport")
     public ResponseEntity<List<Transport>> getFilterResult(@RequestBody SearchRequest request) {
        //todo
            return ResponseEntity.ok().body(transportService.searchTransPort(request));
    }

    @PostMapping("/formDeal/{userId}/{transPortId}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_CARGO')")
    public ResponseEntity<?> formDeal(@PathVariable("userId")int userId,@PathVariable("transPortId")int transPortId){
        //todo
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getOpenDeals/{cargoId}")
    @PreAuthorize("hasRole('ROLE_CARGO')")
    public ResponseEntity<?> getOpenDeals(@PathVariable Long cargoId){
        //todo
        return ResponseEntity.ok().build();
    }
}
