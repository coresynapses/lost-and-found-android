package org.lostandfoundapp.tamiulostnfound.DataLayer

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*

@Serializable
data class ResponseItem(
     val name: String,
     val status: String,
     val description: String,
     val date: String,
     val category: String,
     val photo: String
)

@Serializable
data class ResponseItems(val items: List<ResponseItem>)

class NetworkDataSource(
     var ktorClient: HttpClient? = null,
     var items: ResponseItems? = null
) {
     fun getData(): ResponseItems? {

         ktorClient = HttpClient(CIO) {
             install(ContentNegotiation) {
                 json(Json {
                     prettyPrint = true
                     isLenient = true
                 })
             }
         }

          runBlocking {
               val body = ktorClient!!.get("http://10.0.2.2:8080/android/")
               Log.d("", "Response: ${body.bodyAsText()}")
               items = body.body()
          }


          return null
     }
}
