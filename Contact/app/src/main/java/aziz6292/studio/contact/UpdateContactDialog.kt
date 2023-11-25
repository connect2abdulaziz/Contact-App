package aziz6292.studio.contact

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import aziz6292.studio.contact.databinding.UpdateContactDialogBinding

class UpdateContactDialog(
    context: Context,
    private val contact: Contact,
    private val onUpdateContact: (String, String) -> Unit
) {

    // Use context.getSystemService to obtain LayoutInflater
    private val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private val binding = UpdateContactDialogBinding.inflate(inflater)

    private val dialog = AlertDialog.Builder(context)
        .setTitle("Update Contact")
        .setView(binding.root)
        .setPositiveButton("Update") { _, _ ->
            val updatedName = binding.etUpdatedContactName.text.toString()
            val updatedPhoneNumber = binding.etUpdatedContactPhoneNumber.text.toString()
            onUpdateContact(updatedName, updatedPhoneNumber)
        }
        .setNegativeButton("Cancel", null)
        .create()

    init {
        binding.etUpdatedContactName.setText(contact.name)
        binding.etUpdatedContactPhoneNumber.setText(contact.phoneNumber)
    }

    fun show() {
        dialog.show()
    }
}
