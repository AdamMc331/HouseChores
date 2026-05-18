package com.adammncneilly.housechores.shared.data.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.adammncneilly.housechores.shared.data.preferences.DATA_STORE_FILE_NAME
import com.adammncneilly.housechores.shared.data.preferences.createDataStore
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

/**
 * On iOS, we create the [DataStore] implementation by looking up
 * the preference file using [NSFileManager].
 */
@OptIn(ExperimentalForeignApi::class)
fun createIosDataStore(): DataStore<Preferences> {
    return createDataStore(
        producePath = {
            val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
                directory = NSDocumentDirectory,
                inDomain = NSUserDomainMask,
                appropriateForURL = null,
                create = false,
                error = null,
            )
            requireNotNull(documentDirectory).path + "/$DATA_STORE_FILE_NAME"
        },
    )
}
