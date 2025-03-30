package org.lostandfoundapp.tamiulostnfound.UiLayer

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.lostandfoundapp.tamiulostnfound.itemRepo

@Composable
fun MainScreen() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "add"
    ) {
        composable("main") {
            GeneralScaffold(
                content = {
                    LazyColumn {
                        items(itemRepo.getItems()) { item ->
                            ItemEntry(
                                item = item,
                                onNavigateToClaimScreen = { navController.navigate("claim") },
                                onNavigateToReportScreen = { navController.navigate("report") },
                            )
                        }
                    }
                },
                navController = navController,
                mainScreen = true)
        }

        composable("add") {
            GeneralScaffold(
                content = { AddForm(navController) },
                navController = navController,
                title = "Report Lost Item")
        }

        composable("claim") {
            GeneralScaffold(
                content = { ClaimForm(navController) },
                navController = navController,
                title = "Claim Item Form")
        }

        composable("report") {
            GeneralScaffold(
                content = { ReportForm(navController) },
                navController = navController,
                title = "Report Fraudulent Claim")
        }

        composable("search") {

        }

        composable("filter") {

        }
    }


}