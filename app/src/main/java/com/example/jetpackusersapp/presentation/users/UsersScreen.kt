package com.example.jetpackusersapp.presentation.users

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetpackusersapp.domain.model.User

@Composable
fun UsersScreen(viewModel: UsersViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    LazyColumn {
        items(state.users) { user ->
//            Divider(color = Color(0x44666666))
//            Text(text = user.name)
            ListItem(user)
        }
    }
}

@Composable
fun ListItem(user: User) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .height(60.dp)
            .background(color = Color.Gray)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
        ) {
            ListText(user.id.toString())
            ListText(user.name)
//            Text(
//                modifier = Modifier
//                    .align(CenterVertically),
//                text = user.id
//            )
//            Text(
//                modifier = Modifier
//                    .padding(horizontal = 16.dp)
//                    .align(CenterVertically),
//                text = user.name,
//                color = Color.White,
//                fontSize = 16.sp
//            )
        }
    }
}

@Composable
fun ListText(text: String) {
    Text(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        text = text,
        color = Color.White,
        textAlign = TextAlign.Center
    )
}