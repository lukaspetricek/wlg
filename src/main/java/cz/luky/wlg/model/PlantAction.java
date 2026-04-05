package cz.luky.wlg.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlantAction {
    private Long id;
    private String actionType;
    private String actionDetail;
    private String note;
    private int monthFrom;
    private int monthTo;
    private Long plantId;
}
