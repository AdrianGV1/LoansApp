package org.una.programmingIII.loans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.una.programmingIII.loans.model.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
