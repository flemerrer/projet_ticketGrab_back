package com.example.ticket_api;

import com.example.ticket_api.entities.Event;
import com.example.ticket_api.entities.dto.EventDTO;
import com.example.ticket_api.services.EventService;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class EventServiceTest {


    @Autowired
    EventService eventServ;

    @Test
    public void whenEventToDto_thenReturnEventDTOWithSharedAttributes() {

        Event event = new Event();
        event.setId(1L);
        event.setName("Hellfest");
        event.setCity("Clisson");
        event.setDate(LocalDate.of(2007, 12, 03));

        EventDTO dto = event.toDto();


        assertEquals(event.getId(), dto.getId());
        assertEquals(event.getName(), dto.getName());
        assertEquals(event.getCity(), dto.getCity());
        assertEquals(event.getDate(), dto.getDate());
    }

}
