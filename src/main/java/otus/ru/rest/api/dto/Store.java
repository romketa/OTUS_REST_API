package otus.ru.rest.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
public class Store implements Serializable {
	private int id;
	private int petId;
	private int quantity;
	private String shipDate;
	private String status;
	private boolean complete;
}