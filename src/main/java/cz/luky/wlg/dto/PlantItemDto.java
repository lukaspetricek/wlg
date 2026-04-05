package cz.luky.wlg.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlantItemDto {
    private String plantName;
    private String actionType;
    private String actionDetail;
    private String note;
    private int monthFrom;
    private int monthTo;
}
