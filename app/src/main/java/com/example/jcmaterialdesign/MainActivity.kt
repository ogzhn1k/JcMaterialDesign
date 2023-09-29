package com.example.jcmaterialdesign

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jcmaterialdesign.ui.theme.JcMaterialDesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JcMaterialDesignTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PageNavigation()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JcMaterialDesignTheme {
    }
}

@Composable
fun PageNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "page"){
        composable("page"){
            DynamicListingRowPage(navController = navController)
        }
        composable("detail_page/{countryName}", arguments = listOf(
            navArgument("countryName"){type = NavType.StringType}
        )){
            val countryName = it.arguments?.getString("countryName")!!
            DetailedPage(countryName = countryName)
        }
    }
}
@Composable
fun DynamicListingRowPage(navController: NavController){
    val countryList = remember { mutableStateListOf("Turkey","Italy","Germany","Japan") }

    LazyRow{
        items(
            count = countryList.count(),
            itemContent = {
                val country = countryList[it]

                Card(modifier = Modifier
                    .padding(all = 5.dp)
                    .fillMaxWidth()) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable {
                        Log.e("Country","Country : ${country}")
                        navController.navigate("detail_page/${country}")
                    }) {
                        Row(verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(all = 10.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = country,modifier = Modifier
                                .padding(all = 5.dp)
                                .clickable {
                                    Log.e("Country", "Country with Text : ${country}")
                                })
                            OutlinedButton(onClick = {
                                Log.e("Country","Country with Button : ${country}")
                            }) {
                                Text(text = "Select Country")
                            }
                        }
                    }
                }
            }
        )
    }
}

@Composable
fun DynamicListingPage(navController: NavController){
    val countryList = remember { mutableStateListOf("Turkey","Italy","Germany","Japan") }

    LazyColumn{
        items(
            count = countryList.count(),
            itemContent = {
                val country = countryList[it]

                Card(modifier = Modifier
                    .padding(all = 5.dp)
                    .fillMaxWidth()) {
                    Row(modifier = Modifier.clickable {
                        Log.e("Country","Country : ${country}")
                        navController.navigate("detail_page/${country}")
                    }) {
                        Row(verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(all = 10.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = country,modifier = Modifier
                                .padding(all = 5.dp)
                                .clickable {
                                    Log.e("Country", "Country with Text : ${country}")
                                })
                            OutlinedButton(onClick = {
                                Log.e("Country","Country with Button : ${country}")
                            }) {
                                Text(text = "Select Country")
                            }
                        }
                    }

                }
            }
        )
    }
}

@Composable
fun ConstantListingPage2(){
    LazyRow {
        item {
            Card(modifier = Modifier
                .padding(all = 5.dp)
                .size(100.dp)
            ) {
                Row (modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        Log.e("List", "Sun is clicked")
                    }, horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all = 10.dp)) {
                        Image(painter = painterResource(id = R.drawable.sun_image_24),
                            contentDescription = "")
                        Text(text = "Sun", modifier = Modifier.padding(all = 5.dp))
                    }
                }
            }
        }
        item {
            Card(modifier = Modifier
                .padding(all = 5.dp)
                .size(100.dp)
            ) {
                Row (modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        Log.e("List", "Sun is clicked")
                    }, horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all = 10.dp)) {
                        Image(painter = painterResource(id = R.drawable.moon_image),
                            contentDescription = "")
                        Text(text = "Moon", modifier = Modifier.padding(all = 5.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun ConstantListingPage(){
    LazyColumn{
        item {
            Card(modifier = Modifier
                .padding(all = 5.dp)
                .fillMaxWidth()
            ) {
                Row (modifier = Modifier.clickable {
                    Log.e("List","Sun is clicked")
                }
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all = 10.dp)) {
                        Image(painter = painterResource(id = R.drawable.sun_image_24),
                            contentDescription = "")
                        Text(text = "Sun", modifier = Modifier.padding(all = 5.dp))
                    }
                }
            }
        }
        item {
            Card(modifier = Modifier
                .padding(all = 5.dp)
                .fillMaxWidth()
            ) {
                Row (modifier = Modifier.clickable {
                    Log.e("List","Moon is clicked")
                }
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all = 10.dp)) {
                        Image(painter = painterResource(id = R.drawable.moon_image),
                            contentDescription = "")
                        Text(text = "Moon", modifier = Modifier.padding(all = 5.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun CardPage(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center) {
        Card(modifier = Modifier
            .padding(all = 10.dp)
            .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                contentColor = Color.White,
                containerColor = Color.Blue
            ),
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            border = BorderStroke(1.dp,Color.Magenta),
            ) {
                Row (horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.clickable {
                        Log.e("Card","Card is clicked")
                }) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Image(painter = painterResource(id = R.drawable.sunny_image), contentDescription = "")
                        Text(text = "Sunny",color = Color.White, fontSize = 36.sp)
                    }
                }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarSearchingPage() {
    val isSearchingOk = remember { mutableStateOf(false) }
    val searchTf = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if(isSearchingOk.value){
                            TextField(
                                value = searchTf.value,
                                onValueChange = {
                                    searchTf.value = it
                                    Log.e("TopBarSearch","Search : $it")
                                },
                                label = {Text(text = "Search", color = Color.White)},
                                colors = TextFieldDefaults.textFieldColors(
                                    containerColor = Color.Transparent,
                                    focusedLabelColor = Color.White,
                                    focusedIndicatorColor = Color.White,
                                    unfocusedLabelColor = Color.White,
                                    unfocusedIndicatorColor = Color.White
                                )
                            )
                        } else {
                            Text(text = "Title", color = Color.White)
                        }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.ogi_color)
                ),
                actions = {
                    if (isSearchingOk.value){
                        IconButton(onClick = {
                            isSearchingOk.value = false
                            searchTf.value = ""
                        }) {
                            Icon(painter = painterResource(id = R.drawable.close_image),
                                contentDescription = "")
                        }
                    } else{
                        IconButton(onClick = {
                            isSearchingOk.value = true
                        }) {
                            Icon(painter = painterResource(id = R.drawable.search_image),
                                contentDescription = "")
                        }
                    }
                    IconButton(onClick = {
                        Log.e("Info","Info is selected")
                    }) {
                        Icon(painter = painterResource(id = R.drawable.info_image),
                            contentDescription = "")
                    }
                }
            )
        },
        content = {
        }
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarPage() {
    val menuStartingControl = remember { mutableStateOf(false) }
    val isSearchingOk = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
                 TopAppBar(
                     title = {
                         Column {
                             Text(text = "Title")
                             Text(text = "Sub Title", fontSize = 12.sp)
                         }
                             },
                     colors = TopAppBarDefaults.mediumTopAppBarColors(
                         containerColor = colorResource(id = R.color.mainColor),
                         titleContentColor = colorResource(id = R.color.white)
                     ),
                     actions = {
                         Text(
                             text = "Exit",
                             modifier = Modifier.clickable {
                                 Log.e("TopBar","Exit is selected")
                             })

                         IconButton(onClick = {
                             Log.e("TopBar","Info is selected")
                         }) {
                             Icon(painter = painterResource(id = R.drawable.info_image),
                                 contentDescription = "")
                         }

                         IconButton(onClick = {
                             menuStartingControl.value = true
                         }) {
                             Icon(painter = painterResource(id = R.drawable.more_image),
                                 contentDescription = "")
                         }
                         DropdownMenu(
                             expanded = menuStartingControl.value,
                             onDismissRequest = {
                                 menuStartingControl.value = false
                             }) {
                             DropdownMenuItem(
                                 text = { Text(text = "Delete") },
                                 onClick = {
                                     Log.e("Delete","Delete is selected")
                                     menuStartingControl.value = false
                                 })
                             DropdownMenuItem(
                                 text = { Text(text = "Update") },
                                 onClick = {
                                     Log.e("Update","Update is selected")
                                     menuStartingControl.value = false
                                 })
                         }
                     }
                 )
        },
        content = {
        }
    )
}

