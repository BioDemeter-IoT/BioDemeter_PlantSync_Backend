package com.plantsync.platform.plantguides.infrastructure.persistence.jpa.repositories;

import com.plantsync.platform.plantguides.domain.model.aggregates.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GuideRepository extends JpaRepository<Guide, Long> {
}
