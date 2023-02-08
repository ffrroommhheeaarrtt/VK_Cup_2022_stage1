package com.example.cup1.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cup1.data.SampleData
import com.example.cup1.ui.theme.Cup1Theme
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun MainScreen(modifier: Modifier = Modifier, visible: Boolean = true) {
    var categoryCounter by rememberSaveable { mutableStateOf(0) }

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        CategoryChoiceLabel(visible = visible)
        FlowRow(
            mainAxisAlignment = FlowMainAxisAlignment.Center,
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            for (text in SampleData.categoryList) {
                var selected by rememberSaveable { mutableStateOf(false) }

                CategoryChip(
                    text = text,
                    visible = visible,
                    selected = selected,
                    onClick = {
                        selected = !selected
                        if (selected) categoryCounter++ else categoryCounter--
                    }
                )
            }
        }
        ContinueButton(visible = visible, categoryCounter = categoryCounter)
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MainScreenPreview() {
    Cup1Theme {
        Surface(modifier = Modifier.fillMaxSize()) {
            MainScreen()
        }
    }
}