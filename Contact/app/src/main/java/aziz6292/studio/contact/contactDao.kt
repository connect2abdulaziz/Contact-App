package aziz6292.studio.contact



import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addContact(contact: Contact): Long

    @Update
    suspend fun updateContact(contact: Contact): Int

    @Delete
    suspend fun deleteContact(contact: Contact): Int

    @Query("SELECT * FROM contacts WHERE name LIKE :query OR phoneNumber LIKE :query")
    fun searchContacts(query: String): List<Contact>

    @Query("SELECT * FROM contacts")
    suspend fun getAllContacts(): List<Contact>
}
