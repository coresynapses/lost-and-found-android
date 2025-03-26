package org.lostandfoundapp.tamiulostnfound.DataLayer

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO


data class NetworkDataSource(
    val ktorClient: HttpClient = HttpClient(CIO),
)
