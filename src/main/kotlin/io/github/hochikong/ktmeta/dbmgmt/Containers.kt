/**
 * @author Hochikong
 * This is container file, contains classes and data classes
 */
package io.github.hochikong.ktmeta.dbmgmt

import io.github.hochikong.ktmeta.predefined.ConvertError
import io.github.hochikong.ktmeta.predefined.SupportedDBs
import me.liuwj.ktorm.database.SqlDialect
import me.liuwj.ktorm.support.postgresql.PostgreSqlDialect
import me.liuwj.ktorm.support.sqlite.SQLiteDialect


/**
 * Data class used for keeping database configurations.
 *
 * DDL for reference:
 * ```SQL
 * CREATE TABLE registration(
 *  id INTEGER PRIMARY KEY AUTOINCREMENT ,
 *  db TEXT NOT NULL ,
 *  user TEXT,
 *  password TEXT,
 *  name TEXT NOT NULL UNIQUE,
 *  description TEXT NOT NULL ,
 *  url TEXT NOT NULL UNIQUE ,
 *  protected INTEGER NOT NULL ,
 *  CONSTRAINT db_type_check CHECK ( db in ('Sqlite', 'Postgresql') ),
 *  CONSTRAINT is_protected CHECK ( protected in (0, 1) )
 * );
 * ```
 */
data class DBConfigContainer(
    val type: SupportedDBs,
    val name: String,
    val desc: String,
    val url: String,
    val username: String,
    val password: String
) {
    val protected = password != "null"
    val dialect: SqlDialect = when (type) {
        SupportedDBs.SQLite -> {
            SQLiteDialect()
        }
        SupportedDBs.PostgreSQL -> {
            PostgreSqlDialect()
        }
        SupportedDBs.NotSupported -> {
            throw ConvertError("DBConfigContainer -> attr_dialect said: This database not supported.")
        }
    }

    val dataSource: String = when (type) {
        SupportedDBs.PostgreSQL -> SupportedDBs.PostgreSQL.dataSource
        SupportedDBs.SQLite -> SupportedDBs.SQLite.dataSource
        SupportedDBs.NotSupported -> throw ConvertError("DBConfigContainer -> attr_dataSource said: This database not supported")
    }
    val jdbcDriver: String = type.jdbcDriver
}

/**
 * Generate catalog by the return of Maintainer.queryAllRows
 * */
object DBRegCatalog {
    private var catalog: MutableMap<String, RegRow> = mutableMapOf()

    fun updateCatalog(queryResult: List<List<Any>>?): Boolean {
        // refresh
        if (catalog.isNotEmpty()) {
            catalog = mutableMapOf()
        }

        if (queryResult != null) {
            for (row in queryResult) {
                val tmp = row.regOut()
                catalog[tmp.name] = tmp
            }
            return true
        }
        return false
    }

    fun keys(): MutableSet<String> {
        return catalog.keys
    }

    operator fun get(key: String): RegRow? {
        if (key !in catalog.keys) return null
        return catalog[key]
    }

}