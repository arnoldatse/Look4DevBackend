package dev.arnoldatse.opensource.look4dev.core.entities.urlSupportedPlatform.dtos;

public class UrlSupportedPlatformResponseDto {
    private int id;
    private String label;
    private String logoPath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }
}
