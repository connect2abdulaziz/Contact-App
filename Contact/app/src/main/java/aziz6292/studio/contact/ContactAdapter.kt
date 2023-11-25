package aziz6292.studio.contact

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import aziz6292.studio.contact.databinding.ItemContactBinding

class ContactAdapter(
    private val updateClickListener: (Contact) -> Unit,
    private val deleteClickListener: (Contact, () -> Unit) -> Unit,
    private val callClickListener: (Contact) -> Unit
) : ListAdapter<Contact, ContactAdapter.ContactViewHolder>(ContactDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding, this)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = getItem(position)
        holder.bind(contact)
    }

    class ContactViewHolder(
        private val binding: ItemContactBinding,
        private val adapter: ContactAdapter,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(contact: Contact) {
            binding.tvContactName.text = contact.name
            binding.tvContactPhoneNumber.text = contact.phoneNumber

            // Set click listener for the update button
            binding.ivUpdate.setOnClickListener {
                // Pass the clicked contact to the updateClickListener
                adapter.updateClickListener(contact)
            }

            // Set click listener for the delete button
            binding.ivDelete.setOnClickListener {
                // Pass the clicked contact and a callback to the deleteClickListener
                adapter.deleteClickListener(contact) {
                    // This callback will be invoked after the deletion is confirmed
                    // Update the UI or perform any other necessary tasks
                    adapter.submitList(adapter.currentList.toMutableList().apply {
                        // Remove the deleted contact from the list
                        remove(contact)
                    })
                }
            }

            // Set click listener for the call button
            binding.tvContactPhoneNumber.setOnClickListener {
                // Pass the clicked contact to the callClickListener
                adapter.callClickListener(contact)
            }
        }
    }

    private class ContactDiffCallback : DiffUtil.ItemCallback<Contact>() {
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }
    }
}
