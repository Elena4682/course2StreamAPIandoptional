package pro.sky.course2StreamAPIandoptional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidInputExeption extends RuntimeException{

}