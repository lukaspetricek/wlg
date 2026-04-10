package cz.luky.wlg.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MonthlyPlanResponseDto {
    private String month;
    private List<PlantItemDto> items;

    public MonthlyPlanResponseDto(String month, List<PlantItemDto> items) {
        this.month = month;
        this.items = items;
    }
}
