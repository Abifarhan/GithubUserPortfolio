package com.abitask.githubuserportfolio.ui.theme.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.abitask.githubuserportfolio.domain.model.User

@Composable
fun UserItem(user: User, onClick: (String) -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { onClick(user.login) }
        .padding(12.dp)) {
        AsyncImage(model = user.avatarUrl, contentDescription = null, modifier = Modifier.size(56.dp))
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(text = user.login)
            user.login.let { Text(text = it) }
        }
    }
}