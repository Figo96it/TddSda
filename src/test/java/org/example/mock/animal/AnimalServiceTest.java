package org.example.mock.animal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AnimalServiceTest {

    @Mock
    private AnimalRepository animalRepository;

    private AnimalService animalService;

    @BeforeEach
    void setUp() {
        animalService = new AnimalService(animalRepository);
    }

    @Test
    void shouldReturnCorrectAnimalInfoWhenFound() {
        //given
        Long id = 1L;
        String type = "fish";

        Animal animalToReturn = new Animal(id, type, "Nemo");
        Optional<Animal> animalToReturnAsOptional = Optional.of(animalToReturn);
        Mockito.when(animalRepository.findByIdAndType(id, type)).thenReturn(animalToReturnAsOptional);
        //when
        Animal result = animalService.getAnimalByIdAndType(1L, "fish");
        //then
        Assertions.assertEquals(result, animalToReturn);
    }

    @Test
    void shouldThrowExceptionWhenAnimalNotFound() {
        //given
        Long id = 2L;
        String type = "cat";
        Mockito.when(animalRepository.findByIdAndType(id, type)).thenReturn(Optional.empty());

        //when
        //then
        Assertions.assertThrows(AnimalNotFoundException.class, () -> animalService.getAnimalByIdAndType(id, type));
    }

    @Test
    void shouldCreateAnimal() {
        //given
        Long id = 28L;
        String type = "snake";
        Animal animalToCreate = new Animal(id, type, "Snake");

        Mockito.when(animalRepository.save(Mockito.any())).thenReturn(animalToCreate);
        //when
        Animal result = animalService.createAnimal(animalToCreate);

        //then
        Assertions.assertEquals(animalToCreate, result);
    }
}
