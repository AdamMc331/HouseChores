@file:Suppress("ktlint:standard:filename")

package com.adammncneilly.housechores.shared.data.local

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.adammncneilly.housechores.shared.AppDatabase

/**
 * Create an instance of a [SqlDriver] for the Android platform.
 */
class AndroidDatabaseDriverFactory(
    private val context: Context,
) : DatabaseDriverFactory {
    override fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = AppDatabase.Schema,
            context = context,
            name = "TODO.db",
        )
    }
}
