package com.example.cup1.ui.screen

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cup1.ui.theme.Cup1Theme

@Composable
fun CategoryChoiceLabel(modifier: Modifier = Modifier, visible: Boolean = true) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(animationSpec = spring(stiffness = Spring.StiffnessVeryLow))
    ) {
        Text(
            text = "Choose your favorite categories",
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            modifier = modifier.padding(vertical = 8.dp, horizontal = 4.dp),
        )
    }
}


@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CategoryChoiceLabelPreview() {
    Cup1Theme {
        Surface {
            CategoryChoiceLabel(modifier = Modifier.padding(8.dp))
        }
    }
}