package aziz6292.studio.contact

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactRepository(private val contactDao: ContactDao) {

    suspend fun addContact(contact: Contact): Long {
        return withContext(Dispatchers.IO) {
            contactDao.addContact(contact)
        }
    }

    suspend fun updateContact(contact: Contact): Int {
        return withContext(Dispatchers.IO) {
            contactDao.updateContact(contact)
        }
    }

    suspend fun deleteContact(contact: Contact): Int {
        return withContext(Dispatchers.IO) {
            contactDao.deleteContact(contact)
        }
    }

    fun searchContacts(query: String): List<Contact> {
        return contactDao.searchContacts(query)
    }

    suspend fun getAllContacts(): List<Contact> {
        return contactDao.getAllContacts()
    }
}
