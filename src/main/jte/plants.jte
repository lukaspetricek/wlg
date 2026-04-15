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
<div class="overflow-x-auto bg-white shadow rounded-lg">
    <table class="min-w-full divide-y divide-gray-200">
        <thead class="bg-gray-50">
        <tr>
            <th class="px-4 py-2 text-left text-sm font-semibold text-gray-600">ID</th>
            <th class="px-4 py-2 text-left text-sm font-semibold text-gray-600">Nick</th>
            <th class="px-4 py-2 text-left text-sm font-semibold text-gray-600">Name</th>
            <th class="px-4 py-2 text-left text-sm font-semibold text-gray-600">Latin Name</th>
            <th class="px-4 py-2 text-left text-sm font-semibold text-gray-600">Plant Type</th>
        </tr>
        </thead>
        <tbody class="divide-y divide-gray-200"> @for(PlantDto plant : plantDtos)
            <tr class="hover:bg-gray-50">
                <td class="px-4 py-2">${plant.getId()}</td>
                <td class="px-4 py-2">${plant.getNick()}</td>
                <td class="px-4 py-2">${plant.getName()}</td>
                <td class="px-4 py-2">${plant.getLatinName()}</td>
                <td class="px-4 py-2">${plant.getPlantType()}</td>
            </tr> @endfor </tbody>
    </table>
</div>
</body>
</html>