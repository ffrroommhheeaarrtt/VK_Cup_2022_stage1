package com.example.cup1.ui.screen

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cup1.ui.theme.Cup1Theme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun CategoryChip(
    text: String,
    modifier: Modifier = Modifier,
    visible: Boolean = true,
    selected: Boolean = false,
    onClick: () -> Unit = {}
) {
    val horizontalPadding = if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT) 8.dp else 4.dp
    val verticalPadding = if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT) 4.dp else 0.dp

    AnimatedVisibility(
        visible = visible,
        enter = scaleIn(animationSpec = spring(
            stiffness = (10..100).random().toFloat(),
            dampingRatio = Spring.DampingRatioMediumBouncy
        ))
    ) {
        FilterChip(
            label = { Text(text = text) },
            onClick = onClick,
            selected = selected,
            trailingIcon = {
                if (selected) Icon(imageVector = Icons.Filled.Check, contentDescription = null)
                else Icon(imageVector = Icons.Filled.AddCircle, contentDescription = null)
            },
            shape = RoundedCornerShape(animateDpAsState(if (selected) 30.dp else 10.dp).value),
            modifier = modifier
                .padding(horizontal = horizontalPadding, vertical = verticalPadding)
                .rotate(
                    animateFloatAsState(
                        targetValue = if (selected) 360f else 0f,
                        animationSpec = spring(
                            stiffness = Spring.StiffnessVeryLow,
                            dampingRatio = Spring.DampingRatioMediumBouncy
                        )
                    ).value
                )
        )
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CategoryChipPreview() {
    Cup1Theme {
        Surface {
            CategoryChip(text = "Sport", modifier = Modifier.padding(8.dp))
        }
    }
}