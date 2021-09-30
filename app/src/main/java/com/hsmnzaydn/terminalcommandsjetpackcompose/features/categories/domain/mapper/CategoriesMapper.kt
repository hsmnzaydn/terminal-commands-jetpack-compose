import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.data.entities.CategoryResponse
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.data.entities.CommandResponse
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.domain.entities.Category
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.domain.entities.Command

fun CategoryResponse.toCategory() = Category(
    id?:"",
    categoryName = title?:""
)

fun CommandResponse.toCommand() = Command(
    title, description
)