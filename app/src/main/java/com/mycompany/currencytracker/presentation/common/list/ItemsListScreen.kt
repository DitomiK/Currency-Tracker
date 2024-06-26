package com.mycompany.currencytracker.presentation.common.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mycompany.currencytracker.presentation.common.emptyUiText
import eu.bambooapps.material3.pullrefresh.PullRefreshIndicator
import eu.bambooapps.material3.pullrefresh.pullRefresh
import eu.bambooapps.material3.pullrefresh.rememberPullRefreshState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> ItemsListScreen(
    header: @Composable () -> Unit = {},
    stateValue: IListState<T>,
    list: List<T>,
    key: ((index: Int, item: T) -> Any)? = null,
    onListRefresh: () -> Unit,
    itemContent: @Composable (
        item: T,
        currentNumber: Int
    ) -> Unit
) {
    val pullRefreshState =
        rememberPullRefreshState(
            refreshing = stateValue.isLoading,
            onRefresh = { onListRefresh() }
        )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(pullRefreshState)
    ) {
        Column {
            header()
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                itemsIndexed(list, key = key) { index, crypto ->
                    itemContent(crypto, index + 1)
                }
            }

        }
        PullRefreshIndicator(
            refreshing = stateValue.isLoading,
            state = pullRefreshState,
            modifier = Modifier
                .align(Alignment.TopCenter)

        )
        if (stateValue.error != emptyUiText) {
            Text(
                text = stateValue.error.asString()
            )
            PullRefreshIndicator(
                refreshing = stateValue.isLoading,
                state = pullRefreshState,
                modifier = Modifier
                    .align(Alignment.TopCenter)
            )
        }
    }
}
