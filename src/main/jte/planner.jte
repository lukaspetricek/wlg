@import java.util.List
@import cz.luky.wlg.dto.MonthlyPlanResponseDto
@import cz.luky.wlg.dto.PlantItemDto

@param List<MonthlyPlanResponseDto> monthlyPlans

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WLG</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-gray-100">
<div class="w-full px-4">
    <h1 class="text-2xl font-bold mb-6">Monthly Plan</h1>
    <div class="overflow-x-auto bg-white shadow rounded-lg">
        <table class="min-w-full table-fixed">
            <thead class="bg-gray-50">
            <tr>
                <th class="w-1/6 px-4 py-2 text-left text-sm font-semibold text-gray-600">Plant</th>
                <th class="w-1/6 px-4 py-2 text-left text-sm font-semibold text-gray-600">Action Type</th>
                <th class="w-1/6 px-4 py-2 text-left text-sm font-semibold text-gray-600">Detail</th>
                <th class="w-1/6 px-4 py-2 text-left text-sm font-semibold text-gray-600">Note</th>
                <th class="w-1/6 px-4 py-2 text-left text-sm font-semibold text-gray-600">From</th>
                <th class="w-1/6 px-4 py-2 text-left text-sm font-semibold text-gray-600">To</th>
            </tr>
            </thead>
            <tbody class="divide-y divide-gray-200">
            @for(MonthlyPlanResponseDto plan : monthlyPlans)
                <tr>
                    <td colspan="6" class="bg-gray-200 font-bold px-4 py-3 text-lg">
                        ${plan.getMonth()}
                    </td>
                </tr>
                @for(PlantItemDto item : plan.getItems())
                    <tr class="hover:bg-gray-50">
                        <td class="px-4 py-2">${item.getPlantName()}</td>
                        <td class="px-4 py-2">${item.getActionType()}</td>
                        <td class="px-4 py-2">${item.getActionDetail()}</td>
                        <td class="px-4 py-2">${item.getNote()}</td>
                        <td class="px-4 py-2">${item.getMonthFrom()}</td>
                        <td class="px-4 py-2">${item.getMonthTo()}</td>
                    </tr>
                @endfor
            @endfor
            </tbody>
        </table>
    </div>
</div>
</body>
</html>