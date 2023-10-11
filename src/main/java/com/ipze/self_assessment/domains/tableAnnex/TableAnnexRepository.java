package com.ipze.self_assessment.domains.tableAnnex;

import com.ipze.self_assessment.model.entity.TableAnnex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TableAnnexRepository extends JpaRepository<TableAnnex, UUID> {

}
