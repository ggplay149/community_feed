package user.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.ggplay149.user.domain.UserInfo;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void givenNameAndProImgUrl_whenCreated_thenThrowNothing (){
        //given
        String name = "name";
        String url = "";
        //when
        //then
        assertDoesNotThrow(()->new UserInfo(name,url));
    }

    @Test
    void givenBlankNameAndProImgUrl_whenCreated_thenThrowError (){
        //given
        String name = "";
        String url = "";
        //when
        //then
        assertThrows(IllegalArgumentException.class,()->new UserInfo(name,url));
    }

}
