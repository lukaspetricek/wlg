@import java.util.List
@import cz.luky.wlg.dto.PlantDto

@param List<PlantDto> plantDtos

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
    <h1>Plants</h1>
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
        @for(PlantDto plant : plantDtos)
            <tr>
                <td>${plant.getId()}</td>
                <td>${plant.getNick()}</td>
                <td>${plant.getName()}</td>
                <td>${plant.getLatinName()}</td>
                <td>${plant.getPlantType()}</td>
            </tr>
        @endfor
        </tbody>
    </table>
</div>
</body>
</html>