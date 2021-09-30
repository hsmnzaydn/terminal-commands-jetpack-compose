import com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.data.entities.RegisterResponse
import com.hsmnzaydn.terminalcommandsjetpackcompose.features.accounts.domain.entities.User

fun RegisterResponse.toUser() = User(
    userId,
    authozationKey
)