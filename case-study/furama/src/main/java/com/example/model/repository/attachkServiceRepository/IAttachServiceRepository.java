package com.example.model.repository.attachkServiceRepository;

import com.example.model.entity.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAttachServiceRepository extends JpaRepository<AttachService,Long> {
    List<AttachService> findAll();
}
