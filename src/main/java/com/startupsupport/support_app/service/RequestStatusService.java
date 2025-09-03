package com.startupsupport.support_app.service;

import com.startupsupport.support_app.Entity.RequestStatusEntity;
import java.util.List;
import java.util.Optional;

public interface RequestStatusService {
    RequestStatusEntity createStatus(RequestStatusEntity status);

    List<RequestStatusEntity> getAllStatuses();

    Optional<RequestStatusEntity> getStatusById(Long id);

    RequestStatusEntity updateStatus(Long id, RequestStatusEntity status);

    void deleteStatus(Long id);

    RequestStatusEntity getStatusByName(String statusName);
}
