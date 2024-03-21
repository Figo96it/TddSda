package org.example.mock.animal;

import java.util.Optional;

public class AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal getAnimalByIdAndType(Long id, String type) {
        Optional<Animal> foundAnimalOpt = animalRepository.findByIdAndType(id, type);
        return foundAnimalOpt.orElseThrow(() ->
                new AnimalNotFoundException("Animal not found. Id: " + id + ", type: " + type));
    }

    public Animal createAnimal(Animal animal) {
        return animalRepository.save(animal);
    }
}
