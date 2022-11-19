package com.hmshohrab.composeexercise

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hmshohrab.composeexercise.databinding.ActivityXmlBinding
import com.hmshohrab.composeexercise.ui.theme.ComposeExerciseTheme

class XmlActivity : AppCompatActivity() {
    private lateinit var binding: ActivityXmlBinding

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityXmlBinding.inflate(layoutInflater)
            .apply {
                composeView.setContent {
                    ComposeExerciseTheme() {
                        // A surface container using the 'background' color from the theme
                        Surface(modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colorScheme.background) {
                            Scaffold(/* ... */) { contentPadding ->
                                // Screen content
                                Box(modifier = Modifier.padding(contentPadding)) {

                                    ElevatedButton(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(5.dp),
                                        shape = RoundedCornerShape(25),
                                        onClick = {
                                            val intent =
                                                Intent(this@XmlActivity, OfficeActivity::class.java)
                                            startActivity(intent)
                                        },
                                        // Uses ButtonDefaults.ContentPadding by default
                                        contentPadding = PaddingValues(5.dp),
                                        colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)
                                    ) {
                                        // Inner content including an icon and a text label
                                        Icon(
                                            Icons.Default.Call,
                                            contentDescription = "Favorite", tint = Color.White
                                        )
                                        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                                        Text("Take Service", fontSize = 16.sp)
                                    }
                                }
                            }
                        }
                    }

                }
            }

        setContentView(binding.root)
    }
}