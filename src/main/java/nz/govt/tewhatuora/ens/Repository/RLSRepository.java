package nz.govt.tewhatuora.ens.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nz.govt.tewhatuora.ens.Entity.RLS;

@Repository
public interface RLSRepository extends JpaRepository<RLS, Long>{
    
}
