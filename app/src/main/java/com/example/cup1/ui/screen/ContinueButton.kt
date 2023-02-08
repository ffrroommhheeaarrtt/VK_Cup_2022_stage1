package com.example.cup1.ui.screen

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cup1.ui.theme.Cup1Theme

@Composable
fun ContinueButton(modifier: Modifier = Modifier, visible: Boolean = true, categoryCounter: Int) {
    val context = LocalContext.current

    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically(
            initialOffsetY = { -it * 100 },
            animationSpec = spring(stiffness = Spring.StiffnessVeryLow)
        )
    ) {
        Button(
            onClick = {
                Toast.makeText(context, "Go to the next screen", Toast.LENGTH_SHORT).show()
            },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
            modifier = modifier
                .padding(8.dp)
                .widthIn(max = 300.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = if (categoryCounter == 0) "Later" else "Continue",
                style = MaterialTheme.typography.displaySmall
            )
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ContinueButtonPreview() {
    Cup1Theme {
        Surface {
            ContinueButton(categoryCounter = 1)
        }
    }
}