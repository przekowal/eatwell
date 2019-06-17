package pl.eatwell.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.eatwell.model.Measure;

import java.util.Optional;

public interface MeasureRepository extends CrudRepository<Measure, Long> {

    Optional<Measure> findByDescription(String description);
}
