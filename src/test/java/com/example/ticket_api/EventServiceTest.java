package com.example.ticket_api;

import com.example.ticket_api.entities.Event;
import com.example.ticket_api.entities.dto.EventDto;
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

        EventDto dto = event.toDto();

        assertEquals(event.getId(), dto.getId());
        assertEquals(event.getName(), dto.getName());
        assertEquals(event.getCity(), dto.getCity());
        assertEquals(event.getDate(), dto.getDate());
    }

    @Test
    public void whenFetchAllDTOEvents_thenReturnAllEventsAsDTO() {

        List<EventDto> listDTO = eventServ.fetchAllDTOEvents();

        assertNotNull(listDTO);
        assertSame(listDTO.get(0).getClass(), EventDto.class);
    }

    @Test
    public void whenSearchEventsByName_thenReturnEventsWithSameNameAsDTO(){

        Event event = new Event("Rock en Seine", LocalDate.now(), "", "Luxey", "");
        eventServ.create(event);

        EventDto testedEvent = event.toDto();

        String name = "Rock";

        List<EventDto> listDTO = eventServ.searchEventsByNameOrCity(name, null);

        assertNotNull(listDTO);
        assertEquals("Rock en Seine", testedEvent.getName(), listDTO.get(0).getName());

        eventServ.deleteEvent(event.getId());

    }

    @Test
    public void whenSearchEventsByCity_thenReturnEventsWithSameCityAsDTO(){

        Event event = new Event("Rock en Seine", LocalDate.now(), "", "Luxey", "");
        eventServ.create(event);

        EventDto testedEvent = event.toDto();

        String city = "Luxey";

        List<EventDto> listDTO = eventServ.searchEventsByNameOrCity(null, city);

        assertNotNull(listDTO);
        assertEquals("Luxey", testedEvent.getCity(), listDTO.get(0).getCity());

        eventServ.deleteEvent(event.getId());

    }

}
