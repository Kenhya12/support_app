package com.startupsupport.support_app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.startupsupport.support_app.repository.RequestTopicRepository;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/request-topics")
public class RequestTopicController {

    private final RequestTopicRepository requestTopicRepository;

    public RequestTopicController(@Autowired RequestTopicRepository requestTopicRepository) {
        this.requestTopicRepository = requestTopicRepository;
    }

    // GET Buscar un tópico por id
    @RequestMapping("/{id}")
    public ResponseEntity<RequestTopic> getRequestTopicById(@org.springframework.web.bind.annotation.PathVariable Long id) {
        return requestTopicRepository.findById(id)
                .map(topic -> ResponseEntity.ok().body(topic))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // POST Crear un nuevo tópico
    @PostMapping
    public ResponseEntity<RequestTopic> createRequestTopic(@RequestTopic requestTopic) {
        RequestTopic savedTopic = requestTopicRepository.save(requestTopic);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTopic);
    }   
    // DELETE Eliminar un tópico por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequestTopic(@PathVariable Long id ) {
        if (!requestTopicRepository.existsById(id)) {
            return ResponseEntity.noContent().build();
        } 
            requestTopicRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
}
