package com.tech_freaks.datetimepicker

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tech_freaks.datetimepicker.ui.component.CustomDateTimePicker
import com.tech_freaks.datetimepicker.ui.theme.MyDateTimePickerTheme
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyDateTimePickerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StartEndDateTimeScreen()
                }
            }
        }
    }
}

@Composable
fun StartEndDateTimeScreen(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val startDateTimeState = remember { mutableStateOf(LocalDateTime.now()) }
    val endDateTimeState = remember { mutableStateOf(LocalDateTime.now()) }
    Column(modifier = modifier) {

        CustomDateTimePicker(
            title = "Start datetime",
            state = startDateTimeState
        )
        CustomDateTimePicker(
            title = "End datetime",
            state = endDateTimeState
        )
        Button(
            onClick = {
                Toast.makeText(
                    context,
                    "startDate: ${startDateTimeState.value}",
                    Toast.LENGTH_LONG
                ).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 24.dp,
                    start = 8.dp, end = 8.dp
                )
        ) {
            Text("Save")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartEndDateTimeScreenPreview() {
    MyDateTimePickerTheme {
        StartEndDateTimeScreen()
    }
}