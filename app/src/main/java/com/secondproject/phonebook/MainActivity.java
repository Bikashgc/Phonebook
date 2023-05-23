package com.secondproject.phonebook;



import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private SQLiteDbHelper db;

    private EditText Id, Name, Phone;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new SQLiteDbHelper(this);

        Id = findViewById(R.id.id);
        Name = findViewById(R.id.name);
        Phone = findViewById(R.id.phone);

        result = findViewById(R.id.result);
    }
    public void onAddBtnClick(View view){
        String id = Id.getText().toString();
        String name = Name.getText().toString();
        String phone = Phone.getText().toString();

        if (id.equals("") || name .equals("") || phone.equals("")){
            Toast.makeText(
                    getApplicationContext(),
                    "All input fields are required",
                    Toast.LENGTH_SHORT
            ).show();
        }else {
            Contact contact = new Contact(
                    Integer.parseInt(id), name , phone
            );
            db.addContact(contact);
            Toast.makeText(
                    getApplicationContext(),
                    "Contact added successfully",
                    Toast.LENGTH_SHORT
            );
        }

    }
    public void onSelectBtnClick(View view){
        ArrayList<Contact> contacts = db.getContactList();

            result.setText("Contacts\n");
            result.append("............\n");
        for(Contact contact : contacts){
            result.append("Id: "+ contact.getId() + "\t");
            result.append("Name: "+ contact.getName() + "\t");
            result.append("Phone: "+ contact.getPhone() + "\n");
        }

    }
    public void onUpdateBtnClick(View view){

        String id = Id.getText().toString();
        String name = Name.getText().toString();
        String number = Phone.getText().toString();

        Contact contact = new Contact(Integer.parseInt(id), name, number);
        db.updateContact(contact);
        Toast.makeText(this, "Contact updated successfully", Toast.LENGTH_SHORT).show();

    }
    public void onDeleteBtnClick(View view){
        String id = Id.getText().toString();
        db.deleteContact(id);
        Toast.makeText(this, "Contact deleted successfully", Toast.LENGTH_SHORT).show();
    }


}
