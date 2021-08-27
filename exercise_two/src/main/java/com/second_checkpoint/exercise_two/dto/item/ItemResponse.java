package com.second_checkpoint.exercise_two.dto.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.second_checkpoint.exercise_two.dto.image.Image;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

/**
 * ItemResponse
 */
@Validated
public class ItemResponse   {
    @JsonProperty("sku")
    private String sku = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("price")
    private Double price = null;

    @JsonProperty("currency")
    private String currency = null;

    @JsonProperty("thumbnail")
    private String thumbnail = null;

    @JsonProperty("images")
    private List<Image> images = null;

    public ItemResponse sku(String sku) {
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

    public ItemResponse name(String name) {
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

    public ItemResponse price(Double price) {
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

    public ItemResponse currency(String currency) {
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

    public ItemResponse thumbnail(String thumbnail) {
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

    public ItemResponse images(List<Image> images) {
        this.images = images;
        return this;
    }

    /**
     * Get images
     * @return images
     **/
    @Schema(required = true, description = "")
    @NotNull

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ItemResponse itemResponse = (ItemResponse) o;
        return Objects.equals(this.sku, itemResponse.sku) &&
                Objects.equals(this.name, itemResponse.name) &&
                Objects.equals(this.price, itemResponse.price) &&
                Objects.equals(this.currency, itemResponse.currency) &&
                Objects.equals(this.thumbnail, itemResponse.thumbnail) &&
                Objects.equals(this.images, itemResponse.images);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, name, price, currency, thumbnail, images);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ItemResponse {\n");

        sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    price: ").append(toIndentedString(price)).append("\n");
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("    thumbnail: ").append(toIndentedString(thumbnail)).append("\n");
        sb.append("    images: ").append(toIndentedString(images)).append("\n");
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