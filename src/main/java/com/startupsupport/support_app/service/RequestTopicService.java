package com.startupsupport.support_app.service;

import com.startupsupport.support_app.Entity.RequestTopicEntity;
import java.util.List;
import java.util.Optional;

public interface RequestTopicService {
    RequestTopicEntity createTopic(RequestTopicEntity topic);

    List<RequestTopicEntity> getAllTopics();

    Optional<RequestTopicEntity> getTopicById(Long id);

    RequestTopicEntity updateTopic(Long id,RequestTopicEntity topic);

    void deleteTopic(Long id);

    RequestTopicEntity getTopicByName(String topicName);

}
