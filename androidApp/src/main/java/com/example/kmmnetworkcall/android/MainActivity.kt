package com.example.kmmnetworkcall.android

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kmmnetworkcall.NetworkCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var state by remember {
                mutableStateOf("Hello")
            }
            val coroutineScope = rememberCoroutineScope()
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingView(state) {
                        try {
                            coroutineScope.launch(Dispatchers.Main) {
                                state = getData()
                            }
                        } catch (e: Exception) {
                            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
                        }

                    }
                }
            }
        }
    }
}

suspend fun getData(): String {
    return NetworkCall().getData()
}

@Composable
fun GreetingView(text: String, onTextClicked: () -> Unit) {
    Text(
        text = text,
        modifier = Modifier
            .clickable {
                onTextClicked.invoke()
            }
    )
}

