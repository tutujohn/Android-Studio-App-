package com.example.groupseven;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class DialogThing extends DialogFragment {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Retrieve the SharedPreferences using the Context from getActivity()
        preferences = getActivity().getSharedPreferences("Passwords", Context.MODE_PRIVATE);
        editor = preferences.edit();

        builder.setMessage("Delete all Saved Passwords?!")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Perform the action when "Yes" is clicked
                        editor.putString("tx1", "");
                        editor.putString("tx2", "");
                        editor.putString("tx3", "");
                        editor.putString("tx4", "");
                        editor.putString("tx5", "");
                        editor.putString("tx6", "");
                        editor.putString("tx7", "");
                        editor.putString("tx8", "");
                        editor.putString("tx9", "");
                        editor.apply();
                        Toast.makeText(getActivity(), "Passwords Deleted", Toast.LENGTH_SHORT).show();

                    }
                })
                .setNegativeButton("Wait.. what, No!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), "Danger Averted!", Toast.LENGTH_SHORT).show();
                        getActivity().finish();

                    }

                });
        return builder.create();
    }
}
