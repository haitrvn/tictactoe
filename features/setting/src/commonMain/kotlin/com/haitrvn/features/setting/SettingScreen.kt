import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SettingScreen() {

}

@Composable
fun SettingAvatar() {

}

@Composable
fun SettingType() {
    Text()
}

@Composable
fun SettingTypeItem(modifier: Modifier) {
    Row(
        modifier = Modifier
            .heightIn(min = 30.dp)
            .fillMaxWidth()
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically
    ) {

    }
}