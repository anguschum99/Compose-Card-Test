package com.example.lazytest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.*
import androidx.compose.material3.CardDefaults.shape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lazytest.data.Datasource
import com.example.lazytest.ui.theme.LazyTestTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CunnyApp()
                }
            }
        }
    }
}

@Composable
fun CunnyApp(){
    val layoutDirection = LocalLayoutDirection.current
    Surface(modifier = Modifier
        .fillMaxSize()
        .statusBarsPadding()
        .padding(
            start = WindowInsets.safeDrawing
                .asPaddingValues()
                .calculateStartPadding(layoutDirection),
            end = WindowInsets.safeDrawing
                .asPaddingValues()
                .calculateEndPadding(layoutDirection),
        ),
    ) {
        CunnyList(cunnyList = Datasource().loadCunny())
    }
}


@Composable
fun LazyCard(cunny: Cunny, modifier: Modifier = Modifier) {
    Card(
        border = BorderStroke(2.dp, androidx.compose.ui.graphics.Color.Black)
    ) {

        Row(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Surface(
                    shape = RoundedCornerShape(24.dp),
                ) {
                    Text(
                        text = "NEW MESSAGE",
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier
                            .padding(vertical = 4.dp, horizontal = 10.dp)
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = stringResource(id = cunny.stringResourceId),
                    fontSize = 30.sp,
                    style = MaterialTheme.typography.titleLarge
                    )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedButton(
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.White
                    ),

                    onClick = { /*TODO*/ }) {
                    Text(text = "RESPOND", fontWeight = FontWeight.Bold)
                    
                }
            }
            Surface(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.size(width = 100.dp, height = 140.dp)
            ) {
                Image(
                    painter = painterResource(id = cunny.imageResourceId) ,
                    contentDescription = null)
            }
        }

    }
}

@Composable
fun CunnyList(cunnyList: List<Cunny>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(cunnyList) { cunny ->
            LazyCard(cunny, modifier = Modifier.padding(8.dp))
        }
    }
}


@Preview
@Composable
private fun CunnyCardPV() {
    LazyCard(Cunny(R.string.Sensei, R.drawable._662300388983169))
}