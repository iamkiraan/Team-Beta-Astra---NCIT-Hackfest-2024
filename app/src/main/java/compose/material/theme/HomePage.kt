package compose.material.theme

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row


import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun HomePage(){
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .clip(RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp))
                    .height(35.dp)
                ,
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF3b4995),
                    titleContentColor = Color.White,
                ),
                title = {


                },
                actions = {
                },
            )
        },

        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)),
                containerColor = Color(0xff3b4995),
                contentColor = Color.White,
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ){
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Home, contentDescription = "home",
                                modifier=Modifier.size(50.dp)
                        )
                    }
//                    IconButton(onClick = { /*TODO*/ }) {
//                        Icon(imageVector = Icons.Default.LocationOn, contentDescription = "Map location")
//                    }



                    FloatingActionButton(modifier = Modifier
                        .padding(bottom = 2.dp)
                        //.border(1.dp, Color.Black)
                        .size(65.dp)
                        .clip(
                            RoundedCornerShape(
                                topStart = 35.dp,
                                topEnd = 35.dp,
                                bottomStart = 35.dp,
                                bottomEnd = 35.dp
                            )
                        )
                        ,
                        onClick = {  },
                        containerColor = Color(0xffed1c24),
                        //containerColor = Color.White,
                        contentColor = Color.White
                    ) {
                        Image(painter = painterResource(id = R.drawable.camera), contentDescription =null,
                                modifier=Modifier.size(49.dp))
                    }

//                    IconButton(onClick = { /*TODO*/ }) {
//                        Icon(imageVector = Icons.Default.Share, contentDescription = "share feedback")
//                    }

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Account",
                        modifier=Modifier.size(50.dp))
                    }
                }

            }
        },


    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        )
        {


        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(0xff3b4995),
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomStart = 30.dp,
                        bottomEnd = 30.dp
                    )
                )

        ) {
            //to load gif image
            val imageLoader = ImageLoader.Builder(LocalContext.current)
                .components {
                    if (SDK_INT >= 28) {
                        add(ImageDecoderDecoder.Factory())
                    } else {
                        add(GifDecoder.Factory())
                    }
                }
                .build()


                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .fillMaxWidth()

                ){

                    Image(painter = painterResource(id = R.drawable.police_logo), contentDescription ="logo",
                        modifier= Modifier
                            .size(115.dp)
                            .padding(horizontal = 15.dp)
                    )


                    Image(
                        painter = rememberAsyncImagePainter(R.drawable.flag, imageLoader),
                        contentDescription = "flag",
                        modifier = Modifier
                            .size(110.dp)
                            .padding(top = 0.dp),

                    )
                }
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),

            ){


                Text(
                    "गोरेटो",
                    fontSize = 50.sp,

                )
                Text(
                    "''तपाई हाम्रै साथी''",
                    fontSize = 20.sp
                )
            }

        }


            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier=Modifier.padding(top=15.dp,bottom=2.dp)
            ) {

                //Map card
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xff3b4995),
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .width(193.dp)
                        .height(200.dp)
                        .clip(
                            RoundedCornerShape(
                                topStart = 0.dp,
                                topEnd = 0.dp,
                                bottomStart = 30.dp,
                                bottomEnd = 30.dp
                            )
                        )
                        .padding(horizontal = 15.dp)
                ){
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier= Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    ){
                    Image(painter = painterResource(id = R.drawable.map), contentDescription ="map",
                        modifier=Modifier.size(66.dp))
                    Text(text = "Near Police",
                        fontSize = 27.sp)
                        Text(text = "Station",
                            fontSize = 27.sp)
                    }

                }

                //Calling card
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xff3b4995),
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .width(193.dp)
                        .height(200.dp)
                        .clip(
                            RoundedCornerShape(
                                topStart = 0.dp,
                                topEnd = 0.dp,
                                bottomStart = 30.dp,
                                bottomEnd = 30.dp
                            )
                        )
                        .padding(horizontal = 10.dp)
                ){
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier= Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    ) {
                        Icon(Icons.Default.Call, contentDescription = "Call",
                            modifier=Modifier.size(66.dp))

                        Text(text = "Call Now",
                            fontSize = 27.sp)
                    }

                }
            }
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xff3b4995),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .width(405.dp)
                    .height(200.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 0.dp,
                            topEnd = 0.dp,
                            bottomStart = 30.dp,
                            bottomEnd = 30.dp
                        )
                    )
                    .padding(horizontal = 15.dp)
                    .padding(top = 10.dp)
            ){


                //feedback section
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                ){

                    var text by remember{mutableStateOf("")}
                
                Text(text = "Feedback",
                    fontSize = 27.sp)


                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    modifier = Modifier
                        .width(365.dp)
                        .height(100.dp)
                        .padding(bottom = 5.dp)
                        .padding(horizontal = 10.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        cursorColor =Color.White,

                    ),
                    label = { Text(text = "Give your feedback here",color=Color.Gray) },
                    textStyle = TextStyle(color=Color.White)
                )


                ElevatedButton(onClick = {  },
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 20.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xffffcb08),
                        contentColor = Color.White)) {
                    Text("Send",
                        fontSize=25.sp
                        )
                }
                }



            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewHome(){
    HomePage()
}
