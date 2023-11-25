package aziz6292.studio.contact


import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import aziz6292.studio.contact.databinding.DialogAddContactBinding

class AddContactDialog(context: Context, private val onContactAdded: (String, String) -> Unit) {

    private val binding = DialogAddContactBinding.inflate(LayoutInflater.from(context))
    private val dialog = AlertDialog.Builder(context)
        .setTitle("Add Contact")
        .setView(binding.root)
        .setPositiveButton("Add") { _, _ ->
            val name = binding.etContactName.text.toString()
            val phoneNumber = binding.etContactPhoneNumber.text.toString()
            onContactAdded(name, phoneNumber)
        }
        .setNegativeButton("Cancel", null)
        .create()

    init {
        dialog.setView(binding.root)
    }

    fun show() {
        dialog.show()
    }
}
