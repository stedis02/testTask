package com.example.testtaskforinternship.presentation.presentation.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class SayHelloFragment() : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            var name = ""
            val args = arguments
            if (args != null) {
              name  = args.getString("say_hello").toString()
            }
            val builder = AlertDialog.Builder(it)
            builder.setMessage(name)
                .setPositiveButton("ok",
                    DialogInterface.OnClickListener { dialog, id ->
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}