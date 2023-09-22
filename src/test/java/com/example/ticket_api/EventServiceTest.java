package com.example.ticket_api;

import com.example.ticket_api.entities.Event;
import com.example.ticket_api.entities.dto.EventDTO;
import com.example.ticket_api.services.EventService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
class EventServiceTest {


    @Autowired
    EventService eventServ;

    @Test
    public void whenEventToDto_thenReturnEventDTOWithSameAttributes() {

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

    @Test
    public void whenFetchAllDTOEvents_thenReturnAllEventsAsDTO() {

        List<EventDTO> listDTO = eventServ.fetchAllDTOEvents();

        assertNotNull(listDTO);
        assertSame(listDTO.get(0).getClass(), EventDTO.class);
    }

}
