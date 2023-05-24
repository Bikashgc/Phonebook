package com.secondproject.phonebook;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ContactListAdapter extends ArrayAdapter<Contact> {

    private final Activity context;
    private final ArrayList<Contact> contacts;

    public ContactListAdapter(Activity context, ArrayList<Contact> contacts) {
        super(context, R.layout.contact_item, contacts);
        this.context = context;
        this.contacts = contacts;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View contactView = inflater.inflate(R.layout.contact_item, null, true);

        TextView idTextView = contactView.findViewById(R.id.idTextView);
        TextView nameTextView = contactView.findViewById(R.id.nameTextView);
        TextView phoneTextView = contactView.findViewById(R.id.phoneTextView);

        Contact contact = contacts.get(position);
        idTextView.setText(String.valueOf(contact.getId()));
        nameTextView.setText(contact.getName());
        phoneTextView.setText(contact.getPhone());

        return contactView;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }
}
