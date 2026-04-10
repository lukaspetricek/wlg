@import java.util.List
@import cz.luky.wlg.dto.PlantItemDto

@param List<PlantItemDto> plantItemDtos

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WLG</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body>
<div class="container">
    <h1>Plant Actions</h1>
    <table border="1" cellspacing="0" cellpadding="5">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nick</th>
            <th>Name</th>
            <th>Latin Name</th>
            <th>Plant Type</th>
        </tr>
        </thead>
        <tbody>
        @for(plantItemDto plant : PlantItemDtos)
            <tr>
                <td>${plant.plantName()}</td>
                <td>${plant.actionType()}</td>
                <td>${plant.actionDetail()}</td>
                <td>${plant.note()}</td>
                <td>${plant.monthFrom()}</td>
                <td>${plant.monthTo()}</td>
            </tr>
        @endfor
        </tbody>
    </table>
</div>
</body>
</html>