package com.second_checkpoint.exercise_two.dto.item;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * ItemRequest
 */
@Validated
public class ItemRequest   {
    @NotNull(message="Sku required")
    @JsonProperty("sku")
    private String sku = null;

    @NotNull(message="Name required")
    @JsonProperty("name")
    private String name = null;

    @NotNull(message="Price required")
    @JsonProperty("price")
    private Double price = null;

    @NotNull(message="Currency required")
    @JsonProperty("currency")
    private String currency = null;

    @NotNull(message="thumbnail required")
    @JsonProperty("thumbnail")
    private String thumbnail = null;

    public ItemRequest sku(String sku) {
        this.sku = sku;
        return this;
    }

    /**
     * Get sku
     * @return sku
     **/
    @Schema(required = true, description = "")
    @NotNull

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public ItemRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * @return name
     **/
    @Schema(example = "soap", required = true, description = "")
    @NotNull

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemRequest price(Double price) {
        this.price = price;
        return this;
    }

    /**
     * Get price
     * @return price
     **/
    @Schema(required = true, description = "")
    @NotNull

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ItemRequest currency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Get currency
     * @return currency
     **/
    @Schema(required = true, description = "")
    @NotNull

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public ItemRequest thumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    /**
     * Get thumbnail
     * @return thumbnail
     **/
    @Schema(required = true, description = "")
    @NotNull

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ItemRequest itemRequest = (ItemRequest) o;
        return Objects.equals(this.sku, itemRequest.sku) &&
                Objects.equals(this.name, itemRequest.name) &&
                Objects.equals(this.price, itemRequest.price) &&
                Objects.equals(this.currency, itemRequest.currency) &&
                Objects.equals(this.thumbnail, itemRequest.thumbnail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, name, price, currency, thumbnail);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ItemRequest {\n");

        sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    price: ").append(toIndentedString(price)).append("\n");
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("    thumbnail: ").append(toIndentedString(thumbnail)).append("\n");
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