package com.test.repository;

import com.test.domain.Index;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndexRepository extends JpaRepository<Index, Integer> {
}
