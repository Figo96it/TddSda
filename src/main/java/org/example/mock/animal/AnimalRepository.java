package org.example.mock.animal;

import java.util.Optional;

public interface AnimalRepository {
    Optional<Animal> findByIdAndType(Long id, String type);

    Animal save(Animal animal);
}
