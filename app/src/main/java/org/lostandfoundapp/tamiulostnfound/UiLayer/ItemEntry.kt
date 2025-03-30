package org.lostandfoundapp.tamiulostnfound.UiLayer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import org.lostandfoundapp.tamiulostnfound.DataLayer.Item

@Composable
fun ItemEntry(
    item: Item,
    onNavigateToClaimScreen: () -> Unit,
    onNavigateToReportScreen: () -> Unit
) {
    val status: String
    val lnfStatus: Color
    val reportedOrClaimed: String
    val date: String
    val categoryString: String
    val actionButtonText: String
    val buttonColors: ButtonColors

    if (item.dateClaimed == null) {
        status = "Lost"
        lnfStatus = Color.Red
        reportedOrClaimed = "Date Reported:"
        date = item.dateReported
        actionButtonText = "Claim"
        buttonColors = ButtonColors(
            containerColor = Color.Red,
            contentColor = Color.White,
            disabledContentColor = Color.Red,
            disabledContainerColor = Color.Gray
        )
    } else {
        status = "Found"
        lnfStatus = Color.Green
        reportedOrClaimed = "Date Claimed:"
        date = item.dateClaimed
        actionButtonText = "Report"
        buttonColors = ButtonColors(
            containerColor = Color.Blue,
            contentColor = Color.White,
            disabledContentColor = Color.Blue,
            disabledContainerColor = Color.Gray
        )
    }

    categoryString = when(item.category) {
        1 -> "Apparel"
        2 -> "Apparel"
        3 -> "Finance"
        4 -> "Entertainment"
        5 -> "Jewelry"
        else -> "Other"
    }

    Column {
        Image(
            painter = painterResource(id = item.resource),
            contentDescription = "An image of ${item.name}",
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 300.dp)
        )
        Row(
            modifier = Modifier.padding(0.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Column (modifier = Modifier.padding(6.dp)){
                Text(
                    text = item.name,
                    modifier = Modifier.padding(12.dp, 3.dp),
                    color = Color.Black,
                    textDecoration = TextDecoration.Underline,
                    fontWeight = FontWeight.Bold
                )
                Row {
                    Text(
                        text = "Status:",
                        modifier = Modifier.padding(top = 0.dp, bottom = 0.dp, start = 12.dp, end = 6.dp),
                        color = Color.Black
                    )
                    Text(
                        text = status,
                        modifier = Modifier.padding(0.dp, 0.dp),
                        color = lnfStatus,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row {
                    Text(
                        text = reportedOrClaimed,
                        modifier = Modifier.padding(top = 0.dp, bottom = 0.dp, start = 12.dp, end = 6.dp),
                        color = Color.Black
                    )
                    Text(
                        text = date,
                        modifier = Modifier.padding(0.dp, 0.dp),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row {
                    Text(
                        text = "Category: ",
                        modifier = Modifier.padding(top = 0.dp, bottom = 0.dp, start = 12.dp, end = 6.dp),
                        color = Color.Black
                    )
                    Text(
                        text = categoryString,
                        modifier = Modifier.padding(0.dp, 0.dp),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Button(
                onClick = if (item.dateClaimed == null) onNavigateToClaimScreen else onNavigateToReportScreen,
                modifier = Modifier.padding(end = 24.dp),
                colors = buttonColors
            ) {
                Text(actionButtonText)
            }
        }
    }
}

