package cz.luky.wlg.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Plant {
    private Long id;
    private String nick;               // kanadska boruvka
    private String name;               // brusnice chocholičnatá
    private String latinName;          // Vaccinium corymbosum
    private String plantType;          // kerik, strom
}
