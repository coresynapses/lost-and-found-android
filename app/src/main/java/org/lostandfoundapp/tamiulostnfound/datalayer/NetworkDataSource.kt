package org.lostandfoundapp.tamiulostnfound.datalayer

import android.util.Log
import com.google.gson.Gson
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.cookies.AcceptAllCookiesStorage
import io.ktor.client.plugins.cookies.HttpCookies
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.runBlocking
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
data class ResponseItems(
    val items: List<ResponseItem>
)

class NetworkDataSource(
     var ktorClient: HttpClient? = HttpClient(CIO) {
         install(HttpCookies) {
             storage = AcceptAllCookiesStorage()
         }
         install(ContentNegotiation) {
             json(Json {
                 prettyPrint = true
                 isLenient = true
             })
         }
     },
     var items: ResponseItems? = null,
     val gson: Gson = Gson(),
) {
     fun getData(): ResponseItems? {
          runBlocking {
              val body = ktorClient!!.get("http://10.0.2.2:8080/android")
              Log.d("", "Response: ${body.bodyAsText()}")
              items = gson.fromJson(body.bodyAsText(), ResponseItems::class.java)

              for (item in items?.items!!) {
                  Log.d("", "Item: ${item.name}")
              }

//              val responseDataItems: ResponseItems = body.body()
//              if (!responseDataItems.items.isEmpty())
//                  items = responseDataItems
          }
          return items
     }

    fun reportLostItem(item: Item) {
        runBlocking {
            val body = ktorClient!!.post("http://10.0.2.2:8080/android-upload/") {
                setBody(
                    item.name         + "$" +
                    item.dateReported + "$" +
                    item.category
                )
            }
            Log.d("", "Response: ${body.bodyAsText()}")
        }
    }

    fun claimLostItem(claimDate: String) {
        runBlocking {
            val body = ktorClient!!.post("http://10.0.2.2:8080/android-claim/") {
                setBody(itemRepo.activeItem.name + "$" + claimDate)
            }
            Log.d("", "Claim Response: ${body.bodyAsText()}")
        }
    }

    fun reportFoundItem(reportDate: String) {
        runBlocking {
            val body = ktorClient!!.post("http://10.0.2.2:8080/android-report/") {
                setBody(itemRepo.activeItem.name + "$" + reportDate)
            }
            Log.d("", "Report Response: ${body.bodyAsText()}")
        }
    }
}
