package otus.ru.rest.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@JsonSerialize
@NoArgsConstructor
public class UserOut {

    private Long code;
    private String message;
    private String type;
}
