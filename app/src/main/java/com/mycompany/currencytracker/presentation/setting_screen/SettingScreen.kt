package com.mycompany.currencytracker.presentation.setting_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.mycompany.currencytracker.R
import com.mycompany.currencytracker.presentation.BottomBar
import com.mycompany.currencytracker.presentation.Navigate
import com.mycompany.currencytracker.presentation.Screen
import com.mycompany.currencytracker.presentation.TopBar
import com.mycompany.currencytracker.presentation.ui.theme.mainTextColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen(navController: NavHostController){
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Row(
            modifier = Modifier.padding(start = 18.dp, top = 16.dp, bottom = 16.dp)
        ){
            Text(
                text = stringResource(id = R.string.setting_my_account),
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                    fontWeight = FontWeight(400),
                    color = mainTextColor
                )
            )
        }
        Divider()
        Row(
            modifier = Modifier.padding(start = 18.dp, top = 16.dp, bottom = 16.dp)
        ){
            Text(
                text = stringResource(id = R.string.setting_dark_mode),
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                    fontWeight = FontWeight(400),
                    color = mainTextColor
                )
            )
        }
        Divider()
        Row(
            modifier = Modifier.padding(start = 18.dp, top = 16.dp, bottom = 16.dp)
                .clickable(onClick = { navController.navigate(Screen.SelectMainCurrencyScreen.route) }),
        ){
            Text(
                text = stringResource(id = R.string.setting_currency),
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                    fontWeight = FontWeight(400),
                    color = mainTextColor
                ),
            )
        }
        Divider()
        Row(
            modifier = Modifier.padding(start = 18.dp, top = 16.dp, bottom = 16.dp)
        ){
            Text(
                text = stringResource(id = R.string.setting_language),
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                    fontWeight = FontWeight(400),
                    color = mainTextColor
                )
            )
        }
        Divider()
    }
}