import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.data.entities.CategoryResponse
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.categories.domain.entities.Category

fun CategoryResponse.toCategory() = Category(
    id?:"",
    categoryName = title?:""
)