package com.example.ticket_api.repositories;

import com.example.ticket_api.entities.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventRepositoryCustomImpl implements EventRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Event> findEventsByNameAndCity(String eventName, String location){
        CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Event> cQuery = cBuilder.createQuery(Event.class);

        Root<Event> event = cQuery.from(Event.class);

        Predicate eventNamePredicate = cBuilder.like(event.get("name"),  "%" + eventName + "%");
        Predicate eventCityPredicate = cBuilder.like(event.get("city"),  "%" + location + "%");

        Predicate finalPredicate = cBuilder.or(eventNamePredicate, eventCityPredicate);

        cQuery.where(finalPredicate);

        TypedQuery<Event> query = entityManager.createQuery(cQuery);
        return query.getResultList();
    }

}
