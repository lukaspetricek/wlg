package cz.luky.wlg.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlantAction {
    private Long id;
    private String actionType;
    private String actionDetail;
    private int monthFrom;
    private int monthTo;
    private String note;
    private Long plantId;
}
