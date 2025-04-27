package org.lostandfoundapp.tamiulostnfound.datalayer

import android.content.Context
import android.util.Log
import org.lostandfoundapp.tamiulostnfound.R

class ItemsRepository(
    private val networkSource: NetworkDataSource = NetworkDataSource(),
    private val storageSource: StorageDataSource = StorageDataSource(),
    private val items: ArrayList<Item> = arrayListOf(
        Item(name = "Shirt", dateReported = "2/3/2022", dateClaimed = null, category = 1, resource = R.drawable.shirt),
        Item(name = "Pants", dateReported = "2/3/2022", dateClaimed = "3/2/2022", category = 1, resource = R.drawable.pants),
        Item(name = "Jewel", dateReported = "2/3/2022", dateClaimed = null, category = 3, resource = R.drawable.jewel),
        Item(name = "Cards", dateReported = "2/3/2022", dateClaimed = "3/3/2023", category = 0, resource = R.drawable.cards),
        Item(name = "Other", dateReported = "2/3/2022", dateClaimed = null, category = 0, resource = R.drawable.other)
    ),
    var activeItem: Item = items[0]
) {
    fun setup(ctx: Context?) {
        val data = networkSource.getData()

        for (item in data?.items!!) {
            items.add(Item(
                name = item.name,
                dateReported = if (item.date.length > 10) item.date.substring(0, 10) else item.date,
                dateClaimed  = null,
                category = 0,
                resource = R.drawable.jewel
            ))
        }

//        storageSource.setupDatabase(ctx)
    }

    fun addItem(item: Item) {
        items.add(item)
//        storageSource.addItem(item)
    }

    fun getItemEntities() : List<ItemEntity> {
        return storageSource.getItems()
    }

    fun getItems() : List<Item> {
        return items
    }

    fun reportLostItem(item: Item) {
        Log.d("Report Lost Item", item.name)
        networkSource.reportLostItem(item)
        addItem(item)
    }

    fun claimLostItem(claimDate: String) {
        Log.d("Claim Lost Item", claimDate)
        Log.d("Claim Lost Item", "Active Item: ${activeItem.name}")
        networkSource.claimLostItem(claimDate)
        activeItem.dateClaimed = claimDate
    }

    fun reportFoundItem(reportDate: String) {
        Log.d("Report Found Item", reportDate)
        Log.d("Report Found Item", "Active Item: ${activeItem.name}")
        networkSource.reportFoundItem(reportDate)
    }
}

val itemRepo: ItemsRepository = ItemsRepository()