package br.com.interBank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.interBank.entities.TransferEntity;

@Repository
public interface TransferRepository extends JpaRepository<TransferEntity, Long> {

}
