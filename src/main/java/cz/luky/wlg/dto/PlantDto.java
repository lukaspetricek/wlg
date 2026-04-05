package cz.luky.wlg.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlantDto {
    private Long id;
    private String nick;
    private String name;
    private String latinName;
    private String plantType;
}