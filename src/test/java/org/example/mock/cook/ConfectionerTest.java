package org.example.mock.cook;

import org.example.mock.cook.Confectioner;
import org.example.mock.cook.Flour;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class ConfectionerTest {

    @Mock
    private Flour flour;

    @Test
    void shouldCreateRecipeTest(){
        //given
        flour = () -> 10;
        //when
        Confectioner confectioner = new Confectioner(flour);
        //then
        Assertions.assertEquals(confectioner.createRecipe(), "Ciasto z 10gr. mąki.");
    }

}
