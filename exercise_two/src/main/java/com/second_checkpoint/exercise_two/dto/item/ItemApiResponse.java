package com.second_checkpoint.exercise_two.dto.item;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * ModelApiResponse
 */
@Validated
@NoArgsConstructor
public class ItemApiResponse {
    @JsonProperty("id")
    private Integer id = null;

    @JsonProperty("message")
    private String message = null;

    public ItemApiResponse id(Integer id) {
        this.id = id;
        return this;
    }

    public ItemApiResponse(Integer id, String message) {
        this.id = id;
        this.message = message;
    }

    /**
     * Get id
     * @return id
     **/
    @Schema(example = "1", description = "")

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ItemApiResponse message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get message
     * @return message
     **/
    @Schema(example = "success", description = "")

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ItemApiResponse _apiResponse = (ItemApiResponse) o;
        return Objects.equals(this.id, _apiResponse.id) &&
                Objects.equals(this.message, _apiResponse.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ModelApiResponse {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
