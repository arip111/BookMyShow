package Dev.Arip.BookMyShow.controller;

import Dev.Arip.BookMyShow.dtos.BookTicketRequestDTO;
import Dev.Arip.BookMyShow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/ticket")
    public ResponseEntity bookTicket(@RequestBody BookTicketRequestDTO bookTicketRequestDTO) throws Exception {
        return ResponseEntity.ok(ticketService.bookTicket(bookTicketRequestDTO.getShowSeatIds(),bookTicketRequestDTO.getUserId()));
    }
    @GetMapping("/hello")
    public ResponseEntity greet()
    {
        String greet = ticketService.greet();
        return ResponseEntity.ok(greet);
    }
}
