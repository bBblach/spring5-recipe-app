package guru.springframework.repositories;

import guru.springframework.domain.UnitOfMeausre;
import org.springframework.data.repository.CrudRepository;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeausre, Long> {
}
