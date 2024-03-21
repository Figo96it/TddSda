package org.example.mock.car;

import org.example.mock.car.Car;
import org.example.mock.car.Tire;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CarTest {

    @Mock
    private Tire tire;

    @Test
    void shouldCanDriveInWinter(){
        //given
        Mockito.when(tire.isWinter()).thenReturn(true);
        List<Tire> tiresList = new ArrayList<>();
        tiresList.add(tire);
        tiresList.add(tire);
        tiresList.add(tire);
        tiresList.add(tire);
        Car car = new Car(tiresList);
        //when
        boolean ifCanDriveInWinter = car.canDriveInWinter();
        //then
        Assertions.assertTrue(ifCanDriveInWinter);

    }

    @Test
    void allTyresAreSummerTest() {
        //given
        Mockito
                .when(tire.isWinter())
                .thenReturn(false); // tutaj jest tak ze za kazdym wywołaniem metody zwraca false

        List<Tire> tyres = new ArrayList<>();
        tyres.add(tire);
        tyres.add(tire);
        tyres.add(tire);
        tyres.add(tire);

        Car car = new Car(tyres);
        //when

        boolean result = car.canDriveInWinter();

        //then
        Assertions.assertFalse(result);

    }

    @Test
    void oneOfTyresSetIsSummer() {
        //given
        Mockito
                .when(tire.isWinter())
                .thenReturn(true) // tutaj wywłujemy
                .thenReturn(true)
                .thenReturn(false)
                .thenReturn(true);

        //when
        List<Tire> tyreList = new ArrayList<>();
        tyreList.add(tire);
        tyreList.add(tire);
        tyreList.add(tire);
        tyreList.add(tire);

        Car car = new Car(tyreList);
        boolean result = car.canDriveInWinter();
        //then
        org.assertj.core.api.Assertions
                .assertThat(result)
                .isFalse();
    }
}
