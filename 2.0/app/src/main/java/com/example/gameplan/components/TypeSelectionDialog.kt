import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.gameplan.ui.theme.screens.GameMode

@Composable
fun TypeSelectionDialog(gameMode: GameMode, onDismiss: () -> Unit, onSubmit: (String) -> Unit) {
    var username by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text("Enter Username for ${gameMode.name}") },
        text = {
            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") }
            )
        },
        confirmButton = {
            Button(onClick = { onSubmit(username) }) {
                Text("Submit")
            }
        },
        dismissButton = {
            Button(onClick = { onDismiss() }) {
                Text("Cancel")
            }
        }
    )
}
