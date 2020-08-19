import io.github.hochikong.ktmeta.dbmgmt.DBMgmt
import io.github.hochikong.ktmeta.dbmgmt.DBRegCatalog
import io.github.hochikong.ktmeta.dbmgmt.Maintainer
import io.github.hochikong.ktmeta.predefined.NoDatabasesIsAvailable
import io.github.hochikong.ktmeta.predefined.NoSuchDatabaseInRegistrationTable
import io.github.hochikong.ktmeta.predefined.SupportedDBs
import me.liuwj.ktorm.dsl.from
import me.liuwj.ktorm.dsl.insertAndGenerateKey
import me.liuwj.ktorm.dsl.select
import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import java.sql.DriverManager

object Demo : Table<Nothing>("demo") {
    val id = int("id").primaryKey()
    val name = varchar("name")
}

object PG : Table<Nothing>("sb") {
    val id = int("id").primaryKey()
    val name = varchar("name")
}


@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class TestDBMGMT {
    companion object {
        @JvmStatic
        @BeforeAll
        fun bA() {
            Class.forName("org.postgresql.Driver")
            val x =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/ktmetapg?user=ktmeta_test&password=ktmeta")
            x.createStatement().use {
                it.executeUpdate(
                    """
                    CREATE TABLE sb(
                        id BIGSERIAL PRIMARY KEY ,
                        name VARCHAR(20) NOT NULL UNIQUE
                    );
                """.trimIndent()
                )
            }
        }

        @JvmStatic
        @AfterAll
        fun aA() {
            Maintainer.dropTable()
            Class.forName("org.postgresql.Driver")
            val x =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/ktmetapg?user=ktmeta_test&password=ktmeta")
            x.createStatement().use {
                it.executeUpdate(
                    """
                    DROP TABLE sb;
                """.trimIndent()
                )
            }
            x.close()
            Class.forName("org.sqlite.JDBC")
            val y = DriverManager.getConnection("jdbc:sqlite:d1.db")
            y.createStatement().use {
                it.executeUpdate(
                    """
                    DROP TABLE demo;
                """.trimIndent()
                )
            }
            y.close()
        }
    }

    @Order(1)
    @Test
    fun testquery() {
        DBMgmt.queryReg()
        assertEquals(true, DBMgmt.regIsEmpty)
        assertEquals("catalog", DBMgmt.checkCatalog()[0])
        println(DBMgmt.checkCatalog())
        println(DBMgmt.currentDatabases)
        assertThrows<NoDatabasesIsAvailable> { DBMgmt.getConnection("sb") }
    }

    @Order(2)
    @Test
    fun testInsert() {
        val x = DBMgmt.addDatabase(
            SupportedDBs.SQLite,
            "sqlite_test",
            "the first sqlite db",
            "null",
            "null",
            "jdbc:sqlite:d1.db"
        )
        assertEquals(true, x)
        assertEquals(false, DBMgmt.regIsEmpty)
        println(DBRegCatalog.keys())
        val y = DBMgmt.addDatabase(
            SupportedDBs.PostgreSQL,
            "pg_test",
            "the first pg",
            "ktmeta_test",
            "ktmeta",
            "jdbc:postgresql://localhost:5432/ktmetapg"
        )
    }

    @Order(3)
    @Test
    fun testGetCon() {
        assertThrows<NoSuchDatabaseInRegistrationTable> { DBMgmt.getConnection("sb") }
        assertThrows<NoSuchDatabaseInRegistrationTable> { DBMgmt.getDatabase("sb") }
        assertThrows<NoSuchDatabaseInRegistrationTable> { DBMgmt.getPool("sb") }
    }

    @Order(4)
    @Test
    fun testGetCon2() {
        val x = DBMgmt.getConnection("sqlite_test")
        x.createStatement().use {
            it.execute(
                """
                create table demo(
                    id int primary key,
                    name text not null
                    );
            """.trimIndent()
            )
        }
        x.createStatement().use {
            it.executeUpdate(
                """
                insert into demo(id, name)
                values (1, 'sb');
            """.trimIndent()
            )
        }
        x.createStatement().use {
            val r = it.executeQuery(
                """
                select * from demo;
            """.trimIndent()
            )
            while (r.next()) {
                val id = r.getInt("id")
                assertEquals(1, id)
                val name = r.getString("name")
                assertEquals("sb", name)
                println("${r.getInt("id")}  ${r.getString("name")}")
            }
            r.close()
        }
        x.close()
    }

    @Order(5)
    @Test
    fun testGetDB() {
        val x = DBMgmt.getDatabase("sqlite_test")
        for (row in x.from(Demo).select()) {
            assertEquals(1, row[Demo.id])
            assertEquals("sb", row[Demo.name])
            println(row[Demo.id])
            println(row[Demo.name])
        }

        val y = DBMgmt.getPool("sqlite_test")
        for (row in y.from(Demo).select()) {
            assertEquals(1, row[Demo.id])
            assertEquals("sb", row[Demo.name])
            println(row[Demo.id])
            println(row[Demo.name])
        }
    }

    @Order(6)
    @Test
    fun testPG() {
        val tmp = mutableMapOf<Int, String>()
        val x = DBMgmt.getDatabase("pg_test")
        x.insertAndGenerateKey(PG) {
            it.name to "them"
        }
        x.insertAndGenerateKey(PG) {
            it.name to "him"
        }
        for (row in x.from(PG).select()) {
            tmp[row[PG.id] as Int] = row[PG.name] as String
        }
        assert(1 in tmp.keys)
        assert(2 in tmp.keys)
        assertEquals("them", tmp[1])
        assertEquals("him", tmp[2])
        DBMgmt.getConnection("pg_test").createStatement().use {
            it.executeUpdate(
                """
                DELETE FROM sb;
            """.trimIndent()
            )
        }
    }

    @Order(7)
    @Test
    fun testRemove() {
        assertEquals(false, DBMgmt.removeDatabase("nmsl"))
        assertEquals(true, DBMgmt.removeDatabase("pg_test"))
        println(DBRegCatalog.keys())
    }
}