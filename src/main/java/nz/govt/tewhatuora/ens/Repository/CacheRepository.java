package nz.govt.tewhatuora.ens.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nz.govt.tewhatuora.ens.Entity.Cache;

@Repository
public interface CacheRepository extends JpaRepository<Cache, Long>{
}
