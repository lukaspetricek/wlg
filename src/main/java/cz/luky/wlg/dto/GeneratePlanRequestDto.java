package cz.luky.wlg.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GeneratePlanRequestDto {
    private List<Long> plantIds;
}
