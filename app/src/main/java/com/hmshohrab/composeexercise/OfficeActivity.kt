package com.hmshohrab.composeexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.VideoCall
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hmshohrab.composeexercise.ui.theme.ComposeExerciseTheme

class OfficeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExerciseTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    OfficeScreen()
                }
            }
        }
    }
}

// in the below line, we are creating a
// model class for our data class.
data class ListModel(

    // in the below line, we are creating two variable
    // one is for language name which is string.
    val languageName: String,

    // next variable is for our
    // image which is an integer.
    val languageImg: Int,
)

@Preview(showBackground = true)
@Composable
fun OfficeScreen() {
    lateinit var courseList: List<ListModel>
    courseList = ArrayList<ListModel>()

    // in the below line, we are adding data to our list.
    courseList = courseList + ListModel("Expert in Advocate", R.drawable.ic_advocate)
    courseList = courseList + ListModel("Expert in Dead Writer", R.drawable.ic_advocate)
    courseList = courseList + ListModel("Expert in Sub Register", R.drawable.compose)
    courseList = courseList + ListModel("Expert in AC Land", R.drawable.ic_advocate)
    courseList = courseList + ListModel("Expert in Advocate", R.drawable.compose)
    courseList = courseList + ListModel("Expert in Dead Writer", R.drawable.ic_advocate)
    courseList = courseList + ListModel("Expert in Sub Register", R.drawable.compose)
    courseList = courseList + ListModel("Expert in AC Land", R.drawable.ic_advocate)


    Scaffold(topBar = {
        TopAppBar(elevation = 4.dp, title = {
            Text("I'm a TopAppBar")
        }, backgroundColor = MaterialTheme.colorScheme.background, navigationIcon = {
            IconButton(onClick = {/* Do Something*/ }) {
                Icon(Icons.Filled.ArrowBack, null)
            }
        }, actions = {
            IconButton(onClick = {/* Do Something*/ }) {
                Icon(Icons.Filled.Share, null)
            }
            IconButton(onClick = {/* Do Something*/ }) {
                Icon(Icons.Filled.Settings, null)
            }
        })
    }) {


        Column(modifier = Modifier.padding(it)) {

            LazyRow {
                itemsIndexed(courseList) { index, item ->
                    Card(modifier = Modifier
                        .width(180.dp)
                        .padding(5.dp)) {
                        Row(modifier = Modifier.fillMaxWidth().padding(start = 8.dp, top = 8.dp, end = 8.dp)) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color.Red)

                            ) {
                                Text(modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                                    textAlign = TextAlign.Center,
                                    text = "Live",
                                    color = Color.White,
                                    fontSize = 16.sp
                                )
                            }
                            Spacer(modifier = Modifier
                                .weight(1f))
                            Image(modifier = Modifier.size(25.dp),
                                painter = painterResource(id = item.languageImg),
                                contentDescription = "")


                        }
                        Text(
                            modifier = Modifier.padding(horizontal = 5.dp), maxLines = 2,
                            text = "${item.languageName}\n",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                        )
                        Text(
                            modifier = Modifier.padding(horizontal = 5.dp),
                            textAlign = TextAlign.Center,
                            text = "99 Tk",
                            color = Color.Red,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                        )
                        ElevatedButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
                            shape = RoundedCornerShape(25),
                            onClick = { /* ... */ },
                            // Uses ButtonDefaults.ContentPadding by default
                            contentPadding = it,
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)
                        ) {
                            // Inner content including an icon and a text label
                            Icon(
                                Icons.Default.VideoCall,
                                contentDescription = "Favorite", tint = Color.White
                            )
                            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                            Text("Take Service", fontSize = 16.sp)
                        }
                    }

                }
            }



            Column {
                BoxWithConstraints {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Excuse me",
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.compose_awesome),
                    contentDescription = "")
            }
        }

    }

}