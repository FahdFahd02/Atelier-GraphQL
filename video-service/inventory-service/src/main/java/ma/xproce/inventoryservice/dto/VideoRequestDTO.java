package ma.xproce.inventoryservice.dto;

import lombok.Data;

@Data
public class VideoRequestDTO {
    private String name;
    private String url;
    private String description;
    private String datePublication;
    private CreatorRequestDTO creator;
}
